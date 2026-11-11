
package com.example.foodorder.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.foodorder.entity.FoodOrder;
import com.example.foodorder.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Get all orders
    public List<FoodOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get order by ID
    public FoodOrder getOrderById(Long id) {

        return orderRepository.findById(id)
                .orElseThrow(() ->
                    new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Order not found"
                    ));
    }

    // Add new order
    public FoodOrder addOrder(FoodOrder order) {
        return orderRepository.save(order);
    }

    // Update complete order
    public FoodOrder updateOrder(Long id, FoodOrder newOrder) {

        FoodOrder oldOrder = getOrderById(id);

        oldOrder.setCustomerName(newOrder.getCustomerName());
        oldOrder.setFoodItem(newOrder.getFoodItem());
        oldOrder.setQuantity(newOrder.getQuantity());
        oldOrder.setPrice(newOrder.getPrice());

        return orderRepository.save(oldOrder);
    }

    // Delete order
    public void deleteOrder(Long id) {

        FoodOrder order = getOrderById(id);

        orderRepository.delete(order);
    }
}
