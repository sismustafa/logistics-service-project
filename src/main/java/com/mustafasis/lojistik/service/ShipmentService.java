/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mustafasis.lojistik.service;

import com.mustafasis.lojistik.Exception.ShipmentNotFoundException;
import com.mustafasis.lojistik.dto.converter.ShipmentRequestDtoConverter;
import com.mustafasis.lojistik.dto.converter.ShipmentResponseConverter;
import com.mustafasis.lojistik.dto.request.CreateShipmentDto;
import com.mustafasis.lojistik.dto.request.SelectShipmentDto;
import com.mustafasis.lojistik.dto.response.ShipmentResponse;
import com.mustafasis.lojistik.model.Company;
import com.mustafasis.lojistik.model.Shipment;
import com.mustafasis.lojistik.repository.ShipmentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Asus
 */
@Service
public class ShipmentService {
    
    private final ShipmentRepository shipmentRepository;
    private final CompanyService companyService;
    private final ShipmentResponseConverter shipmentResponseConverter;
    private final ShipmentRequestDtoConverter shipmentRequestDtoConverter;
    
    public ShipmentService(ShipmentRepository shipmentRepository,
            CompanyService companyService,
            ShipmentResponseConverter shipmentResponseConverter,
            ShipmentRequestDtoConverter shipmentRequestDtoConverter) {
        this.shipmentRepository = shipmentRepository;
        this.companyService = companyService;
        this.shipmentResponseConverter = shipmentResponseConverter;
        this.shipmentRequestDtoConverter = shipmentRequestDtoConverter;
    }
    
    public Shipment create(CreateShipmentDto createShipmentDto) {
        return shipmentRepository.save(shipmentRequestDtoConverter.convert(createShipmentDto));
    }
    
    public Shipment getById(Long id) {
        return shipmentRepository.findById(id).orElseThrow(() -> new ShipmentNotFoundException("Shipment Not Found"));
    }
    
    public List<ShipmentResponse> list() {
        return shipmentRepository.findAll().stream()
                .map(x -> shipmentResponseConverter.convert(x))
                .collect(Collectors.toList());
    }
    
    public List<ShipmentResponse> outAndTargetLocation(SelectShipmentDto dto) {
        return shipmentRepository.findByTargetLocationAndOutLocation(dto.getTarget(), dto.getOut()).stream()
                .map(x -> shipmentResponseConverter.convert(x))
                .collect(Collectors.toList());
    }
    
    public List<ShipmentResponse> outTargetLocationAndDate(SelectShipmentDto dto) {
        return shipmentRepository.findByTargetLocationAndOutLocationAndOutDate(dto.getTarget(), dto.getOut(), dto.getOutDate()).stream()
                .map(x -> shipmentResponseConverter.convert(x))
                .collect(Collectors.toList());
    }
    
}
