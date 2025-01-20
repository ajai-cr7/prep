![image](https://github.com/user-attachments/assets/a8e55eb8-614b-430b-a88a-b721150fdb9b)

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
