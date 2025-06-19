**1. what is concurrent modification exception in java collections?** 
  A ConcurrentModificationException in Java occurs when a collection is modified (added to or removed from) while it's being iterated over, typically by an iterator or a for-each loop, and it's a common issue when dealing with collections in multi-threaded environments.

```java
    List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
    for (String name : names) { // Using a for-each loop (which uses an iterator)
        if (name.equals("Bob")) {
            names.remove(name); // Modifying the collection during iteration
        }
    }
```


2. 
![image](https://github.com/user-attachments/assets/8d4914ef-2f33-43e6-a36a-f3e4a490d592)


3. String "+" vs Concat? (+ will add numeric operators as well while Concat wont)

4. What is WeakReference in Java?

5. JIT, JDK, JVM, JRE (JIT converts byte code into native machine code at runtime)

6. Yes ✅ — if you pass a List to a method and modify its contents (like emptying it), the change will be reflected in the calling method. But if you reassign the object to a newer value inside a method, then it wont affect the calling method's object.

  void func1(){
  List<Integers> lst = Arrays.asList(1,2,3,4,5);
  dontChange(lst);
  print(lst); // still prints 1,2,3,4,5,6
}
  void dontChange(List<Integers>lst){ //pass the reference by value!
    lst.add(6);
    lst = new ArrayList();
  }

7. Garbage Collections

8. Java isn't 100% object oriented because of having primitive data types.

9. Diamond problem comes in java. It can be eliminated by using interfaces. But interfaces support default implementations and hence we can override specific default method implementations using InterfaceName.super.method()

10. super keyword in java.

11. What is the difference between == and .equals() for Strings?
== compares references, .equals() compares values.

String s1 = "hello";
String s2 = new String("hello");
System.out.println(s1 == s2);       // ? false
System.out.println(s1.equals(s2));  // ? true

12. Reflections in java. (Used to inspect classes and objects. used with annotations as a replacement of instanceOf)

13. Marker INterface (empty interface - no data members and member functions) --> like annotations we use it before java 8. (Serializable, Cloneable, Remote). Its Nothing But a MetaData to the Compiler that says a special use case.

14. There are lot of trickier questions that can be asked using static, final, finally, overriding static or final methods, abstract etc.

15. In Java, a final method is a method that has been declared with the final keyword. The primary characteristic of a final method is that it cannot be overridden by subclasses.An **abstract method** cannot be final, because abstract methods are meant to be implemented by subclasses, while final methods prevent such implementation changes.

16. In depth explanation of Polymorhphism in java (Runtime polymorhism and Compile Time Polymorphism). Also see the code snippets regarding the same (Predict the output kind of code snippets)

17. Method hiding in Java occurs when a subclass defines a static method with the exact same signature (method name and parameters) as a static method in its superclass. In this scenario, the static method in the subclass effectively "hides" or "shadows" the static method in the superclass. 
