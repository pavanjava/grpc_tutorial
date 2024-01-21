package org.vaslabs.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Product {
    private int id;
    private int categoryId;
    private String name;
    private String description;
    private float price;
}
