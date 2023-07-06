package com.example.memorydb.book.entity;

import com.example.memorydb.entity.Entity;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class BookEntity extends Entity {


    private String name;
    private String category;
    private BigDecimal amount;
}
