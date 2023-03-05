/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mustafasis.lojistik.dto.converter;

import com.mustafasis.lojistik.dto.response.ShipmentResponse;
import com.mustafasis.lojistik.model.Shipment;
import org.springframework.stereotype.Component;

/**
 *
 * @author Asus
 */
@Component
public class ShipmentResponseConverter {

    public ShipmentResponse convert(Shipment from) {
        return new ShipmentResponse().builder()
                .price(from.getStandartPrice())
                .out(from.getOutLocation())
                .target(from.getTargetLocation())
                .outDate(from.getOutDate())
                .companyName(from.getCompany().getCompanyName())
                .companyMail(from.getCompany().getEmail())
                .build();
    }

}
