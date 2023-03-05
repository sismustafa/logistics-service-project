/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mustafasis.lojistik.controller;

import com.mustafasis.lojistik.dto.request.CreateShipmentDto;
import com.mustafasis.lojistik.dto.request.SelectShipmentDto;
import com.mustafasis.lojistik.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus
 */
@RestController
@RequestMapping("shipment")
public class ShipmentController {

    @Autowired
    private ShipmentService shipmentService;

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody CreateShipmentDto createShipmentDto) {
        return new ResponseEntity<>(shipmentService.create(createShipmentDto), HttpStatus.CREATED);
    }

    @GetMapping("list")
    public ResponseEntity<?> list() {
        return new ResponseEntity<>(shipmentService.list(), HttpStatus.OK);
    }

    @PostMapping("outandtarget")
    public ResponseEntity<?> outAndTargetLocation(@RequestBody SelectShipmentDto selectShipmentDto) {
        return new ResponseEntity<>(shipmentService.outAndTargetLocation(selectShipmentDto), HttpStatus.OK);
    }
    
    @PostMapping("outandtargetanddate")
    public ResponseEntity<?> outTargetLocationAndDate(@RequestBody SelectShipmentDto selectShipmentDto) {
        return new ResponseEntity<>(shipmentService.outTargetLocationAndDate(selectShipmentDto), HttpStatus.OK);
    }

}
