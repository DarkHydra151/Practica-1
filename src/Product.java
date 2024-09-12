public class Product
{
    private int id;
    private String name;
    private double price;
    private String description;
    private Category category;

    // Оновлений конструктор
    public Product(int id, String name, double price, String description, Category category)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    // Геттер для поля id
    public int getId()
    {
        return id;
    }

    // Геттер для поля name
    public String getName()
    {
        return name;
    }

    // Геттер для поля category
    public Category getCategory()
    {
        return category;
    }

    // Сеттер для поля category
    public void setCategory(Category category)
    {
        this.category = category;
    }

    // Геттер для поля price
    public double getPrice()
    {
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
