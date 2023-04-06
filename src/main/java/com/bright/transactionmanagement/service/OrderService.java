package com.bright.transactionmanagement.service;

/*
 * @Project Name: transaction-management
 * @Author: Okechukwu Bright Onwumere
 * @Created: 06/04/2023
 */


import com.bright.transactionmanagement.dto.OrderRequest;
import com.bright.transactionmanagement.dto.OrderResponse;

public interface OrderService {

    OrderResponse placeOrder(OrderRequest orderRequest);
}
