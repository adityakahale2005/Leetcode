class MyQueue {
    Stack<Integer> firstStack;
    Stack<Integer> secondStack;

    public MyQueue() {
        firstStack = new Stack<>();
        secondStack = new Stack<>();
    }

    public void push(int x) {
        while (!firstStack.isEmpty()) {
            secondStack.push(firstStack.pop());
        }

        firstStack.push(x);

        while (!secondStack.isEmpty()) {
            firstStack.push(secondStack.pop());
        }
    }

    public int pop() {
        return firstStack.pop();
    }

    public int peek() {
        return firstStack.peek();
    }

    public boolean empty() {
        return firstStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */