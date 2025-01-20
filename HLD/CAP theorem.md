![image](https://github.com/user-attachments/assets/93038e5e-5683-465e-aa41-0b0299eeb750)


**Examples :**

![image](https://github.com/user-attachments/assets/f7c9a753-e07e-48e7-9bd2-ddcd732c301f)

**AP Example (Social Media Comments)**

- **Scenario**: User posts a comment. Another user sees it immediately, even if some servers are temporarily partitioned.
- **Availability**: The system always accepts and shows comments, ensuring no downtime.
- **Partition** **Tolerance**: During network splits, different servers may have slightly different comment threads.
- **Trade-Off**: Temporary inconsistency (comments can appear out of sync) is tolerated. Once partitions heal, comments converge to a final state.

**CP Example (ATM Withdrawals)**

- **Scenario**: ATM requires real-time balance checks with the central banking system before dispensing cash.
- **Consistency**: Ensures updated balances are accurate; no double withdrawals.
- **Partition Tolerance**: If the network breaks, the system blocks transactions to avoid inconsistent balances.
- **Trade-Off**: Reduced availability (users may face “transaction denied” until the partition is resolved).


![image](https://github.com/user-attachments/assets/d0f6f21f-6a6f-4afc-9f36-777f029e47f7)

**Consistencey vs Latency:** 

![image](https://github.com/user-attachments/assets/b1daef5d-eec2-4293-94fe-9086bb0e22f5)


**Other Acronyms :**

![image](https://github.com/user-attachments/assets/eb731618-57d6-4008-b49b-656b65c5e552)
