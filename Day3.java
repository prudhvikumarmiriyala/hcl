
import java.util.*;
import java.util.stream.Collectors;

class Order {

    int orderId;
    String customerName;
    String product;
    String category;
    double amount;
    String status;
    String deliveryCity;

    Order(int orderId, String customerName, String product,
          String category, double amount, String status,
          String deliveryCity) {

        this.orderId = orderId;
        this.customerName = customerName;
        this.product = product;
        this.category = category;
        this.amount = amount;
        this.status = status;
        this.deliveryCity = deliveryCity;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId +
               ", Customer: " + customerName +
               ", Product: " + product +
               ", Category: " + category +
               ", Amount: " + amount +
               ", Status: " + status +
               ", City: " + deliveryCity;
    }
}

public class Day3{

    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(

            new Order(101, "Ravi", "Laptop", "Electronics", 55000, "Delivered", "Hyderabad"),
            new Order(102, "Raj", "Mobile", "Electronics", 25000, "Pending", "Vijayawada"),
            new Order(103, "Kiran", "Shoes", "Fashion", 3000, "Delivered", "Chennai"),
            new Order(104, "Arjun", "Watch", "Fashion", 5000, "Cancelled", "Hyderabad"),
            new Order(105, "Sai", "Tablet", "Electronics", 30000, "Delivered", "Bangalore"),
            new Order(106, "Manoj", "Chair", "Furniture", 8000, "Pending", "Chennai"),
            new Order(107, "Karthik", "Sofa", "Furniture", 45000, "Delivered", "Hyderabad"),
            new Order(108, "Pavan", "Headphones", "Electronics", 4000, "Delivered", "Vijayawada"),
            new Order(109, "Teja", "T-Shirt", "Fashion", 1500, "Pending", "Bangalore"),
            new Order(110, "Ajay", "Table", "Furniture", 12000, "Delivered", "Chennai")
        );


        // 1. Filter orders based on amount and status

        System.out.println("\n--- FILTER ORDERS ---");

        orders.stream()
            .filter(o -> o.amount > 10000 && o.status.equals("Delivered"))
            .forEach(System.out::println);


        // 2. Sort orders by amount

        System.out.println("\n--- SORT BY AMOUNT ---");

        orders.stream()
            .sorted(Comparator.comparingDouble(o -> o.amount))
            .forEach(System.out::println);


        // 3. Find highest order amount

        System.out.println("\n--- HIGHEST ORDER ---");

        orders.stream()
            .max(Comparator.comparingDouble(o -> o.amount))
            .ifPresent(System.out::println);


        // 4. Find lowest order amount

        System.out.println("\n--- LOWEST ORDER ---");

        orders.stream()
            .min(Comparator.comparingDouble(o -> o.amount))
            .ifPresent(System.out::println);


        // 5. Calculate total sales

        System.out.println("\n--- TOTAL SALES ---");

        double totalSales = orders.stream()
            .mapToDouble(o -> o.amount)
            .sum();

        System.out.println("Total Sales: " + totalSales);


        // 6. Count number of orders

        System.out.println("\n--- TOTAL ORDERS ---");

        long count = orders.stream()
            .count();

        System.out.println("Total Orders: " + count);


        // 7. Group orders by category

        System.out.println("\n--- GROUP BY CATEGORY ---");

        Map<String, List<Order>> categoryGroups = orders.stream()
            .collect(Collectors.groupingBy(o -> o.category));

        categoryGroups.forEach((category, list) -> {
            System.out.println("\n" + category);
            list.forEach(System.out::println);
        });


        // 8. Group orders by delivery city

        System.out.println("\n--- GROUP BY CITY ---");

        Map<String, List<Order>> cityGroups = orders.stream()
            .collect(Collectors.groupingBy(o -> o.deliveryCity));

        cityGroups.forEach((city, list) -> {
            System.out.println("\n" + city);
            list.forEach(System.out::println);
        });


        // 9. Calculate average order amount

        System.out.println("\n--- AVERAGE ORDER AMOUNT ---");

        double average = orders.stream()
            .collect(Collectors.averagingDouble(o -> o.amount));

        System.out.println("Average Order Amount: " + average);


        // 10. Calculate total sales by category (Bonus)

        System.out.println("\n--- SALES BY CATEGORY ---");

        Map<String, Double> salesByCategory = orders.stream()
            .collect(Collectors.groupingBy(
                o -> o.category,
                Collectors.summingDouble(o -> o.amount)
            ));

