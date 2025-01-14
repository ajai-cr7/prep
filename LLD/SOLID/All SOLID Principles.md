
**SOLID Principles:**

- [https://blog.algomaster.io/p/solid-principles-explained-with-code](https://blog.algomaster.io/p/solid-principles-explained-with-code)
- [https://medium.com/backticks-tildes/the-s-o-l-i-d-principles-in-pictures-b34ce2f1e898](https://medium.com/backticks-tildes/the-s-o-l-i-d-principles-in-pictures-b34ce2f1e898)
- chat GPT/GITHUB for code 

![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXd8HYmyX_9Z1s8Hx7sOOqsNuHtv2ccHv82mFoyNuOFoSmGosknk_GoRt2Wsymk93jBomr8Fv0-FhRMt36JODhSn5_6t_Btkws5VKuF_BJrQlIhfsq6tu7kfdKD67NXiOhgxJEqtEVUFCsEsxeIkXY0ITlEv?key=xd8FhkLthdoguEhsAQakmg)


- **Examples:**


- A class should not authenticate the user, update the profile and send email notifications to Users. Its Handling 3 Responsibilities where Changing the Behaviour of one of the Responsibilities may affect others. So, Have 3 different classes for 
	- User Auth, 
	- Profile Updating and 
	- Sending Emails separately to promote SRP. 
    
- Let's say you have a ShapeCalculator class that calculates the area and perimeter of different shapes like rectangles and circles. Consider calculateArea() method. 
    
	- ![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXe2S_ygE8EtSVCm7kIKJ1OAKqqivUgMaBwgXQJm9yBU3qHpUxFyk8cZEwlup0FL6lCLF-6RvqyZ0jW9YNlVi7xiP54bspxmywfG-wQ3GgRJUxMBqVdYyY4HuNS5IPpRAjJdkBgPpCm4-Ik3E-B0V6b1fro?key=xd8FhkLthdoguEhsAQakmg)
    
	- When We Try To Introduce a New Shape Called Triangle, then we might have to change the existing code which violates OCP. Instead we have to create abstract methods of calculate_area and calculate_perimeter and then create concrete classes for Rectangle and Circle. This will promote OCP as for triangle we have to create a new class and extend shapeCalculator. 
    

- LSP: (**A child class should do everything that a parent class can do**)
  
	- Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program

	- ![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXcJmKoAXVtupwTtaGD1dosghRos-9jZtfvtSagJFf-mXLHDaUVEez7Lg8ttRLSz6bC8mMlgoWoF9WJ3QE2C4zT4Hti0ya-R3rfmv24XtqHDwo-n1iAHMIvLFuLHm-F5rNyGSFwZaNQjWMbA4vCRdXjv7T4?key=xd8FhkLthdoguEhsAQakmg)
    
	- ![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXe4lbMpySRTVsl9aNBe_kFfdKhrs7pSuGS6rufUeA5KPtb2wZctZQ49QvxUW6E7bBPbgOclWxK0q9HxkruYqXlW5i49_XTSgVV88PllvmxeuUODdZjtg2EUSiDMYHwMIVNmcz2Fp6V3BvrjvTokznVz1yk?key=xd8FhkLthdoguEhsAQakmg)


**Example 2 for LSP:**
- Class Parent --> eat(), sleep(), goToWork(), prepareDinner()
- Class child Extends Parent --> cant prepareDinner() and cant goToWork()

So correct way is to define something like 
- Interface Human --> eat(), sleep()
- Class Adult implements Human --> goToWork(), prepareDinner()
- Class Child implements Human --> cry()

    
- **ISP**:No client should be forced to depend on interfaces they don't use.
    
	- ![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXduNHTJ3L0cNMbII4BmDqsKLwt9rGyvE1d8X84KHfe_mXNMwScai7zFyIikMhBrGyyKTiq-q27erNCrIl1Ctomq7MpP_EF2TXdmU2fZn0NyjUe7JbszDXwhQ8-TkkMWHGeRp0LW3RW-u43SLDuGIReZFgDN?key=xd8FhkLthdoguEhsAQakmg)
    
	- ![](https://lh7-rt.googleusercontent.com/docsz/AD_4nXcbjTkmWGlFiZ3teC_NlU9Q-EQz_u6gpCZJHUTo9p9FcGBnQBhtVwFRT1tcegr_4WQkyO6cZhO6bMsCIQXjaSDJUrJ-T_cfxSKbHVnNRWui3woJpZdykEuqy9DZ0B5de78CJFZseMKq6Ter7f20Rx7fh4q1?key=xd8FhkLthdoguEhsAQakmg)
    
**Example 2 :**

<img width="737" alt="image" src="https://github.com/user-attachments/assets/811b128e-0b22-4f20-900b-070212287553" />


##### Dependency Inversion Principle:

  The **Dependency Inversion Principle (DIP)** is the last of the SOLID principles. It states that:

1. **High-level modules** should not depend on low-level modules. Both should depend on abstractions.
2. **Abstractions** should not depend on details. Details should depend on abstractions.

In simpler terms, instead of high-level classes directly depending on low-level classes (specific implementations), both should rely on interfaces or abstract classes, allowing flexibility and easier maintenance.

Let’s use the **MailNotifications** system with clients like **Outlook** and **Gmail** to explain both an improper way (which violates DIP) and a proper way (which adheres to DIP).

---

### **Improper Common Way to Code (Violation of DIP)**

Here, the **MailNotifications** class directly depends on the low-level classes like `OutlookClient` and `EmailClient`. This is a common but flawed approach, because if we later want to add more mail clients (like Yahoo Mail), we’d have to modify the `MailNotifications` class. This tightly couples the high-level class with the low-level implementations.

```java
// Low-level module: Outlook mail client
class OutlookClient {
    public void sendEmail(String message) {
        System.out.println("Sending email via Outlook: " + message);
    }
}

// Low-level module: Email client (Gmail in this case)
class EmailClient {
    public void sendEmail(String message) {
        System.out.println("Sending email via Gmail: " + message);
    }
}

// High-level module: Mail Notifications (VIOLATES DIP)
class MailNotifications {
    private OutlookClient outlookClient;
    private EmailClient emailClient;

    public MailNotifications() {
        this.outlookClient = new OutlookClient();  // Tight coupling to specific clients
        this.emailClient = new EmailClient();      // Tight coupling to specific clients
    }

    public void notifyViaOutlook(String message) {
        outlookClient.sendEmail(message);
    }

    public void notifyViaEmail(String message) {
        emailClient.sendEmail(message);
    }
}

public class Main {
    public static void main(String[] args) {
        MailNotifications notifications = new MailNotifications();
        notifications.notifyViaOutlook("Important Outlook message!");
        notifications.notifyViaEmail("Important Gmail message!");
    }
}
```

### **Problems with this Approach**:
1. **Tight Coupling**: The `MailNotifications` class directly depends on concrete implementations (`OutlookClient` and `EmailClient`).
2. **No Flexibility**: If we want to add another email client (like Yahoo), we must modify the `MailNotifications` class, violating the **Open/Closed Principle** too.
3. **Difficult to Maintain**: Every time we add or change an email client, we risk breaking the `MailNotifications` class.

---

### **Correct Way to Code (Adhering to DIP)**

Here, the **MailNotifications** class depends on an abstraction (an interface `EmailService`), not on the low-level implementations. This ensures that both the high-level class and the low-level classes depend on abstractions, allowing flexibility and future scalability.

```java
// Abstraction: Interface for Email services
interface EmailService {
    void sendEmail(String message);
}

// Low-level module: Outlook client (implements abstraction)
class OutlookClient implements EmailService {
    @Override
    public void sendEmail(String message) {
        System.out.println("Sending email via Outlook: " + message);
    }
}

// Low-level module: Gmail client (implements abstraction)
class EmailClient implements EmailService {
    @Override
    public void sendEmail(String message) {
        System.out.println("Sending email via Gmail: " + message);
    }
}

// High-level module: Mail Notifications (FOLLOWS DIP)
class MailNotifications {
    private EmailService emailService;

    // Constructor dependency injection
    public MailNotifications(EmailService emailService) {
        this.emailService = emailService;  // Depends on abstraction, not concrete classes
    }

    public void notify(String message) {
        emailService.sendEmail(message);  // Use the email service interface
    }
}

public class Main {
    public static void main(String[] args) {
        // Injecting dependencies
        EmailService outlookClient = new OutlookClient();
        MailNotifications outlookNotifications = new MailNotifications(outlookClient);
        outlookNotifications.notify("Outlook notification: Meeting at 3 PM");

        EmailService gmailClient = new EmailClient();
        MailNotifications gmailNotifications = new MailNotifications(gmailClient);
        gmailNotifications.notify("Gmail notification: Project deadline tomorrow");
    }
}
```

### **Why is This Approach Better?**

1. **Loose Coupling**: The `MailNotifications` class no longer depends on specific implementations (`OutlookClient` or `EmailClient`). It only depends on the `EmailService` interface, which ensures flexibility.
2. **Flexibility**: If we want to add a new mail client (e.g., `YahooClient`), we just implement the `EmailService` interface without touching the `MailNotifications` class.
3. **Maintainability**: Changes in low-level modules do not affect the high-level class. We can easily swap implementations or add new ones.
4. **Easy to Test**: We can mock the `EmailService` interface for testing purposes, making unit testing more straightforward.

### **New Mail Client Example:**
Let’s say we want to add a **Yahoo Mail** client. All we need to do is implement the `EmailService` interface, and we don’t have to modify the `MailNotifications` class.

```java
// New Low-level module: Yahoo Mail client (implements abstraction)
class YahooClient implements EmailService {
    @Override
    public void sendEmail(String message) {
        System.out.println("Sending email via Yahoo: " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        // Injecting Yahoo client
        EmailService yahooClient = new YahooClient();
        MailNotifications yahooNotifications = new MailNotifications(yahooClient);
        yahooNotifications.notify("Yahoo notification: New updates available");
    }
}
```

### **Key Takeaways**:
- **Violation of DIP**: When the high-level `MailNotifications` class directly depends on specific implementations like `OutlookClient` or `EmailClient`, it's tightly coupled and hard to extend or modify.
- **Adhering to DIP**: By introducing an abstraction (`EmailService` interface), both the high-level class (`MailNotifications`) and the low-level classes (e.g., `OutlookClient`, `EmailClient`) depend on an abstraction, allowing for better flexibility, testability, and maintainability.

This approach will make your code more modular and adaptable for future changes, which is a key to applying the **Dependency Inversion Principle** effectively!


<br/>
<br/>
<br/>
<br/>
<br/>
<br/>


**Questions:**

**- Difference betwen LSP and ISP in solid principles. They both look similar and one looks like a consequence of another**


You're correct that **Liskov Substitution Principle (LSP)** and **Interface Segregation Principle (ISP)** both seem similar at first glance, especially because they both deal with the **correctness of substituting** objects. However, they address different aspects of object-oriented design. Let's break down their distinctions and clarify how they relate to each other.

### **Liskov Substitution Principle (LSP)**

**Definition**: 
The **Liskov Substitution Principle** states that objects of a superclass should be replaceable with objects of a subclass without affecting the **correctness** of the program.

- **Focus**: It ensures that a subclass can be substituted for its base class without causing unexpected behavior.
- **Key Idea**: A subclass should not change or violate the expected behavior of the parent class. If a function is written to work with an instance of a parent class, substituting it with a child class should not cause any errors or break functionality.

**Example**:
If you have a class `Bird` with a method `fly()`, and a subclass `Penguin` that cannot fly, substituting a `Bird` object with a `Penguin` object would break the program, which violates LSP.

**Violation of LSP**:
```java
class Bird {
    public void fly() {
        System.out.println("Flying...");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly!");
    }
}
```
Here, substituting a `Bird` object with a `Penguin` object breaks the expected behavior of the `fly()` method, thus violating LSP.

### **Interface Segregation Principle (ISP)**

**Definition**:
The **Interface Segregation Principle** states that **no client should be forced to depend on methods it does not use**. In other words, an interface should have only the methods that are relevant to the implementing class.

- **Focus**: It emphasizes creating smaller, more specific interfaces rather than large, monolithic ones.
- **Key Idea**: Interfaces should be split into smaller, more focused interfaces to ensure that clients (classes implementing interfaces) are not burdened with irrelevant methods.

**Example**:
Imagine a class `Worker` that implements an interface `Machine`, but it doesn't need to implement methods that only apply to machines capable of both working and repairing. According to ISP, you should not force `Worker` to implement methods related to repairing machines if it doesn’t need those methods.

**Violation of ISP**:
```java
interface Machine {
    void work();
    void repair();
}

class Worker implements Machine {
    @Override
    public void work() {
        System.out.println("Working...");
    }

    @Override
    public void repair() {
        // Worker is not capable of repairing, but still has to implement it
        throw new UnsupportedOperationException("Workers cannot repair!");
    }
}
```

In this case, the `Worker` class is forced to implement the `repair()` method, which it doesn't need. This violates ISP because `Worker` doesn't need the `repair()` method from the `Machine` interface.

**Correct Approach (ISP-compliant)**:
```java
interface Workable {
    void work();
}

interface Repairable {
    void repair();
}

class Worker implements Workable {
    @Override
    public void work() {
        System.out.println("Working...");
    }
}

class Robot implements Workable, Repairable {
    @Override
    public void work() {
        System.out.println("Robot working...");
    }

    @Override
    public void repair() {
        System.out.println("Robot repairing...");
    }
}
```
Now, `Worker` implements only `Workable` (because it only works), and `Robot` implements both `Workable` and `Repairable`. This adheres to the ISP because each class only depends on the interfaces that are relevant to it.

---

### **Key Differences Between LSP and ISP**:

| **Aspect**                  | **Liskov Substitution Principle (LSP)**                                             | **Interface Segregation Principle (ISP)**                                           |
|-----------------------------|-------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------|
| **Focus**                   | Focuses on **substitution** of objects in an inheritance hierarchy without breaking behavior. | Focuses on **splitting interfaces** into smaller ones to avoid forcing clients to implement unused methods. |
| **Primary Concern**         | Ensuring that subclasses **do not break the behavior** of the parent class.         | Ensuring that a class **is not forced to implement methods it doesn't need** from large interfaces. |
| **Nature of Concern**       | Deals with **inheritance** and the relationship between **superclass and subclass**. | Deals with **interfaces** and the **relationships between interfaces and implementing classes**. |
| **Violations**              | A subclass changes or breaks the expected behavior of the parent class, leading to errors. | A class implements unnecessary methods from an interface that it does not use. |
| **Example of Violation**    | A subclass `Penguin` inherits from `Bird` but cannot fulfill the `fly()` method.    | A class `Worker` implements `Machine` but doesn't need the `repair()` method.       |
| **Solution**                | Subclasses must ensure that their behavior is **compatible** with the parent class, and they should only extend behaviors that make sense. | Interfaces should be **segregated** into smaller, more focused ones, allowing classes to implement only the methods they need. |

---

### **How LSP and ISP Relate to Each Other**

While both LSP and ISP deal with **correctness** and **expected behavior**, they address different **design concerns**:

1. **LSP** is more focused on **inheritance** and the relationship between a **parent class** and **child classes**. It ensures that a subclass can be substituted for its parent without altering the program’s behavior or causing errors.

2. **ISP** is focused on **interfaces** and ensuring that a class is not forced to implement **irrelevant methods** from an interface. This principle helps prevent **bloating interfaces** and ensures that clients (implementing classes) only depend on the methods they need.

In many cases, following the **ISP** can **help prevent LSP violations**. For instance, by breaking down large interfaces into smaller, more cohesive ones, you avoid situations where a class is forced to inherit methods it cannot properly support, which could potentially violate LSP. So in a way, ISP can be seen as a **preventive measure** against issues that could lead to LSP violations.

---

### **Summary**:

- **LSP**: Ensures that subclasses can be **substituted** for their parent classes without breaking functionality.
- **ISP**: Ensures that classes are not forced to implement methods that are **irrelevant** to them by **segregating large interfaces** into smaller, focused ones.

Both principles are about **correctness**, but **LSP** focuses on ensuring **substitution integrity** in inheritance hierarchies, while **ISP** focuses on making sure **clients (classes)** only interact with relevant methods in interfaces.
