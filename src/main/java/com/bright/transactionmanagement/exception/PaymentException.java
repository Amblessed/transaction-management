package com.bright.transactionmanagement.exception;

/*
 * @Project Name: transaction-management
 * @Author: Okechukwu Bright Onwumere
 * @Created: 06/04/2023
 */


public class PaymentException extends RuntimeException{

    public PaymentException(String message) {
        super(message);
    }
}