        salesByCategory.forEach((category, sales) ->
            System.out.println(category + " : " + sales)
        );

    }
}
/*Expected output:
--- FILTER ORDERS ---
Order ID: 101, Customer: Ravi, Product: Laptop, Category: Electronics, Amount: 55000.0, Status: Delivered, City: Hyderabad
Order ID: 105, Customer: Sai, Product: Tablet, Category: Electronics, Amount: 30000.0, Status: Delivered, City: Bangalore
Order ID: 107, Customer: Karthik, Product: Sofa, Category: Furniture, Amount: 45000.0, Status: Delivered, City: Hyderabad
Order ID: 110, Customer: Ajay, Product: Table, Category: Furniture, Amount: 12000.0, Status: Delivered, City: Chennai

--- SORT BY AMOUNT ---
Order ID: 109, Customer: Teja, Product: T-Shirt, Category: Fashion, Amount: 1500.0, Status: Pending, City: Bangalore
Order ID: 103, Customer: Kiran, Product: Shoes, Category: Fashion, Amount: 3000.0, Status: Delivered, City: Chennai
Order ID: 108, Customer: Pavan, Product: Headphones, Category: Electronics, Amount: 4000.0, Status: Delivered, City: Vijayawada
Order ID: 104, Customer: Arjun, Product: Watch, Category: Fashion, Amount: 5000.0, Status: Cancelled, City: Hyderabad
Order ID: 106, Customer: Manoj, Product: Chair, Category: Furniture, Amount: 8000.0, Status: Pending, City: Chennai
Order ID: 110, Customer: Ajay, Product: Table, Category: Furniture, Amount: 12000.0, Status: Delivered, City: Chennai
Order ID: 102, Customer: Raj, Product: Mobile, Category: Electronics, Amount: 25000.0, Status: Pending, City: Vijayawada
Order ID: 105, Customer: Sai, Product: Tablet, Category: Electronics, Amount: 30000.0, Status: Delivered, City: Bangalore
Order ID: 107, Customer: Karthik, Product: Sofa, Category: Furniture, Amount: 45000.0, Status: Delivered, City: Hyderabad
Order ID: 101, Customer: Ravi, Product: Laptop, Category: Electronics, Amount: 55000.0, Status: Delivered, City: Hyderabad

--- HIGHEST ORDER ---
Order ID: 101, Customer: Ravi, Product: Laptop, Category: Electronics, Amount: 55000.0, Status: Delivered, City: Hyderabad

--- LOWEST ORDER ---
Order ID: 109, Customer: Teja, Product: T-Shirt, Category: Fashion, Amount: 1500.0, Status: Pending, City: Bangalore

--- TOTAL SALES ---
Total Sales: 188500.0

--- TOTAL ORDERS ---
Total Orders: 10

--- GROUP BY CATEGORY ---

Fashion
Order ID: 103, Customer: Kiran, Product: Shoes, Category: Fashion, Amount: 3000.0, Status: Delivered, City: Chennai
Order ID: 104, Customer: Arjun, Product: Watch, Category: Fashion, Amount: 5000.0, Status: Cancelled, City: Hyderabad
Order ID: 109, Customer: Teja, Product: T-Shirt, Category: Fashion, Amount: 1500.0, Status: Pending, City: Bangalore

Electronics
Order ID: 101, Customer: Ravi, Product: Laptop, Category: Electronics, Amount: 55000.0, Status: Delivered, City: Hyderabad
Order ID: 102, Customer: Raj, Product: Mobile, Category: Electronics, Amount: 25000.0, Status: Pending, City: Vijayawada
Order ID: 105, Customer: Sai, Product: Tablet, Category: Electronics, Amount: 30000.0, Status: Delivered, City: Bangalore
Order ID: 108, Customer: Pavan, Product: Headphones, Category: Electronics, Amount: 4000.0, Status: Delivered, City: Vijayawada

Furniture
Order ID: 106, Customer: Manoj, Product: Chair, Category: Furniture, Amount: 8000.0, Status: Pending, City: Chennai
Order ID: 107, Customer: Karthik, Product: Sofa, Category: Furniture, Amount: 45000.0, Status: Delivered, City: Hyderabad
Order ID: 110, Customer: Ajay, Product: Table, Category: Furniture, Amount: 12000.0, Status: Delivered, City: Chennai

--- GROUP BY CITY ---

Chennai
Order ID: 103, Customer: Kiran, Product: Shoes, Category: Fashion, Amount: 3000.0, Status: Delivered, City: Chennai
Order ID: 106, Customer: Manoj, Product: Chair, Category: Furniture, Amount: 8000.0, Status: Pending, City: Chennai
Order ID: 110, Customer: Ajay, Product: Table, Category: Furniture, Amount: 12000.0, Status: Delivered, City: Chennai

Vijayawada
Order ID: 102, Customer: Raj, Product: Mobile, Category: Electronics, Amount: 25000.0, Status: Pending, City: Vijayawada
Order ID: 108, Customer: Pavan, Product: Headphones, Category: Electronics, Amount: 4000.0, Status: Delivered, City: Vijayawada

Hyderabad
Order ID: 101, Customer: Ravi, Product: Laptop, Category: Electronics, Amount: 55000.0, Status: Delivered, City: Hyderabad
Order ID: 104, Customer: Arjun, Product: Watch, Category: Fashion, Amount: 5000.0, Status: Cancelled, City: Hyderabad
Order ID: 107, Customer: Karthik, Product: Sofa, Category: Furniture, Amount: 45000.0, Status: Delivered, City: Hyderabad

Bangalore
Order ID: 105, Customer: Sai, Product: Tablet, Category: Electronics, Amount: 30000.0, Status: Delivered, City: Bangalore
Order ID: 109, Customer: Teja, Product: T-Shirt, Category: Fashion, Amount: 1500.0, Status: Pending, City: Bangalore

--- AVERAGE ORDER AMOUNT ---
Average Order Amount: 18850.0

--- SALES BY CATEGORY ---
Fashion : 9500.0
Electronics : 114000.0
Furniture : 65000.0 */
