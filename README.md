# Stack Implementation
This is a simple implementation of a Stack data structure using an array in Java.

## Class: Stack
#### Fields
* ar: an integer array used to store the elements of the Stack
* top: an integer value representing the top index of the Stack
#### Constructor
* Stack(int maxSize): Initializes an empty Stack of maximum size maxSize.
#### Methods
* empty() -> boolean: Returns true if the Stack is empty, false otherwise.

* getTop() -> int: Returns the index of the top element in the Stack.

* push(int k) -> void: Adds a new element with value k to the top of the Stack. Throws a RuntimeException with message "Stack overflow" if the Stack is full.

* pop() -> int: Removes and returns the top element of the Stack. Throws a RuntimeException with message "Stack underflow" if the Stack is empty.