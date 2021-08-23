package com_gb_web.java_ee_web.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Product {

    private long id;
    private String title;
    private double cost;
}
