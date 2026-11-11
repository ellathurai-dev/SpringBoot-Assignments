
package com.example.foodorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodorder.entity.FoodOrder;

public interface OrderRepository extends JpaRepository<FoodOrder, Long> {

}
