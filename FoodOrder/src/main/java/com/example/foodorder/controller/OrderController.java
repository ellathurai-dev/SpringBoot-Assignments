
package com.example.foodorder.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.example.foodorder.entity.FoodOrder;
import com.example.foodorder.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<FoodOrder> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public FoodOrder getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public FoodOrder addOrder(@Valid @RequestBody FoodOrder order) {
        return orderService.addOrder(order);
    }

    @PutMapping("/{id}")
    public FoodOrder updateOrder(
            @PathVariable Long id,
            @Valid @RequestBody FoodOrder order) {

        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {

        orderService.deleteOrder(id);

        return "Order deleted successfully";
    }

    @PatchMapping("/{id}")
    public FoodOrder patchOrder(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {

        return orderService.patchOrder(id, updates);
    }
}
