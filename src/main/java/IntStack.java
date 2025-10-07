public class IntStack {

    private int[] stackArray;
    private int top;

    public IntStack() {
        this.stackArray = new int[10];
        this.top = -1;
    }

    public void push(int value) {
        if (this.top == this.stackArray.length - 1) {
            expandCapacity();
        }

        this.stackArray[++this.top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("стек порожній!");
        }
        return this.stackArray[this.top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("стек порожній!");
        }
        return this.stackArray[this.top];
    }

    public int size() {
        return this.top + 1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public void clear() {
        this.top = -1;
    }

    private void expandCapacity() {
        int newCapacity = this.stackArray.length * 2;
        int[] newArray = new int[newCapacity];
        System.arraycopy(this.stackArray, 0, newArray, 0, this.stackArray.length);
        this.stackArray = newArray;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("Stack: [");
        for (int i = 0; i <= this.top; i++) {
            builder.append(this.stackArray[i]);
            if (i < this.top) builder.append(", ");
        }
        builder.append("]");
        return builder.toString();
    }

    public static void main(String[] args) {
        IntStack stack = new IntStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack); // [10, 20, 30]

        System.out.println("Peek: " + stack.peek()); // 30
        System.out.println("Pop: " + stack.pop());   // 30
        System.out.println(stack);                   // [10, 20]

        System.out.println("Size: " + stack.size()); // 2
        System.out.println("Is empty: " + stack.isEmpty()); // false

        stack.clear();
        System.out.println("After clear: " + stack); // []
    }
}