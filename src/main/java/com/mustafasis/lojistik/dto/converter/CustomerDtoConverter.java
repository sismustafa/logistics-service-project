/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mustafasis.lojistik.dto.converter;

import com.mustafasis.lojistik.dto.request.CustomerCreateDto;
import com.mustafasis.lojistik.model.Customer;
import org.springframework.stereotype.Component;

/**
 *
 * @author Asus
 */

@Component
public class CustomerDtoConverter {

    public Customer convert(CustomerCreateDto from) {
        Customer cus = new Customer();
        cus.setEmail(from.getEmail());
        cus.setName(from.getName());
        cus.setPassword(from.getPassword());
        return cus;
    }

}
