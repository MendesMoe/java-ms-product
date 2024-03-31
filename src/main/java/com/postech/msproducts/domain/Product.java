package com.postech.msproducts.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Document("products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @MongoId
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private double price;

    @Min(value=0)
    private int quantity_stk;

    @CreatedDate
    private LocalDateTime created_at;

    public Product(ProductDTO productDTO) {
        this.name = productDTO.name();
        this.price = productDTO.price();
        this.quantity_stk = productDTO.quantity_stk();
    }
}
