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

Let me know if you'd like a diagram or interactive playground link to test these!
