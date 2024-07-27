package br.com.stoom.store.business.interfaces;

import br.com.stoom.store.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrderBO {
    Page<Order> getAllOrders(Pageable pageable);
    Order getOrderById(Long id);
    Order createOrder(Order order);
    Order updateOrder(Long id, Order order);
    void deleteOrder(Long id);
}