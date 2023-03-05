/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mustafasis.lojistik.dto.response;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 *
 * @author Asus
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class OrderResponseDto {

    private String productType;
    private double totalPrice;
    private double productWeight;

}
