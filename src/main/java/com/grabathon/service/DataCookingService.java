package com.grabathon.service;

import com.grabathon.repository.ExpenseRepository;
import com.grabathon.repository.ExpenseTypeRepository;
import com.grabathon.repository.PaymentHistoryRepository;
import com.grabathon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataCookingService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private ExpenseTypeRepository expenseTypeRepository;

    @Autowired
    private PaymentHistoryRepository paymentHistoryRepository;

    @Autowired
    private UserRepository userRepository;

    public void cookData() {



    }


}
