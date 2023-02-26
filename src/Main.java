import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws OutOfTapeException {
        Product product1 = new Product("Toy1", 700, true, LocalDate.of(2022,10,25));
        Product product2 = new Product("Toy2", 120, false, LocalDate.of(2022,8,10));
        Product product3 = new Product("Toy3", 140, true, LocalDate.of(2021,7,8));
        Product product4 = new Product("Book", 260, true, LocalDate.of(2023,10,25));
        Product product5 = new Product("Book", 280, false, LocalDate.of(2023,1,20));
        Product product6 = new Product("Book", 50, true, LocalDate.of(2023,2,22));
        Product product7 = new Product("Book", 40, true, LocalDate.of(2023,1,21));

        List<Product> listOfProducts = new ArrayList<>();
        listOfProducts.add(product1);
        listOfProducts.add(product2);
        listOfProducts.add(product3);
        listOfProducts.add(product4);
        listOfProducts.add(product5);
        listOfProducts.add(product6);
        listOfProducts.add(product7);

        System.out.println(listOfProducts);
        ProductNameBookAndPriseMore250(listOfProducts);
        ProductNameBookFromDiscount(listOfProducts, 10);
        ProductLowerPrise(listOfProducts, "Book");
        System.out.println(LastThreeAddedProducts(listOfProducts));
        System.out.println("------------------");
        SumPriceOllProductsWithSomeCondition(listOfProducts,"Book",75);
        System.out.println("Grouping by name: "+ "\n"+GroupOfProducts(listOfProducts));

    }

    public static void ProductNameBookAndPriseMore250(List<Product> list) {
        Stream<Product> productStream = list.stream();
        Stream<Product> productStream1 = productStream.filter(element -> element.getName().equals("Book") && element.getPrice() > 250);
        System.out.println(productStream1.collect(Collectors.toList()));
    }

    public static void ProductNameBookFromDiscount(List<Product> list, double discount) {
        List<Product> productList2 = list.stream().filter(e -> e.getName().equals("Book") && e.isDiscount()).toList();
        productList2.forEach(element -> element.setPrice(element.getPrice() - (int) (element.getPrice() * discount / 100)));
        System.out.println("Books with discount :" + productList2);
    }

    public static void ProductLowerPrise(List<Product> list, String name) throws OutOfTapeException {
        if (list.stream().noneMatch(elem -> elem.getName().equals(name))) {
            throw new OutOfTapeException("Product " + name + " not found");
        }
        Product min = list.stream().min(Product::compare).get();
        System.out.println("Minim price: " + min);
    }

    private static List<Product> LastThreeAddedProducts(List<Product> list) {
        return list.stream().skip(list.size() - 3).collect(Collectors.toList());
    }

    private static void SumPriceOllProductsWithSomeCondition(List<Product> list, String name, double price) {
        List<Product> list1 = list.stream().filter(el -> el.getPrice() <= price && el.getName().equals(name) && el.getDate().isAfter(LocalDate.of(2023,1,1))).toList();
        System.out.println(list1);
        double sum = list1.stream().mapToDouble(Product::getPrice).sum();
        System.out.println("Total sum = " + sum);
    }

    private static Map<String, List<Product>> GroupOfProducts(List<Product> products) {
        return products.stream().collect(Collectors.groupingBy(Product::getName));

    }


}