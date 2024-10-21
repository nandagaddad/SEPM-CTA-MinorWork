# Custom exception for invalid order
class InvalidOrderException(Exception):
    def __init__(self, message):
        super().__init__(message)

# Menu item class representing food or drink items
class MenuItem:
    def __init__(self, name, price):
        self.name = name
        self.price = price

    def process_order(self, quantity):
        if quantity <= 0:
            raise InvalidOrderException("Order quantity must be greater than zero.")
        total_price = self.price * quantity
        print(f"Order processed: {quantity} x {self.name} = {total_price:.2f}")

def display_menu(menu_items):
    print("Menu:")
    for i, item in enumerate(menu_items, start=1):
        print(f"{i}. {item.name} - {item.price:.2f}")

def main():
    # Create a menu with available items
    menu_items = [
        MenuItem("Coffee", 12.50),
        MenuItem("Tea", 10.75),
        MenuItem("Sandwich", 43.00)
    ]

    # Display menu items
    display_menu(menu_items)

    try:
        # Get user's menu choice
        choice = int(input("Select an item by entering the corresponding number: ")) - 1

        if choice < 0 or choice >= len(menu_items):
            print("Error: Invalid menu selection.")
            return  # Exit if the selection is invalid

        selected_item = menu_items[choice]
        quantity = int(input(f"Enter the quantity for {selected_item.name}: "))

        # Process the order
        selected_item.process_order(quantity)

    except InvalidOrderException as e:
        print(f"Error: {e}")  # Handle invalid order gracefully
    except ValueError:
        print("Error: Invalid input. Please enter a valid number.")  # Handle non-numeric input
    finally:
        print("Thank you for visiting the Café.")

if __name__ == "__main__":
    main()
