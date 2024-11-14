package com.example;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Data
public class Cart
{
    private List<Product> products = new ArrayList<>();
    private List<Order> orderHistory = new ArrayList<>();

    // добавление товара в корзину
    public void addProduct(Product product)
    {
        products.add(product);
    }

    // Удаление товара из корзины
    public void removeProduct(Product product)
    {
        products.remove(product);
    }

    // Создание заказа и очистка корзины
    public void placeOrder()
    {
        Order newOrder = new Order(this);
        orderHistory.add(newOrder);
        products.clear();
    }

    @Override
    public String toString()
    {
        if (products.isEmpty())
        {
            return "Кошик порожній.";
        }

        StringBuilder result = new StringBuilder("Товари у кошику:\n");
        for (int i = 0; i < products.size(); i++)
        {
            result.append(i + 1).append(". ").append(products.get(i).toFormattedString()).append("\n");
        }
        return result.toString();
    }
}
