/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mustafasis.lojistik.dto.converter;

import com.mustafasis.lojistik.dto.response.OrderResponseDto;
import com.mustafasis.lojistik.model.Order;
import org.springframework.stereotype.Component;

/**
 *
 * @author Asus
 */
@Component
public class OrderResponseDtoConverter {

    public OrderResponseDto convert(Order from) {
        return new OrderResponseDto().builder()
                .productType(from.getProductType())
                .productWeight(from.getProductWeight())
                .totalPrice(from.getTotalPrice())
                .build();
    }

}
