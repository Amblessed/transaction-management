package com.bright.transactionmanagement.dto;

/*
 * @Project Name: transaction-management
 * @Author: Okechukwu Bright Onwumere
 * @Created: 06/04/2023
 */


import com.bright.transactionmanagement.entity.Order;
import com.bright.transactionmanagement.entity.Payment;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OrderRequest {

    private Order order;
    private Payment payment;

}
