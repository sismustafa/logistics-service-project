/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mustafasis.lojistik.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 *
 * @author Asus
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class OrderRequestDto {

    private double productWight;
    private String productType;
    private Long shipmentId;
    private Long customerId;

}
