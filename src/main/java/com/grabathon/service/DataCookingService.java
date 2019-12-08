package com.grabathon.service;

import com.grabathon.entities.Expense;
import com.grabathon.entities.ExpenseType;
import com.grabathon.entities.PaymentHistory;
import com.grabathon.entities.User;
import com.grabathon.enums.ExpenseAffectType;
import com.grabathon.enums.OccupationType;
import com.grabathon.repository.ExpenseRepository;
import com.grabathon.repository.ExpenseTypeRepository;
import com.grabathon.repository.PaymentHistoryRepository;
import com.grabathon.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Service
@Slf4j
public class DataCookingService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private ExpenseTypeRepository expenseTypeRepository;

    @Autowired
    private PaymentHistoryRepository paymentHistoryRepository;

    @Autowired
    private UserRepository userRepository;

    private final List<String> popularEmailServices = new ArrayList<String>() {{
        add("gmail"); add("yahoo"); add("outlook"); add("aol"); add("mail"); add("yandex"); add("gmx"); add("protonmail");
    }};

    private final List<String> mobileCodes = new ArrayList<String>() {{
        add("+84"); add("+855"); add("+856");
    }};

    public void cookData() {

        //  create users
        createUsers();

        //  create expense types
        createExpenseTypes();

        //  create payment history
        createPaymentHistory();

        //  create expenses
        createExpenses();

    }

    private void createUsers() {
        log.info("#createUsers :: beginning...");
        List<User> users = new ArrayList<>();
        List<String> allNames = readNamesFromDataDump();
        IntStream.range(1, 1001).forEach(i -> {
            log.info("#createUsers :: creating users. count : {}", i);
            Random random = new Random();
            String fName = allNames.get(random.nextInt(allNames.size()));
            String sName = allNames.get(random.nextInt(allNames.size()));

            users.add(User.builder()
                .emailId(generateEmail(fName, sName))
                .firstName(fName)
                .lastName(sName)
                .mobileNumber(generateMobileNumber())
                .monthlyIncomeInThousands(random.nextInt(200)+5)
                .occupationType(System.nanoTime() % 2 == 0 ? OccupationType.SALARIED : OccupationType.NON_SALARIED)
                .dob(generatePastDate())
            .build());
        });
        userRepository.saveAll(users);
        log.info("#createUsers :: done...");
    }

    private List<String> readNamesFromDataDump() {
        List<String> list = new ArrayList<>();
        String fileLoc = "src/main/resources/names.txt";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileLoc))));
            String temp;
            while ((temp = br.readLine()) != null) {
                String[] arr = temp.split("\\s+");
                list.addAll(Arrays.asList(arr));
            }
            br.close();
            return list;
        } catch (Exception e) {
            log.error("#readNamesFromDataDump :: OOPS! something went wrong while reading data dump! e : {}", e);
            throw new IllegalStateException(e.getMessage());
        }
    }

    private String generateEmail(String fName, String lName) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        String currentTs = String.valueOf(Instant.now().toEpochMilli());
        sb.append(fName.toLowerCase());
        if (random.nextInt(2) % 2 == 0) {
            sb.append(".");
        } else {
            sb.append("_");
        }
        sb.append(lName.toLowerCase());
        sb.append(currentTs.substring(4, currentTs.length()));
        sb.append("@");
        sb.append(popularEmailServices.get(random.nextInt(popularEmailServices.size())));
        sb.append(".");
        sb.append("com");
        return sb.toString();
    }

    private String generateMobileNumber() {
        Random random = new Random();
        int num = random.nextInt(mobileCodes.size());
        StringBuilder sb = new StringBuilder(mobileCodes.get(num));
        sb.append(String.valueOf(random.nextInt(8999999) + 1000000));
        return sb.toString();
    }

    private Instant generatePastDate() {
        Instant dob = ZonedDateTime.now(ZoneOffset.UTC).minusYears(new Random().nextInt(90)+10).toInstant();
        dob = dob.atZone(ZoneId.systemDefault()).minusMonths(new Random().nextInt(12)+1).toInstant();
        dob = dob.minus((long) new Random().nextInt(30)+1, ChronoUnit.DAYS);
        return dob;
    }

    private void createExpenseTypes() {
        List<ExpenseType> expenseTypes = new ArrayList<ExpenseType>(){{
            add(ExpenseType.builder().expenseValue("E-Commerce").effectType(ExpenseAffectType.POSITIVE).effectValue(BigDecimal.valueOf(10)).build());
            add(ExpenseType.builder().expenseValue("Gambling").effectType(ExpenseAffectType.NEGATIVE).effectValue(BigDecimal.valueOf(10)).build());
        }};
        //  ToDo : add at least 20 more expense types
        expenseTypeRepository.saveAll(expenseTypes);
    }

    private void createPaymentHistory() {
        log.info("#createPaymentHistory :: beginning...");
        List<User> userList = userRepository.findAll();
        List<PaymentHistory> paymentHistoryList = new ArrayList<>();
        userList.forEach(user -> {
            int countOfExpenses = new Random().nextInt(50)+10;
            log.info("#createPaymentHistory :: for user with id : {}, creating {} record(s) of paymentHistory", user.getId(), countOfExpenses);
            String ct = String.valueOf(System.nanoTime());
            IntStream.range(0, countOfExpenses).forEach(i-> {
                paymentHistoryList.add(PaymentHistory.builder()
                        .loanNumber(Integer.valueOf(ct.substring(9, ct.length()) + i))
                        .dueDate(generatePastDate())
                        .paymentDate(generatePastDate())
                        .amount((double) new Random().nextInt(100000) + 500)
                        .userId(user.getId())
                        .build());
            });
        });
        paymentHistoryRepository.saveAll(paymentHistoryList);
        log.info("#createPaymentHistory :: done...");
    }

    private void createExpenses() {
        log.info("#createExpenses :: beginning...");
        List<Expense> expenses = new ArrayList<>();
        List<User> userList = userRepository.findAll();
        List<ExpenseType> expenseTypes = expenseTypeRepository.findAll();
        Random random = new Random();
        userList.forEach(user -> {
            int countOfExpenses = new Random().nextInt(100) + 10;
            log.info("#createExpenses :: for user with id : {}, creating {} record(s) of expenses", user.getId(), countOfExpenses);
            String ct = String.valueOf(System.nanoTime());
            IntStream.range(0, countOfExpenses).forEach(i-> {
                expenses.add(Expense.builder().userId(user.getId()).expenseTypeId(expenseTypes.get(random.nextInt(expenseTypes.size())).getId())
                        .expenseTs(Instant.now()).amountSpent(BigDecimal.valueOf(random.nextInt(50000)+100)).build());
            });
        });
        expenseRepository.saveAll(expenses);
        log.info("#createExpenses :: done...");
    }

}
