package com.oleglmn.onlineshop.domain.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class CartDto {
    private Long id;
    private List<ProductDto> products = new ArrayList<>();
}
