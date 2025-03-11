**Q and A round:** (Core Java, SQL, Spring boot, Multithreading (This company focuses more on Multithreading))

- final vs finally vs finalize
- try with resources
- git rebase vs git merge
- uses of squash and merge to main branch
- primary key vs unique key
- different ways to initialize a thread in java
- different bean scopes in spring framework
- How static is used in singleton object declaration
- list of spring boot annotations that you've used in your project
- what's the order of execution of catch blocks with multiple catches
- thread local variable
- Completable future vs executor service
- how will you write code in spring application to validate if pincode pattern passed to a business layer class is correct or wrong. (I said regex comparison)
- uses of synchronized keyword.

Then code : Print All Subsets of a Set!



**Round 2 :**

- BeanCurrentlyInCreationException means? HOw to resolve it and debug it?

- Find errors and exceptions in below code!

```java
@Service
public class AService {
    @Autowired
    private BService bService;
}
 
@Service
public class BService {
    @Autowired
    private AService aService;

}
```


```java
@Component

public class OrderService {

    private final UserService userService;
 
    public OrderService() {

        System.out.println(userService.getUserName(1L));

    }

}
```

```java
@Service

public class BankService {

    @Transactional

    public void transferMoney(Long fromAccountId, Long toAccountId, double amount) {

        accountRepository.debit(fromAccountId, amount);

        if (amount > 1000) {

            throw new IllegalArgumentException("Limit exceeded");

        }

        accountRepository.credit(toAccountId, amount);

    }

}

 
@Service

public class InventoryService {

    private Map<Long, Integer> stock = new HashMap<>();
 
    public void reduceStock(Long productId, int quantity) {

        int currentStock = stock.getOrDefault(productId, 0);

        stock.put(productId, currentStock - quantity);

    }

}

 
```

- Make Below Code Thread Safe!

  
```java
@Service
public class InventoryService {
    private Map<Long, Integer> stock = new HashMap<>();
    public void reduceStock(Long productId, int quantity) {
        int currentStock = stock.getOrDefault(productId, 0);
        stock.put(productId, currentStock - quantity);
    }
}
```

**Answer:**


```java
@Service
public class InventoryService {

    private Map<Long, Integer> stock = new HashMap<>(); //should be concurrentHashMap!

    private Map<Long, Lock> longlocksMap = new HashMap<>(); //should be concurrentHashMap!

    private static ReentrantLock reentrantLock = new ReentrantLock();

    public void reduceStock(Long productId, int quantity) {
        Lock lock = longlocksMap.computeIfAbsent(productId, key -> new ReentrantLock());
        lock.lock();
        try{
            int currentStock = stock.getOrDefault(productId, 0);
            stock.put(productId, currentStock - quantity);
        }catch (Exception e){

        }
        finally {
            lock.unlock();
        }
    }
}
```



Questions asked to Nitish :

HM round 4:

	1) How will you learn new things? Read blogs, contents
	2) IDE -> refactoring and other useful things
	3) GUI
	4) JIT
	5) FileReader and FileInput Stream
	6) Try with resources (Said AutoCloseable, closeable)
	7) Close()
	8) Threads
	9) What is the problem that thread solves
	10) How to coordinates and merge results -> join()
	11) Synchronized keyword
	12) CompletableFuture and thread
	13) Atomic Boolean and Volatile
	14) Strictfp
	15) SOLID => D
	16) IoC -> Inversion of control
	17) Pull and fetch
	18) Rebasing a branch
	19) Fast forward and non fast forward
	20) Origin and upstream
	21) Ask questions


**Next Round:**
- What is issue with below code. Is this code correct? Why it works and why not other one works? (Lots of followUps)
(Say more about polymorphism + its types and when to use composition/inheritance)

  
```java
import java.util.*;
public class Main
{
    
    public static int add(int i,int j){
        return i+j;
    }
    public static int add(long i,long j){
        return 1;
    }
    public static void main(String[] args) {
	add(1,2)
    }
}
```
