package br.com.stoom.store.controller;

import br.com.stoom.store.business.OrderBO;
import br.com.stoom.store.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private static final Logger LOGGER = Logger.getLogger(OrderController.class.getName());

    @Autowired
    private OrderBO orderService;

    @GetMapping
    public ResponseEntity<Page<Order>> getAllOrders(@PageableDefault(size = 10) Pageable pageable) {
        LOGGER.info("Get all orders called, page: " + pageable.getPageNumber() + ", size: " + pageable.getPageSize());
        Page<Order> orders = orderService.getAllOrders(pageable);
        if (!orders.isEmpty())
            return new ResponseEntity<>(orders, HttpStatus.OK);
        else
            return new ResponseEntity<>(orders, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        LOGGER.info("Get order by ID called with id: " + id);
        Order order = orderService.getOrderById(id);
        if (order != null)
            return new ResponseEntity<>(order, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        LOGGER.info("Create order called with order: " + order);
        Order createdOrder = orderService.createOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        LOGGER.info("Update order called with id: " + id + " and order: " + order);
        Order updatedOrder = orderService.updateOrder(id, order);
        if (updatedOrder != null)
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        LOGGER.info("Delete order called with id: " + id);
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
