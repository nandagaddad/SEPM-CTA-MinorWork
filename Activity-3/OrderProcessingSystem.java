import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

// Custom exception class for insufficient stock
class InsufficientStockException extends Exception {
    public InsufficientStockException(String message) {
        super(message);
    }
}

// Product class to represent a product in the system
class Product {
    private String name;
    private int stockQuantity;
    private double price;

    public Product(String name, int stockQuantity, double price) {
        this.name = name;
        this.stockQuantity = stockQuantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public double getPrice() {
        return price;
    }

    // Method to process the order
    public void processOrder(int orderQuantity) throws InsufficientStockException {
        if (orderQuantity > stockQuantity) {
            throw new InsufficientStockException("Insufficient stock for product: " + name);
        }
        stockQuantity -= orderQuantity;
        System.out.println("Order processed! " + orderQuantity + " units of " + name + " sold.");
    }
}

public class OrderProcessingSystem {

	public static void main(String[] args) {
		// Creating a list of products
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Laptop", 10, 75000.00));
        productList.add(new Product("Smartphone", 20, 30000.00));
        productList.add(new Product("Tablet", 15, 45000.00));

        // Display available products
        System.out.println("Welcome to the Order Processing System.");
        System.out.println("Available Products:");
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            System.out.println((i + 1) + ". " + product.getName() + " - Available Stock: " + product.getStockQuantity() + ", Price: " + product.getPrice());
        }

        // Getting user input for product selection
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select a product by entering the corresponding number: ");
        
        try {
            int productIndex = scanner.nextInt() - 1;  // Adjust for zero-based index
            if (productIndex < 0 || productIndex >= productList.size()) {
                System.out.println("Error: Invalid product selection.");
                return; // Exit if the selection is invalid
            }

            Product selectedProduct = productList.get(productIndex);
            System.out.println("You selected: " + selectedProduct.getName());
            System.out.println("Available Stock: " + selectedProduct.getStockQuantity());
            System.out.print("Enter quantity to order: ");
            int orderQuantity = scanner.nextInt();

            // Process the order
            selectedProduct.processOrder(orderQuantity);

        } catch (InsufficientStockException e) {
            System.out.println("Error: " + e.getMessage());  // Handle stock error gracefully
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter a valid order quantity.");  // Handle invalid input
        } finally {
            System.out.println("Thank you for using the Order Processing System.");
            scanner.close();
        }
	}
}
