package com.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // Создаём 3 различные категории
        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");

        // Создаём 3 объекта Product с указанием на саму категорию
        Product product1 = new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук для роботи та ігор", electronics);
        Product product2 = new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном та високою автономністю", smartphones);
        Product product3 = new Product(3, "Навушники", 2499.00, "Бездротові навушники з шумозаглушенням", accessories);

        List<Product> allProducts = Arrays.asList(product1, product2, product3); // создаём список всех товаров
        Cart cart = new Cart(); // тут мы создаём корзину

        while (true)
        {
            System.out.println("\nВиберіть опцію:");
            System.out.println("1 - Переглянути список товарів");
            System.out.println("2 - Додати товар до кошика");
            System.out.println("3 - Переглянути кошик");
            System.out.println("4 - Зробити замовлення");
            System.out.println("5 - Переглянути історію замовлень");
            System.out.println("6 - Пошук товарів");
            System.out.println("7 - Видалити товар з кошика");
            System.out.println("0 - Вийти");

            int choice = scanner.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Список товарів:");
                    for (Product product : allProducts)
                    {
                        System.out.println(product.toFormattedString());
                    }
                    break;
                case 2:
                    System.out.println("Введіть ID товару для додавання до кошика:");
                    int idToAdd = scanner.nextInt();
                    Product productToAdd = findProductById(allProducts, idToAdd);
                    if (productToAdd != null)
                    {
                        cart.addProduct(productToAdd);
                        System.out.println("Товар додано до кошика.");
                    } else {
                        System.out.println("Товар з таким ID не знайдено.");
                    }
                    break;
                case 3:
                    System.out.println("Товари у кошику:");
                    System.out.println(cart);
                    break;
                case 4:
                    if (cart.getProducts().isEmpty())
                    {
                        System.out.println("Кошик порожній. Додайте товари перед оформленням замовлення.");
                    } else
                    {
                        cart.placeOrder();
                        System.out.println("Замовлення оформлено.");
                    }
                    break;
                case 5:
                    System.out.println("Історія замовлень:");
                    if (cart.getOrderHistory().isEmpty())
                    {
                        System.out.println("Історія замовлень порожня.");
                    } else
                    {
                        for (Order order : cart.getOrderHistory())
                        {
                            System.out.println(order.toFormattedString());
                        }
                    }
                    break;
                case 6:
                    System.out.println("Введіть назву або категорію для пошуку:");
                    String query = scanner.next();

                    System.out.println("Результати пошуку:");
                    List<Product> searchResults = new ArrayList<>();

                    // Выполняем поиск среди всех товаров
                    for (Product product : allProducts)
                    {
                        if (product.getName().toLowerCase().contains(query.toLowerCase()) ||
                                product.getCategory().getName().toLowerCase().contains(query.toLowerCase()))
                        {
                            searchResults.add(product);
                        }
                    }
                    if (searchResults.isEmpty())
                    {
                        System.out.println("Товарів не знайдено.");
                    } else
                    {
                        for (Product product : searchResults)
                        {
                            System.out.println(product.toFormattedString());
                        }
                    }
                    break;
                case 7:
                    System.out.println("Введіть ID товару для видалення з кошика:");
                    int idToRemove = scanner.nextInt();
                    Product productToRemove = findProductById(cart.getProducts(), idToRemove);
                    if (productToRemove != null)
                    {
                        cart.removeProduct(productToRemove);
                        System.out.println("Товар успішно видалено.");
                    } else
                    {
                        System.out.println("Товар з таким ID не знайдено в кошику.");
                    }
                    break;
                case 0:
                    System.out.println("Дякуємо, що використовували наш магазин!");
                    return;
                default:
                    System.out.println("Невідома опція. Спробуйте ще раз.");
                    break;
            }
        }
    }

    // Метод для поиска товара по ID в списке
    private static Product findProductById(List<Product> products, int id)
    {
        for (Product product : products)
        {
            if (product.getId() == id)
            {
                return product;
            }
        }
        return null;
    }
}
