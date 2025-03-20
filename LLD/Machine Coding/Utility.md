Here’s a list of 30 useful utility methods you can use as templates in your project for faster development:  

### **1. String Utilities**  
1. `isNullOrEmpty(String str)` – Checks if a string is null or empty.  
2. `capitalizeFirstLetter(String str)` – Capitalizes the first letter of a string.  
3. `reverseString(String str)` – Reverses a given string.  
4. `removeWhitespace(String str)` – Removes all whitespaces from a string.  
5. `generateRandomString(int length)` – Generates a random alphanumeric string of given length.  

### **2. Collection Utilities**  
6. `isEmpty(Collection<?> collection)` – Checks if a collection is empty or null.  
7. `findDuplicates(List<T> list)` – Finds and returns duplicate elements in a list.  
8. `removeDuplicates(List<T> list)` – Removes duplicate elements from a list.  
9. `convertListToSet(List<T> list)` – Converts a list to a set.  
10. `convertArrayToList(T[] array)` – Converts an array to a list.  

### **3. Date & Time Utilities**  
11. `getCurrentDateTime()` – Returns the current date and time.  
12. `formatDate(LocalDateTime dateTime, String pattern)` – Formats a date-time object using a given pattern.  
13. `getDifferenceInDays(LocalDate date1, LocalDate date2)` – Calculates the number of days between two dates.  
14. `convertStringToDate(String dateStr, String pattern)` – Converts a string into a date object.  
15. `addDaysToDate(LocalDate date, int days)` – Adds days to a given date.  

### **4. Number Utilities**  
16. `isPrime(int number)` – Checks if a number is prime.  
17. `findGCD(int a, int b)` – Finds the greatest common divisor of two numbers.  
18. `findLCM(int a, int b)` – Finds the least common multiple of two numbers.  
19. `isEven(int number)` – Checks if a number is even.  
20. `generateRandomNumber(int min, int max)` – Generates a random number within a given range.  

### **5. File Utilities**  
21. `readFileContents(String filePath)` – Reads the contents of a file.  
22. `writeToFile(String filePath, String content)` – Writes content to a file.  
23. `deleteFile(String filePath)` – Deletes a file.  
24. `listFilesInDirectory(String directoryPath)` – Lists all files in a directory.  
25. `copyFile(String sourcePath, String destinationPath)` – Copies a file from one location to another.  

### **6. Network & Web Utilities**  
26. `isValidEmail(String email)` – Validates an email address.  
27. `isValidURL(String url)` – Checks if a URL is valid.  
28. `getPublicIPAddress()` – Fetches the public IP address of the system.  
29. `downloadFileFromURL(String fileURL, String savePath)` – Downloads a file from a given URL.  
30. `pingHost(String host, int timeout)` – Pings a host and checks if it is reachable.  


Here are **some useful tips and tricks** that can help you **code faster and more efficiently** in Java development:  

---

### **1. Java Streams & Functional Programming**  
✅ **Use `Collectors.groupingBy` for quick grouping**  
```java
Map<String, List<Employee>> employeesByDepartment = 
    employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
```  

✅ **Use `Collectors.toMap` to convert a list to a map**  
```java
Map<Integer, Employee> employeeMap = employees.stream()
    .collect(Collectors.toMap(Employee::getId, Function.identity()));
```

✅ **Use `filter` and `findFirst` instead of loops for searching**  
```java
Optional<Employee> emp = employees.stream()
    .filter(e -> e.getName().equals("John"))
    .findFirst();
```

✅ **Use `joining` to concatenate list of strings**  
```java
String names = employees.stream()
    .map(Employee::getName)
    .collect(Collectors.joining(", "));
```

✅ **Use `partitioningBy` to split a list into two based on a condition**  
```java
Map<Boolean, List<Employee>> partitioned = 
    employees.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 50000));
```

---

### **2. Lombok - Reduce Boilerplate Code**
✅ **Use `@Data` instead of writing getters, setters, `toString()`, and `equals()`**
```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String name;
    private int age;
    private double salary;
}
```

✅ **Use `@Builder` to create complex objects easily**  
```java
Employee emp = Employee.builder()
    .name("John")
    .age(30)
    .salary(70000)
    .build();
```

✅ **Use `@Slf4j` for logging instead of manually creating a logger**  
```java
@Slf4j
public class MyService {
    public void doSomething() {
        log.info("Processing something...");
    }
}
```

---

### **3. Java 8 Optional - Avoid Null Checks**
✅ **Use `Optional.ofNullable()` to avoid `NullPointerException`**  
```java
Optional<String> optionalName = Optional.ofNullable(person.getName());
optionalName.ifPresent(System.out::println);
```

✅ **Use `orElse()` and `orElseGet()` to provide default values**  
```java
String name = optionalName.orElse("Unknown");
String computedValue = optionalName.orElseGet(() -> "Computed Value");
```

