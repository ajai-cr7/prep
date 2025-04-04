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
