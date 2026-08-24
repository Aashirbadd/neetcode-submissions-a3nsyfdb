class MinStack {
    Stack<Integer> valStack;
    Stack<Integer> minStack;
    int currMin;

    public MinStack() {
        valStack = new Stack<>();
        minStack = new Stack<>();
        currMin = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        valStack.push(val);

        currMin = Math.min(val, currMin);
        minStack.push(currMin);
    }
    
    public void pop() {
        valStack.pop();
        minStack.pop();
        if (!minStack.isEmpty()) {
            currMin = minStack.peek();
        }
        else {
            currMin = Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        return valStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

// Push, pop, top -> Easy...
// getMin() -> Requires extra tracking of what's in the stack...
// Feel like this would be implemented as a linkedList...
// Yeah it would be a linkedList that's connected to a thing that's tracking sorted form too...
// So a linkedList that's just having the stack in general... Then???
// How to track the minimum???? MinHeap.
// Yeah? But idk how that's gonna happen...
// LOL NC.