✅ **Use `map` to avoid nested null checks**  
```java
Optional<String> city = Optional.ofNullable(person)
    .map(Person::getAddress)
    .map(Address::getCity);
```

---

### **4. Efficient String Operations**
✅ **Use `StringBuilder` instead of `String` for concatenation in loops**  
```java
StringBuilder sb = new StringBuilder();
for (String str : list) {
    sb.append(str).append(", ");
}
String result = sb.toString();
```

✅ **Use `String.format()` for cleaner concatenation**  
```java
String formatted = String.format("Hello %s, you are %d years old", name, age);
```

✅ **Use `equalsIgnoreCase()` to compare strings case-insensitively**  
```java
if ("admin".equalsIgnoreCase(userRole)) { ... }
```

---

### **5. Database (JPA/Hibernate)**
✅ **Use `@Transactional` for automatic rollback on exceptions**  
```java
@Transactional
public void updateEmployee(Employee employee) {
    employeeRepository.save(employee);
}
```

✅ **Use `@Query` to write efficient custom queries in Spring Data JPA**  
```java
@Query("SELECT e FROM Employee e WHERE e.salary > :salary")
List<Employee> findEmployeesWithHighSalary(@Param("salary") double salary);
```

✅ **Use pagination to fetch large datasets efficiently**  
```java
Page<Employee> employees = employeeRepository.findAll(PageRequest.of(0, 10));
```

---

### **6. Multi-threading & Concurrency**
✅ **Use `CompletableFuture` for async execution**  
```java
CompletableFuture.runAsync(() -> {
    System.out.println("Executing in separate thread!");
});
```

✅ **Use `ExecutorService` for controlled thread pool execution**  
```java
ExecutorService executor = Executors.newFixedThreadPool(5);
executor.submit(() -> System.out.println("Task executed"));
executor.shutdown();
```

✅ **Use `CountDownLatch` to wait for multiple threads to finish**  
```java
CountDownLatch latch = new CountDownLatch(3);
new Thread(() -> { /* Task 1 */ latch.countDown(); }).start();
new Thread(() -> { /* Task 2 */ latch.countDown(); }).start();
latch.await(); // Main thread waits here
```

---

### **7. Miscellaneous Pro Tips**
✅ **Use `try-with-resources` to auto-close resources**  
```java
try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
    System.out.println(br.readLine());
}
```

✅ **Use `Files.readAllLines()` instead of `BufferedReader`**  
```java
List<String> lines = Files.readAllLines(Paths.get("file.txt"));
```

✅ **Use `Map.computeIfAbsent()` to simplify default value logic**  
```java
Map<String, List<String>> map = new HashMap<>();
map.computeIfAbsent("key", k -> new ArrayList<>()).add("value");
```

✅ **Use `@Value` annotation in Spring Boot to inject values**  
```java
@Value("${app.name}")
private String appName;
```

✅ **Use `map.putIfAbsent()` to add a value only if key is missing**  
```java
map.putIfAbsent("key", "defaultValue");
```

✅ **Use `Math.floorDiv()` for integer division rounding**  
```java
int result = Math.floorDiv(10, 3); // result = 3
```

---

These **tips** will **save time, reduce boilerplate, and make your code more efficient**. 🚀  


For a **machine coding round in Core Java** (without DB, REST, or frameworks like Spring), you should focus on **clean code, OOP principles, and efficient algorithms**. Here are some **key tips and patterns** that will **help you code faster and better**:  

---

### **1. Core Java Design Patterns**
✅ **Use Factory Pattern for Object Creation**  
- Helps in creating objects without exposing the instantiation logic.  
```java
interface Vehicle { void drive(); }
class Car implements Vehicle { public void drive() { System.out.println("Driving Car"); } }
class Bike implements Vehicle { public void drive() { System.out.println("Riding Bike"); } }

class VehicleFactory {
    public static Vehicle getVehicle(String type) {
        return type.equalsIgnoreCase("car") ? new Car() : new Bike();
    }
}

// Usage
Vehicle car = VehicleFactory.getVehicle("car");
car.drive(); // Output: Driving Car
```

✅ **Use Singleton Pattern for Shared State Management**  
```java
class ConfigManager {
    private static final ConfigManager INSTANCE = new ConfigManager();
    private ConfigManager() {}
    public static ConfigManager getInstance() { return INSTANCE; }
}
```

