Absolutely! Below are **clear and simple code examples** for each of the use cases of the `super` keyword in Java:

---

## ✅ 1. Accessing Superclass Members

When subclass and superclass have members with the same name, use `super` to access the superclass version.

### ✅ Example:

```java
class Parent {
    String message = "Hello from Parent";
}

class Child extends Parent {
    String message = "Hello from Child";

    void printMessages() {
        System.out.println(message);         // Child's message
        System.out.println(super.message);   // Parent's message
    }
}

public class Main {
    public static void main(String[] args) {
        new Child().printMessages();
    }
}
```

### 🧾 Output:

```
Hello from Child  
Hello from Parent
```

---

## ✅ 2. Invoking Superclass Constructors

Use `super()` to call a specific constructor of the superclass, especially if it's parameterized.

### ✅ Example:

```java
class Parent {
    Parent(String name) {
        System.out.println("Parent constructor: " + name);
    }
}

class Child extends Parent {
    Child(String name) {
        super(name); // Calls Parent(String name)
        System.out.println("Child constructor: " + name);
    }
}

public class Main {
    public static void main(String[] args) {
        new Child("Alice");
    }
}
```

### 🧾 Output:

```
Parent constructor: Alice  
Child constructor: Alice
```

---

## ✅ 3. Method Overriding and `super`

Use `super.methodName()` to call the overridden method in the superclass.

### ✅ Example:

```java
class Parent {
    void greet() {
        System.out.println("Hello from Parent");
    }
}

class Child extends Parent {
    @Override
    void greet() {
        super.greet(); // Calls Parent's greet()
        System.out.println("Hello from Child");
    }
}

public class Main {
    public static void main(String[] args) {
        new Child().greet();
    }
}
```

### 🧾 Output:

```
Hello from Parent  
Hello from Child
```

---

## ✅ 4. Use of `super` in Inner Classes

Use `OuterClassName.super` to refer to superclass members from within an inner class.

### ✅ Example:

```java
class Outer {
    class Parent {
        void show() {
            System.out.println("Parent show()");
        }
    }

    class Child extends Parent {
        class Inner {
            void display() {
                Outer.Child.super.show(); // Refers to Parent's show()
            }
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Child child = outer.new Child();
        Outer.Child.Inner inner = child.new Inner();
        inner.display();
    }
}
```

### 🧾 Output:

```
Parent show()
```

---

## ✅ 5. `super` in Interface Implementations (Java 8+)

From Java 8 onward, interfaces can have `default` methods. If a class implements multiple interfaces with default methods having the same name, use `InterfaceName.super.methodName()` to resolve conflict.

### ✅ Example:

```java
interface A {
    default void sayHello() {
        System.out.println("Hello from A");
    }
}

interface B {
    default void sayHello() {
        System.out.println("Hello from B");
    }
}

class MyClass implements A, B {
    @Override
    public void sayHello() {
        A.super.sayHello(); // Specify which interface’s method to call
        B.super.sayHello();
        System.out.println("Hello from MyClass");
    }
}

public class Main {
    public static void main(String[] args) {
        new MyClass().sayHello();
    }
}
```

### 🧾 Output:

```
Hello from A  
Hello from B  
Hello from MyClass
```

---

## ✅ Final Summary Table

| Use Case                       | Purpose                               | `super` Usage Example              |
| ------------------------------ | ------------------------------------- | ---------------------------------- |
| Accessing superclass fields    | Avoid field shadowing                 | `super.fieldName`                  |
| Calling superclass constructor | Initialize parent before child        | `super(args...)`                   |
| Calling overridden method      | Extend parent method logic            | `super.methodName()`               |
| Inner class accessing outer    | Avoid name conflict in inheritance    | `OuterClass.super.method()`        |
| Resolving interface conflict   | Specify default method from interface | `InterfaceName.super.methodName()` |

---


-----------------------------
The super keyword in Java is used within a subclass to refer to its immediate superclass (parent class). Its complete use cases are as follows: [1]  

• Accessing Superclass Variables: When a subclass declares an instance variable with the same name as an instance variable in its superclass, the super keyword is used to explicitly refer to the superclass's variable. This resolves ambiguity and allows access to the shadowed superclass member. 

```java
    class Parent {
        String message = "Hello from Parent";
    }

    class Child extends Parent {
        String message = "Hello from Child";

        void displayMessages() {
            System.out.println(message); // Refers to Child's message
            System.out.println(super.message); // Refers to Parent's message
        }
    }
```

• Calling Superclass Methods: If a subclass overrides a method from its superclass, the super keyword allows the subclass to invoke the overridden method from the superclass. This is useful for extending or modifying the superclass's behavior while still utilizing its original implementation. 

```java
    class Animal {
        void makeSound() {
            System.out.println("Animal makes a sound");
        }
    }

    class Dog extends Animal {
        @Override
        void makeSound() {
            super.makeSound(); // Calls Animal's makeSound()
            System.out.println("Dog barks");
        }
    }
```

• Invoking Superclass Constructors: The super() call (with or without arguments) is used within a subclass constructor to explicitly invoke a constructor of its immediate superclass. This ensures that the superclass's state is properly initialized before the subclass's constructor completes. If no super() call is explicitly made, the Java compiler automatically inserts a call to the no-argument constructor of the superclass. If the superclass does not have a no-argument constructor and the subclass does not explicitly call a parameterized superclass constructor, a compile-time error will occur. The super() call must always be the first statement within a subclass constructor. [2]  

```java
    class Vehicle {
        String type;
        Vehicle(String type) {
            this.type = type;
            System.out.println("Vehicle constructor: " + type);
        }
    }

    class Car extends Vehicle {
        Car(String type) {
            super(type); // Calls Vehicle's constructor
            System.out.println("Car constructor");
        }
    }
```
