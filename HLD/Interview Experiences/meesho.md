
**DESIGN CRIC-INFO BACKEND SYSTEM**

**Functional Requirements:**

-> List live of all matches and score. 
-> If we click on it then we have detailed score summary.


**Non-Functional Requirements:**

-> CAP : Availability.
-> Read to write ratio : 10 live matches, 10 Million Concurrent Users.
-> Latency for user' score summary : Near real time (25 ms)

**API's**

--> List of all cricket matches : GET /v1/matches/all 
--> Get summary/live score of a specific match : GET /v1/matches/{match_id}
--> User login/signup.


<img width="1492" alt="hld of cricbuzz" src="https://github.com/user-attachments/assets/3d619edf-10c4-450f-b4c1-601b5674b4f2" />
