![image](https://github.com/user-attachments/assets/63609382-07fc-4488-a424-1d0bfb293cdb)

--> When multiple instances of uber is running, then we can have a redis cluster (distributed cache --> For all pods, we have a single redis cluster) which can actually provides all locking apis. So, we can use locking  mechanisms for the critical section problem of two users booking the same cab!
