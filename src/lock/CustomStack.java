package lock;

public class CustomStack {
    int size;
    int index = 0;
    int[] stack;

    CustomStack(int size){
        this.stack = new int[size];
    }

    public int pop(){
        if(index<0){
            return -1;
        }
        return stack[--index];
    }

    public void push(int value){
        stack[index++] = value;
    }
}

class TestStack{
    public static void main(String[] args) {
        CustomStack stack = new CustomStack(8);
        stack.push(4);
        System.out.println(stack.pop());
    }
}