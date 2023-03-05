/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mustafasis.lojistik.service;

import com.mustafasis.lojistik.dto.converter.CompanyDtoConverter;
import com.mustafasis.lojistik.dto.request.CreateCompanyDto;
import com.mustafasis.lojistik.model.Company;
import com.mustafasis.lojistik.repository.CompanyRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company create(CreateCompanyDto createCompanyDto) {
        return companyRepository.save(new CompanyDtoConverter().convert(createCompanyDto));
    }

    public Company getCompany(Long id) {
        return companyRepository.findById(id).orElseThrow();
    }

    public List<Company> allList() {
        return companyRepository.getAllCompany();
    }

}
