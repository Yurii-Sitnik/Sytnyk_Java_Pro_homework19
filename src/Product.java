import java.time.LocalDate;

public class Product {
    private String name;
    private double price;
    private boolean discount;
    private LocalDate date;

    public Product(String name, double price, boolean discount, LocalDate date) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.date = date;
    }

    public static int compare(Product p1, Product p2) {
        if (p1.getPrice() > p2.getPrice())
            return 1;
        return -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDateTime(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", dateTime=" + date +
                '}';
    }
}
