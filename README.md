# CTA Minor Work – Software Engineering & Project Management

This repository contains the **CTA Minor Work programs and report** for the course **22UHUC501 – Software Engineering & Project Management**.  
The work includes programs and theoretical study related to **Call by Value in C, Usability in software systems, Robust programming using Java and Python, and POSIX standards in C**.

Submitted as part of the **5th Semester CSE curriculum at SDM College of Engineering and Technology, Dharwad**.

---

## Repository Information

**Course:** 22UHUC501 – Software Engineering & Project Management  
**Semester:** 5th Semester (Odd Semester Sep–Dec 2024)  
**Institution:** SDM College of Engineering and Technology, Dharwad  
**Department:** Computer Science and Engineering  

**Submitted by:**  
Nanda Basavaraj Gaddad  
USN: 2SD23CS405  

---

# Table of Contents

1. Activity-1 : C program to show that C supports only Call by Value  
2. Activity-2 : Study of Usability of two major software UIs  
3. Activity-3 : Features of programming languages and robust code  
4. Activity-4 : Assertions in C and POSIX standards  

---

# Activity-1  
## Write a C program to show that C programming Language support only Call by Value

### Problem Statement
Write a C program to show that C programming Language support only Call by Value.

### Theory
Call by value is a method of passing arguments to functions in programming, where the actual value of the argument is passed to the function. This means that the function operates on a copy of the variable, so any modifications made to the parameter inside the function do not affect the original value of the argument in the calling environment.

### Program

Retail Store Temporary Price Adjustment:

In a retail store's inventory system, a function is used to calculate the price of a product after applying a discount for promotional purposes. However, the store wants to ensure that the original product price stored in the inventory is not changed.

<details>
<summary>Click to view C Program</summary>

```c
#include <stdio.h>

// Function to apply discount to price
double applyDiscount(double price) {
    double discountRate = 0.10;
    price = price - (price * discountRate);
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
```

</details>

### Sample Input and Output

```
Enter the original price of the product: 50
Original price: 50.00
Discounted price: 45.00
Original price after discount calculation: 50.00
```

---

# Activity-2  
## Study the concept “USABILITY”

### Problem Statement
Study the concept “USABILITY”, Prepare a report on usability of at least two UIs of major software product you have seen.

### Theory
Usability in software refers to how easily and effectively users can interact with a software application to achieve their goals.

For example, a small online retail business that uses software to track and manage its stock. To run the business smoothly, the software must have good usability, ensuring that employees can quickly and easily manage system without errors or frustration.

---

## Usability of Major Software Product

### Microsoft Word

Microsoft Word is a widely used word processing application.

Usability features:

- Ease of Learning – Ribbon interface with categorized tools
- Efficiency of Use – Keyboard shortcuts such as Ctrl + B and Ctrl + U
- Memorability – Consistent layout across versions
- Error Management – Built-in spelling and grammar check

---

### Trello

Trello is a project management tool that uses a visual board and card system.

Usability features:

- Ease of Learning – Simple drag-and-drop interface
- Efficiency of Use – Visual organization of tasks
- Memorability – Straightforward interface
- Error Management – Tasks can be modified or archived

---

# Activity-3  
## Features of programming language and ROBUST code

### Problem Statement
List all features of programming language and write programs to show how they help to write robust code.

---

## Features of Java

- Object-Oriented  
- Platform Independence  
- Automatic Memory Management  
- Robustness  
- Multithreading  
- Security  
- Rich Standard Library  

---

## Features of Python

- Dynamic Typing  
- Easy-to-Read Syntax  
- Cross-Platform Compatibility  
- Robustness  
- Extensive Standard Library  
- Interpreted Language  
- Support for Multiple Paradigms  
- Multithreading and Multiprocessing  

---

## Program – 1 (Java)

<details>
<summary>Click to view Java Program</summary>

```java
class InsufficientStockException extends Exception {
    public InsufficientStockException(String message) {
        super(message);
    }
}
```

Order Processing System demonstrating exception handling for insufficient stock.

</details>

The robustness of the Order processing System program is exemplified through comprehensive error handling and validation mechanisms.

---

## Program – 2 (Python)

<details>
<summary>Click to view Python Program</summary>

```python
class InvalidOrderException(Exception):
    def __init__(self, message):
        super().__init__(message)
```

Cafe Order System demonstrating error handling and input validation.

</details>

The robustness of the Café Order Processing program is demonstrated through effective error handling and input validation.

---

# Activity-4  
## Assertions in C and POSIX standards

### Problem Statement
Study assertions in C language and its importance in writing reliable code.

### Theory

Assertions are a debugging tool that helps developers catch logical errors during runtime.

Importance of Assertions:

1. Early detection of errors  
2. Document assumptions  
3. Testing edge cases  
4. Aid in debugging  

---

## POSIX Standards

POSIX is a set of standards defined by IEEE to ensure compatibility and portability between operating systems.

POSIX defines:

- System calls and APIs  
- Shell and utilities  
- Threads (Pthreads)  

---

## POSIX Program

<details>
<summary>Click to view POSIX C Program</summary>

```c
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    pid_t pid;

    pid = fork();

    if (pid < 0) {
        perror("Fork failed");
        exit(EXIT_FAILURE);
    }
    else if (pid == 0) {
        printf("Child process: Executing /bin/ls\n");
        execl("/bin/ls", "ls", NULL);
        perror("exec failed");
        exit(EXIT_FAILURE);
    }
    else {
        wait(NULL);
        printf("Parent process: Child process completed\n");
    }

    return 0;
}
```

</details>

### Sample Output

```
Child process: Executing /bin/ls
file1.txt file2.txt folder1
Parent process: Child process completed
```

---
