/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mustafasis.lojistik.dto.converter;

import com.mustafasis.lojistik.dto.request.CreateShipmentDto;
import com.mustafasis.lojistik.model.Company;
import com.mustafasis.lojistik.model.Shipment;
import com.mustafasis.lojistik.service.CompanyService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 *
 * @author Asus
 */
@Component
public class ShipmentRequestDtoConverter {

    /**
     * Shipment s = new Shipment();
     * s.setOutLocation(createShipmentDto.getOut());
     * s.setTargetLocation(createShipmentDto.getTarget());
     * s.setStandartPrice(createShipmentDto.getPrice());
     * s.setOutDate(createShipmentDto.getOutDate()); Company c =
     * companyService.getCompany(createShipmentDto.getCompanyId());
     * s.setCompany(c);
     */
    private final CompanyService companyService;

    public ShipmentRequestDtoConverter(@Lazy CompanyService companyService) {
        this.companyService = companyService;
    }

    public Shipment convert(CreateShipmentDto from) {
        Shipment s = new Shipment();
        s.setOutLocation(from.getOut());
        s.setTargetLocation(from.getTarget());
        s.setStandartPrice(from.getPrice());
        s.setOutDate(from.getOutDate());
        Company c = companyService.getCompany(from.getCompanyId());
        s.setCompany(c);
        return s;
    }

}
