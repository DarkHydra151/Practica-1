package com.example;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product
{
    private int id;
    private String name;
    private double price;
    private String description;
    private Category category;

    public String toFormattedString()
    {
        return String.format("Товар - %s, цiна - %.2f, опис - %s, категорiя - %s.",
                name, price, description, category.getName());
    }
}
