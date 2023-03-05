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
public class ShipmentResponse {

    private double price;
    private String target;
    private String out;
    private String outDate;
    private String companyName;
    private String companyMail;

}
