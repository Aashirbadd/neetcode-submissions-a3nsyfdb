class MinStack {
    private Deque<Integer> stack;       // Holds all numbers
    private Deque<Integer> minStack;    // Holds all numbers till that point


    public MinStack() {
        this.stack = new ArrayDeque();
        this.minStack = new ArrayDeque();
    }
    
    public void push(int val) {
        this.stack.push(val);
        if (this.minStack.size() == 0 || val <= this.minStack.peek()) {
            // == case to simplify pop.
            this.minStack.push(val);
        }
    }
    
    // stack: -100 -> -200 -> -300 
    // mStk:  -100 -> -200 -> -300 
    // getMin = -400, pop(-400), pop(-300), getMin(-200)

    public void pop() {
        if (this.stack.peek().equals(this.minStack.peek()))
            this.minStack.pop();

        this.stack.pop();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.minStack.peek();
    }
}

// MinStack --> Design a stack that supports the push, pop, top, and getMin operations.
// MinStack initialises a stack
// Push pushes a value onto the stack
// Pop removes the element on top of the stack
// Top gets the top element of the stack
// GetMin just returns the minimum value of the stack
// Each operation should be of O(1) time.
// So if we have a normal stack
// Stack: 1 -> 2 

// MinStack: 1 