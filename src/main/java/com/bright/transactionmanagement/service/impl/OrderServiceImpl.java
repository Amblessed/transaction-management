package com.bright.transactionmanagement.service.impl;

/*
 * @Project Name: transaction-management
 * @Author: Okechukwu Bright Onwumere
 * @Created: 06/04/2023
 */


import com.bright.transactionmanagement.dto.OrderRequest;
import com.bright.transactionmanagement.dto.OrderResponse;
import com.bright.transactionmanagement.entity.Order;
import com.bright.transactionmanagement.entity.Payment;
import com.bright.transactionmanagement.exception.PaymentException;
import com.bright.transactionmanagement.repository.OrderRepository;
import com.bright.transactionmanagement.repository.PaymentRepository;
import com.bright.transactionmanagement.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;


    @Override
    @Transactional()
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setStatus("IN-PROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment Card type not supported");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");

        return orderResponse;
    }
}
