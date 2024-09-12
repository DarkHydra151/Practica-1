import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // Створення категорій
        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");

        // Створення об'єктів класу Product з вказівкою категорії
        Product product1 = new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук для роботи та ігор", electronics);
        Product product2 = new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном та високою автономністю", smartphones);
        Product product3 = new Product(3, "Навушники", 2499.00, "Бездротові навушники з шумозаглушенням", accessories);

        // Створення списку всіх товарів
        List<Product> allProducts = Arrays.asList(product1, product2, product3);

        // Створення кошика
        Cart cart = new Cart();

        // Цикл для вибору дій
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
            switch (choice) {
                case 1:
                    System.out.println(product1);
                    System.out.println(product2);
                    System.out.println(product3);
                    break;
                case 2:
                    System.out.println("Введіть ID товару для додавання до кошика:");
                    int id = scanner.nextInt();
                    if (id == 1) cart.addProduct(product1);
                    else if (id == 2) cart.addProduct(product2);
                    else if (id == 3) cart.addProduct(product3);
                    else System.out.println("Товар з таким ID не знайдено");
                    System.out.println("Товари у кошику:");
                    System.out.println(cart); // Додайте це для перевірки
                    break;
                case 3:
                    System.out.println(cart);
                    break;
                case 4:
                    if (cart.getProducts().isEmpty())
                    {
                        System.out.println("Кошик порожній. Додайте товари перед оформленням замовлення.");
                    } else {
                        cart.placeOrder();
                        System.out.println("Замовлення оформлено.");
                    }
                    break;
                case 5:
                    System.out.println("Історія замовлень:");
                    for (Order order : cart.getOrderHistory())
                    {
                        System.out.println(order);
                    }
                    break;
                case 6:
                    System.out.println("Введіть назву або категорію для пошуку:");
                    String query = scanner.next();

                    System.out.println("Результати пошуку:");
                    List<Product> searchResults = new ArrayList<>();

                    // Пошук серед усіх товарів
                    for (Product product : allProducts) {
                        if (product.getName().toLowerCase().contains(query.toLowerCase()) ||
                                product.getCategory().getName().toLowerCase().contains(query.toLowerCase())) {
                            searchResults.add(product);
                        }
                    }
                    if (searchResults.isEmpty()) {
                        System.out.println("Товарів не знайдено.");
                    } else {
                        for (Product product : searchResults) {
                            System.out.println(product);
                        }
                    }
                    break;
                case 7:
                    System.out.println("Введіть ID товару для видалення з кошика:");
                    int removeId = scanner.nextInt();
                    boolean productFound = false;

                    // Видалення товару з кошика
                    for (Product product : cart.getProducts())
                    {
                        if (product.getId() == removeId)
                        {
                            cart.removeProduct(product);
                            System.out.println("Товар успішно видалено.");
                            productFound = true;
                            break;
                        }
                    }

                    if (!productFound)
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
}