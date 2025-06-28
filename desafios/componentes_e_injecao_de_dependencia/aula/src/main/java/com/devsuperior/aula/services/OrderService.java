package com.devsuperior.aula.services;

import com.devsuperior.aula.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double total(Order order) {
        double shipment = shippingService.shipment(order.getBasic());
        return order.getTotal(shipment);
    }
}