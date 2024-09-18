package org.example.backend.domain.orders.repository;

import org.example.backend.domain.orders.model.entity.Orders;
import org.example.backend.domain.orders.repository.querydsl.OrdersRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> , OrdersRepositoryCustom {

}
