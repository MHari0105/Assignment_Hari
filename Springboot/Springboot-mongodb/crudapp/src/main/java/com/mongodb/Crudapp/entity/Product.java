package com.mongodb.Crudapp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Product {

    @Id
    private long prodId;
    private String name;
    private Integer prodCode;
    private double price;
    private String desc;

}
