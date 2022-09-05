public class Stack {
    private int[] ar;
    private int top;

    public Stack(int maxSize) {
        top = 0;
        // we allocate one more than expected because elsewhere we do not use
        // the zeroth element of the array
        ar = new int[maxSize+1];
    }

    public boolean empty() {
        return top == 0;
    }

    public int getTop() {
        return top;
    }

    public void push(int k) throws RuntimeException {
        top++;
        if(top >= ar.length) {
            throw(new RuntimeException("Stack overflow"));
        }
        ar[top] = k;
    }

    public int pop() throws RuntimeException {
        if(empty()) {
            throw(new RuntimeException("Stack underflow"));
        } else {
            top--;
            return ar[top+1];
        }
    }
}
