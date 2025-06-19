Perfect! Here are the **Top 10 Tricky Java Interview Questions** involving **method overriding** — each with a code snippet and a question. Answers are given at the end for self-testing or interview prep.

---

## 🔟 Tricky Java Overriding Questions

---

### ❓ **Q1: What will be the output?**

```java
class A {
    void show() {
        System.out.println("A");
    }
}

class B extends A {
    void show() {
        System.out.println("B");
    }
}

class Test {
    public static void main(String[] args) {
        A obj = new B();
        obj.show();
    }
}
```

---

### ❓ **Q2: Will this compile successfully?**

```java
class Parent {
    final void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    void show() {
        System.out.println("Child");
    }
}
```

---

### ❓ **Q3: Is this allowed in Java?**

```java
class Super {
    private void display() {
        System.out.println("Super");
    }
}

class Sub extends Super {
    void display() {
        System.out.println("Sub");
    }
}
```

---

### ❓ **Q4: What is the output?**

```java
class Base {
    static void greet() {
        System.out.println("Base greet");
    }
}

class Derived extends Base {
    static void greet() {
        System.out.println("Derived greet");
    }
}

class Test {
    public static void main(String[] args) {
        Base obj = new Derived();
        obj.greet();
    }
}
```

---

### ❓ **Q5: Will this compile or throw error?**

```java
abstract class A {
    abstract void run();
}

class B extends A {
    void run(int x) {
        System.out.println("B running");
    }
}
```

---

### ❓ **Q6: What is the output?**

```java
class A {
    public Number test() {
        return 100;
    }
}

class B extends A {
    public Integer test() {
        return 200;
    }
}

class Main {
    public static void main(String[] args) {
        A obj = new B();
        System.out.println(obj.test());
    }
}
```

---

### ❓ **Q7: What is the output?**

```java
class Animal {
    void eat() throws IOException {
        System.out.println("Animal eat");
    }
}

class Dog extends Animal {
    void eat() throws Exception {
        System.out.println("Dog eat");
    }
}
```

---

### ❓ **Q8: Will this compile?**

```java
class A {
    protected Object getData() {
        return "data";
    }
}

class B extends A {
    public String getData() {
        return "more data";
    }
}
```

---

### ❓ **Q9: Output of the following?**

```java
class A {
    void print() {
        System.out.println("A print");
    }
}

class B extends A {
    void print() {
        System.out.println("B print");
    }
}

class C extends B {
    void print() {
        super.print();
    }
}

public class Main {
    public static void main(String[] args) {
        A obj = new C();
        obj.print();
    }
}
```

---

### ❓ **Q10: What is the output?**

```java
class A {
    A get() {
        return this;
    }
}

class B extends A {
    B get() {
        return this;
    }
}

class Test {
    public static void main(String[] args) {
        new B().get();
        System.out.println("Success");
    }
}
```

---

## ✅ Answers

| Q# | Answer                                                                                   |
| -- | ---------------------------------------------------------------------------------------- |
| 1  | `B` – runtime polymorphism; `B`’s `show()` is called                                     |
| 2  | ❌ Compile-time error – final method can't be overridden                                  |
| 3  | ✅ Compiles – this is method hiding, not overriding; `display()` in `Super` is private    |
| 4  | `Base greet` – static methods are not overridden, they're hidden based on reference type |
| 5  | ❌ Compile-time error – `run(int)` is overload, not override of `run()`                   |
| 6  | `200` – valid covariant return type (`Integer` is subclass of `Number`)                  |
| 7  | ❌ Compile-time error – overriding method can't throw broader checked exception           |
| 8  | ✅ Compiles – valid override with covariant return type and relaxed access                |
| 9  | `B print` – dynamic dispatch, `C` calls `super.print()` which is `B.print()`             |
| 10 | `Success` – valid covariant return type for overridden method                            |

---

Let me know if you'd like me to wrap these in a runnable Java class or generate quiz mode!
