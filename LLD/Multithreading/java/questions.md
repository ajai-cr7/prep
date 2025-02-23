
**Types of Questions:**

    - Implementation of java exercises! (Eg : Print Series!)
    
    - Famous problems and their applications like producer-consumer problem with code implementation!
    
    - Realtime systems  -> Eg : Movie ticket booking or any ad-hoc task using read and write --> Explain solution and implement code optimally and quickly! (Most commonly coming in interviews!)

**Google L4 Engineer:**

- Say we have a list of intergers as our database. Design a class with the following functions:

read(index:int): Everyone can read from this list wihout getting blocked (you can read by passing index to a function)

write(val: int): We can write to this list by appending an integer to the list

If there is an ongoing read OR wrtie, you should block the write

**Other Questions:**

- Implement a multithreaded rate limiter : https://leetcode.com/discuss/interview-question/124558/Implement-a-Rate-Limiter/
- Implement multithreaded crawling algorithm which would be feeded a source url.
- Uber | Implement ScheduledExecutorService
  https://leetcode.com/discuss/interview-question/341504/Uber-or-Implement-ScheduledExecutorService
- Print series using multiple threads | Print series 010203040506. Using multi-threading 1st thread will print only 0 , 2nd thread will print only even numbers and 3rd thread print only odd numbers. https://leetcode.com/discuss/interview-question/339670/Print-series-using-multiple-threads (solution available in comments!)

**Notes:**

- volatile was added since it's interesting. It stores the data on main memory instead of the L1/L2/L3 cache storage on CPU. It acts as shared variables between threads. Won't be efficient since CPUs have to pull this data from main memory now and it takes longer.

