/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mustafasis.lojistik.service;

import com.mustafasis.lojistik.Exception.CustomerNotFoundException;
import com.mustafasis.lojistik.dto.converter.CustomerDtoConverter;
import com.mustafasis.lojistik.dto.request.CustomerCreateDto;
import com.mustafasis.lojistik.dto.response.OrderResponseDto;
import com.mustafasis.lojistik.dto.response.ShipmentResponse;
import com.mustafasis.lojistik.model.Customer;
import com.mustafasis.lojistik.model.Order;
import com.mustafasis.lojistik.model.Shipment;
import com.mustafasis.lojistik.repository.CustomerRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final OrderService orderService;

    public CustomerService(CustomerRepository customerRepository, @Lazy OrderService orderService) {
        this.customerRepository = customerRepository;
        this.orderService = orderService;
    }

    public Customer create(CustomerCreateDto customerCreateDto) {
        return customerRepository.save(new CustomerDtoConverter().convert(customerCreateDto));
    }

    public Customer getById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer Not Found!"));
    }

    public List<OrderResponseDto> getOrdersOfTheCusomer(Long id) {

        return orderService.ordersOfTheCustomer(id);
    }
}
