/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mustafasis.lojistik.dto.converter;

import com.mustafasis.lojistik.dto.request.OrderRequestDto;
import com.mustafasis.lojistik.model.Customer;
import com.mustafasis.lojistik.model.Order;
import com.mustafasis.lojistik.model.Shipment;
import com.mustafasis.lojistik.service.CustomerService;
import com.mustafasis.lojistik.service.ShipmentService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 *
 * @author Asus
 */
@Component
public class OrderRequestDtoConverter {

    private final ShipmentService shipmentService;
    private final CustomerService customerService;

    public OrderRequestDtoConverter(@Lazy ShipmentService shipmentService, @Lazy CustomerService customerService) {
        this.shipmentService = shipmentService;
        this.customerService = customerService;
    }

    public Order convert(OrderRequestDto from) {

        Customer c = customerService.getById(from.getCustomerId());
        Shipment s = shipmentService.getById(from.getShipmentId());

        Order o = new Order();
        o.setProductType(from.getProductType());
        o.setProductWeight(from.getProductWight());
        o.setTotalPrice(from.getProductWight() * s.getStandartPrice());
        o.setShipment(s);
        o.setCustomer(c);
        return o;
    }

}
