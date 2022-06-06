Implementation of the Stack data structrure.

A Stack stores int values.
It provides the following two operations:
push(): inserts an element into the top of the stack;
pop(): removes the element from the top of stack (the one which was last pushed), and returns this value.
Then, it has an empty() method to check whether the stack is empty.
Finally, its size() method returns the number of elements stored in the stack.
If pop() is called on an empty stack, the method should throw a java.util.NoSuchElementException.


Testing the implementation using the JUnit test environment in the following way. Check that

the element pushed last is the one which is popped first;
a freshly constructed stack is empty;
a stack containing one element is not empty;
it is not possible to pop from an empty stack (i.e. whether the exception is thrown);
the size() method works properly in corner cases (0, 1);
if the last element is popped, the stack becomes empty.
