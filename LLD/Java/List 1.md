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
