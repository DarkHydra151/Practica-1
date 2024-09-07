public class Product
{
    private int id;
    private String name;
    private double price;
    private String description;
    private Category category; // Додано поле для зберігання категорії

    // Оновлений конструктор
    public Product(int id, String name, double price, String description, Category category)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category; // Ініціалізація категорії
    }

    public String getName() {
        return name;
    }

    // Геттери та сеттери (додано геттер і сеттер для категорії)
    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    // Геттер для поля price
    public double getPrice() {
        return price;
    }

    @Override
    public String toString()
    {
        return "Товар{" +
                "id=" + id +
                ", назва='" + name + '\'' +
                ", ціна=" + price +
                ", опис='" + description + '\'' +
                ", категорія='" + category.getName() + '\'' +
                '}';
    }
}