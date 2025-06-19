- Method hiding, also known as shadowing, allows a subclass to redefine a static method (or a non-virtual instance method in some languages) from a superclass, effectively hiding the superclass's implementation. This is useful when the subclass needs a different behavior for the same method name, while still maintaining the class hierarchy.
In simpler terms, method hiding allows you to: 

• Provide a different implementation of a static method in a subclass: When a subclass defines a static method with the same signature (name and parameters) as a static method in its superclass, the subclass's method hides the superclass's method. [1, 1, 3, 3]  
• Control which method is called based on the reference type: When you have a reference to a subclass object, the method called depends on whether you use the subclass reference or a superclass reference. Using the superclass reference will call the superclass's method, while using the subclass reference will call the subclass's method. [3, 3, 4, 4, 5]  

**Key differences from method overriding:**

• Static vs. Instance methods: Method hiding primarily applies to static methods (or non-virtual instance methods in some languages), while method overriding is for virtual instance methods. [3, 3, 4, 4]  
• Compile-time vs. Run-time: Method hiding is resolved at compile time, while method overriding is resolved at runtime. [3, 3, 6, 6, 7, 8]  
• Base class method accessibility: In method hiding, the base class method is hidden, but in overriding, the base class method is overridden and potentially accessible through the base keyword. [4, 4]  

**Example**: 
Consider a base class Animal with a static method makeSound() and a subclass Dog that also defines a static method makeSound(). If you have a Dog object referenced by an Animal reference, animal.makeSound() would call the Animal's makeSound() method, while dog.makeSound() would call the Dog's makeSound() method. This demonstrates method hiding. [3, 3, 9, 10, 11]  

-----------------------------------------------

Method hiding in Java occurs when a subclass defines a static method with the exact same signature (method name and parameters) as a static method in its superclass. In this scenario, the static method in the subclass effectively "hides" the static method in the superclass. [1, 2]  
Here's a breakdown of method hiding: 

• Applies only to static methods: Unlike method overriding, which applies to instance (non-static) methods, method hiding is specific to static methods. Static methods belong to the class itself, not to instances of the class. 
• Compile-time resolution: The decision of which static method to invoke (the one in the superclass or the one in the subclass) is made at compile time, based on the type of the reference variable used to call the method. This is in contrast to method overriding, where the method call is resolved at runtime based on the actual object type. 
• Not polymorphism: Method hiding does not exhibit polymorphic behavior. If you have a superclass reference variable pointing to a subclass object, and you call the hidden static method, the superclass's static method will be invoked, not the subclass's. 

**Example**: 

```java
class Parent {
    public static void display() {
        System.out.println("Static method in Parent");
    }
}

class Child extends Parent {
    public static void display() {
        System.out.println("Static method in Child");
    }
}

public class MethodHidingExample {
    public static void main(String[] args) {
        Parent.display(); // Calls Parent's display()
        Child.display();  // Calls Child's display()

        Parent p = new Child();
        p.display();      // Calls Parent's display() because 'p' is of type Parent
    }
}
```

In this example, even though p references a Child object, p.display() calls the display() method from the Parent class due to method hiding and compile-time resolution. 