✅ **Use Strategy Pattern for Dynamic Behavior Switching**  
- Avoids `if-else` ladder by dynamically selecting the algorithm.  
```java
interface PaymentStrategy { void pay(int amount); }
class CreditCardPayment implements PaymentStrategy { public void pay(int amount) { System.out.println("Paid with Credit Card: " + amount); } }
class PayPalPayment implements PaymentStrategy { public void pay(int amount) { System.out.println("Paid with PayPal: " + amount); } }

class PaymentContext {
    private PaymentStrategy strategy;
    public void setStrategy(PaymentStrategy strategy) { this.strategy = strategy; }
    public void pay(int amount) { strategy.pay(amount); }
}

// Usage
PaymentContext context = new PaymentContext();
context.setStrategy(new CreditCardPayment());
context.pay(100);  // Output: Paid with Credit Card: 100
```

---

### **2. Collections & Data Structures**
✅ **Use `PriorityQueue` for Efficient Min/Max Heap**  
```java
PriorityQueue<Integer> pq = new PriorityQueue<>(); // Min Heap
pq.offer(10);
pq.offer(5);
pq.offer(15);
System.out.println(pq.poll()); // Output: 5
```

✅ **Use `Deque` (Double-ended Queue) for Stack & Queue Operations**  
```java
Deque<Integer> deque = new LinkedList<>();
deque.offerFirst(1);  // Push to front
deque.offerLast(2);   // Push to back
System.out.println(deque.pollFirst()); // Output: 1
System.out.println(deque.pollLast());  // Output: 2
```

✅ **Use `HashMap` with `computeIfAbsent` for Efficient Frequency Counting**  
```java
Map<Character, Integer> freq = new HashMap<>();
String str = "hello";
for (char c : str.toCharArray()) {
    freq.computeIfAbsent(c, k -> 0);
    freq.put(c, freq.get(c) + 1);
}
System.out.println(freq); // Output: {h=1, e=1, l=2, o=1}
```

✅ **Use `LinkedHashMap` for LRU Cache Implementation**
```java
class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;
    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}

// Usage
LRUCache<Integer, String> cache = new LRUCache<>(3);
cache.put(1, "A");
cache.put(2, "B");
cache.put(3, "C");
cache.put(4, "D"); // 1 gets removed as LRU
System.out.println(cache.keySet()); // Output: [2, 3, 4]
```

---

### **3. Multithreading & Concurrency**
✅ **Use `ExecutorService` for Thread Pool Management**  
```java
ExecutorService executor = Executors.newFixedThreadPool(3);
executor.submit(() -> System.out.println("Task 1"));
executor.submit(() -> System.out.println("Task 2"));
executor.shutdown();
```

✅ **Use `BlockingQueue` for Producer-Consumer Pattern**  
```java
class ProducerConsumer {
    BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);
    
    public void produce() throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            queue.put(i);
            System.out.println("Produced: " + i);
            Thread.sleep(500);
        }
    }
    
    public void consume() throws InterruptedException {
        while (true) {
            int val = queue.take();
            System.out.println("Consumed: " + val);
            Thread.sleep(1000);
        }
    }
}

// Usage
ProducerConsumer pc = new ProducerConsumer();
new Thread(() -> { try { pc.produce(); } catch (InterruptedException ignored) {} }).start();
new Thread(() -> { try { pc.consume(); } catch (InterruptedException ignored) {} }).start();
```

---

### **4. File Handling**
✅ **Read a File Efficiently**  
```java
try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
    br.lines().forEach(System.out::println);
}
```

✅ **Write to a File**  
```java
Files.write(Paths.get("output.txt"), "Hello, World!".getBytes(), StandardOpenOption.CREATE);
```

✅ **Read Large File Line by Line Using `Stream`**  
```java
Files.lines(Paths.get("large-file.txt")).forEach(System.out::println);
```

---

### **5. Commonly Asked Machine Coding Problems**
✅ **Design a Parking Lot System**  
- Use `Map<Integer, Vehicle> slots` for occupied slots.  
- Use `Queue<Integer>` for available slots.  
- Implement `park(Vehicle v)`, `unpark(int slot)`, `getAvailableSlots()`.  

✅ **Design a Rate Limiter using Token Bucket**  
- Use `AtomicInteger tokens` for available tokens.  
- Implement `acquire()` that consumes tokens at a fixed rate.  

✅ **Design Snake and Ladder Game**  
- Use `Map<Integer, Integer>` for ladders/snakes.  
- Use `Queue<Player>` to manage turns.  
- Implement `rollDice()` and `movePlayer()`.  

✅ **Design a Tic-Tac-Toe Game**  
- Use `char[][] board` for storing moves.  
- Implement `isWinningMove()` to check rows, columns, diagonals.  

✅ **Design an In-Memory Key-Value Store**  
- Use `Map<String, String>` to store key-value pairs.  
- Support `get(key)`, `put(key, value)`, `delete(key)`.  

---

These **tips and implementations** will help you **code faster in a machine coding round** while keeping your solutions **scalable and maintainable**. 🚀  

Let me know if you want **detailed implementations** of any of these! 😊

