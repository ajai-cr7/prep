The final keyword in Java serves to enforce immutability and restrict modifications or extensions in various contexts: 

• Final Variables: 
	• Constants: Declaring a variable as final makes it a constant, meaning its value can be assigned only once and cannot be changed afterward. This is commonly used for defining fixed values like mathematical constants (e.g., PI) or configuration parameters that should not be altered during runtime. 
	• Ensuring Immutability: For object references, final ensures that the reference itself cannot be reassigned to point to a different object. While the object's internal state might still be mutable if the object itself is not immutable, final guarantees that the variable will always refer to the same instance. 

• Final Methods: 
	• Preventing Overriding: When a method is declared final, it cannot be overridden by any subclass. This is useful for methods that implement critical logic or security-sensitive operations, ensuring that their behavior remains consistent and cannot be altered by inheritance. [1, 2]  
	• Performance Optimization: In some cases, declaring a method final can provide a hint to the Java Virtual Machine (JVM) for potential optimizations like inlining, as the JVM knows the method's implementation will not change. 

• Final Classes: 
	• Preventing Inheritance: Declaring a class as final prevents it from being subclassed. This is used when a class's design is complete and not intended for extension, or to ensure security by preventing malicious or unintended modifications through inheritance. Examples include String and wrapper classes like Integer. 
	• Immutability: Final classes are often used to create truly immutable objects, where both the class and its internal state are designed to be unchangeable after creation. 
