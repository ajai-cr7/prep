Following question is asked in razorpay while discussing publisher subscriber model of kafka: IF number of consumers exceeds thread pool size, 
then it becomes a problem right? How to fix it per pod? ideally its not at all a problem because, max thread pool size is atmost the number of cores.

✅ Why Thread Pool Size ≈ Number of Cores?
In CPU-bound tasks, threads spend nearly all their time actively executing code, not waiting for I/O.

➡️ More threads than cores = context switching overhead
➡️ Fewer threads = underutilized CPU

✅ How to Get Available CPU Cores in Java:
java
Copy
Edit
int cores = Runtime.getRuntime().availableProcessors();
This returns logical processors (includes hyperthreading). So on a quad-core with hyperthreading, this may return 8.

