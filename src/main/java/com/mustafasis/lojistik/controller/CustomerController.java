/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mustafasis.lojistik.controller;

import com.mustafasis.lojistik.dto.request.CustomerCreateDto;
import com.mustafasis.lojistik.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerCreateDto customerCreateDto) {
        return new ResponseEntity<>(customerService.create(customerCreateDto), HttpStatus.CREATED);
    }

    @GetMapping("/_get/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.getById(id), HttpStatus.OK);
    }
    
    @GetMapping("/_getOrders/{id}")
    public ResponseEntity<?> ordersOfTheCustomer(@PathVariable Long id){
        return new ResponseEntity<>(customerService.getOrdersOfTheCusomer(id), HttpStatus.OK);
    }
    
  

}
