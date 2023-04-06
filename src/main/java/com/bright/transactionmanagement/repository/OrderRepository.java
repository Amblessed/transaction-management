package com.bright.transactionmanagement.repository;

/*
 * @Project Name: transaction-management
 * @Author: Okechukwu Bright Onwumere
 * @Created: 06/04/2023
 */


import com.bright.transactionmanagement.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
