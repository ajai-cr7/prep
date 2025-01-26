**Entire system design:**

 ![image](https://github.com/user-attachments/assets/4776a071-1ddd-4738-b721-6cf443242a45)

**Web socket communications:**

<img width="1508" alt="image" src="https://github.com/user-attachments/assets/54f20647-18dd-4bbc-a636-0b4c261d6e0f" />



- 101 Switching Protocols is an HTTP status code that indicates a server has switched to a new protocol.
- It's a handshake that allows a client to upgrade from the default HTTP protocol to a more efficient one.

  
**How it works**
- A client requests a protocol upgrade using an Upgrade header 
- The server responds with a 101 Switching Protocols status code 
- The server includes an Upgrade header in the response to specify the new protocol 
- The new protocol is usually more efficient or specialized than the default HTTP protocol
  
**Common use case**
- The most common use case for 101 Switching Protocols is the WebSocket protocol. WebSockets use an HTTP handshake to create a connection for security reasons. 



**Hand written Notes Images:**

**References:**
- https://medium.com/@narengowda/cricinfo-cricbuzz-system-design-c596e8506669 (Tech dummies YT channel)
- ![image](https://github.com/user-attachments/assets/59cc0945-1809-4558-be4e-b64f4240ec46)
