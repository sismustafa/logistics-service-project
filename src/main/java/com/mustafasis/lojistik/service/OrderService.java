/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mustafasis.lojistik.service;

import com.mustafasis.lojistik.dto.converter.OrderRequestDtoConverter;
import com.mustafasis.lojistik.dto.converter.OrderResponseDtoConverter;
import com.mustafasis.lojistik.dto.request.OrderRequestDto;
import com.mustafasis.lojistik.dto.response.OrderResponseDto;
import com.mustafasis.lojistik.dto.response.ShipmentResponse;
import com.mustafasis.lojistik.model.Customer;
import com.mustafasis.lojistik.model.Order;
import com.mustafasis.lojistik.model.Shipment;
import com.mustafasis.lojistik.repository.OrderRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ShipmentService shipmentService;
    private final CustomerService customerService;
    private final OrderResponseDtoConverter orderResponseDtoConverter;
    private final OrderRequestDtoConverter orderRequestDtoConverter;

    public OrderService(
            OrderRepository orderRepository,
            ShipmentService shipmentService,
            CustomerService customerService,
            OrderResponseDtoConverter orderResponseDtoConverter,
            OrderRequestDtoConverter orderRequestDtoConverter) {
        this.orderRepository = orderRepository;
        this.shipmentService = shipmentService;
        this.customerService = customerService;
        this.orderResponseDtoConverter = orderResponseDtoConverter;
        this.orderRequestDtoConverter = orderRequestDtoConverter;
    }

    public OrderResponseDto buy(OrderRequestDto dto) {
        return orderResponseDtoConverter.convert(orderRepository.save(orderRequestDtoConverter.convert(dto)));
    }

    public List<OrderResponseDto> ordersOfTheCustomer(Long customerId) {
        return orderRepository.findByCustomerId(customerId).stream()
                .map(s -> orderResponseDtoConverter.convert(s))
                .collect(Collectors.toList());

    }

}
