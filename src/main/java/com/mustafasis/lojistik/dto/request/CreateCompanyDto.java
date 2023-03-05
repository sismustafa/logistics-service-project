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

/**
 *
 * @author Asus
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCompanyDto {

    private String name;
    private String email;
    private String password;
    
}
