package com.example;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Order
{
    private List<Product> products;
    private double totalPrice;
    private String status;

    public Order(Cart cart)
    {
        this.products = new ArrayList<>(cart.getProducts());
        this.totalPrice = cart.getProducts().stream().mapToDouble(Product::getPrice).sum();
        this.status = "Нове";
    }

    public String toFormattedString()
    {
        StringBuilder result = new StringBuilder("Замовлення:\n");
        result.append("Статус: ").append(status).append("\n");
        result.append("Загальна сума: ").append(String.format("%.2f", totalPrice)).append(" грн\n");
        result.append("Товари у замовленні:\n");

        for (int i = 0; i < products.size(); i++)
        {
            Product product = products.get(i);
            result.append(i + 1).append(". ")
                    .append(product.getName()).append(" - ")
                    .append(String.format("%.2f", product.getPrice())).append(" грн, ")
                    .append(product.getDescription()).append("\n");
        }
        return result.toString();
    }
}
