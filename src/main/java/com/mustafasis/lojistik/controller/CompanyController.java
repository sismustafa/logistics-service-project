/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mustafasis.lojistik.controller;

import com.mustafasis.lojistik.dto.request.CreateCompanyDto;
import com.mustafasis.lojistik.dto.request.TestRequestBody;
import com.mustafasis.lojistik.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping()
    public String getCompanyName() {
        return "Gelen deger bu ";
    }

    @GetMapping("/param")
    public String getCompanyName2(@RequestParam(name = "name") String deger) {
        return "gelen deger: " + deger;
    }

    @GetMapping("/path/{veri}")
    public String dasdf(@PathVariable String veri) {
        return "path variable   " + veri;
    }

    @GetMapping("son")
    public String dassfd(@RequestBody TestRequestBody bb) {
        return "gelen dgerler " + bb.getName() + " " + bb.getId();
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody CreateCompanyDto createCompanyDto) {
        return new ResponseEntity<>(companyService.create(createCompanyDto), HttpStatus.CREATED);
    }
    
    @GetMapping("alllist")
    public ResponseEntity<?> list(){
        return new ResponseEntity<>(companyService.allList(), HttpStatus.OK);
    }

}
