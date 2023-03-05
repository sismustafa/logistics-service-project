/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mustafasis.lojistik.dto.converter;

import com.mustafasis.lojistik.dto.request.CreateCompanyDto;
import com.mustafasis.lojistik.model.Company;
import org.springframework.stereotype.Component;

/**
 *
 * @author Asus
 */

@Component
public class CompanyDtoConverter {

    public Company convert(CreateCompanyDto dto) {
        Company com = new Company();
        com.setCompanyName(dto.getName());
        com.setEmail(dto.getEmail());
        com.setPassword(dto.getPassword());
        return com;
    }

}
