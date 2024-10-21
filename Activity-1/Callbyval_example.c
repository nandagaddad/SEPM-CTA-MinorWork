//C program for the above business scenario 
#include <stdio.h>

// Function to apply discount to price 
double applyDiscount(double price) {
    double discountRate = 0.10; // 10% discount
    price = price - (price * discountRate); // Appling discount
    return price;  
}
int main() {
    double originalPrice;
    
    printf("Enter the original price of the product: ");
    scanf("%lf", &originalPrice);
    printf("Original price: %.2lf\n", originalPrice);

    printf("Discounted price: %.2lf\n", applyDiscount(originalPrice));
    printf("Original price after discount calculation: %.2lf\n", originalPrice);
    
    return 0;
}
