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

11. 
