import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 主类实现了一个队列结构，使用两个栈来完成队列的操作
 */
public class Main {
    // 主函数，输出"Hello, World!"
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    // 输入栈，用于接收用户添加的元素
    Deque<Integer> inStack;
    // 输出栈，用于处理用户的弹出操作
    Deque<Integer> outStack;

    /**
     * 构造函数，初始化队列
     */
    public void MyQueue() {
        inStack = new ArrayDeque<Integer>();
        outStack = new ArrayDeque<Integer>();
    }

    /**
     * 向队列中添加元素
     * @param x 要添加的元素
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * 从队列中弹出元素
     * @return 弹出的元素值
     */
    public int pop() {
        if (outStack.isEmpty()) {//若输出栈为空时，将输入栈的元素倒入输出栈
            in2out();
        }
        return outStack.pop();
    }

    /**
     * 获取队列中的首元素，但不弹出
     * @return 队列首元素的值
     */
    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    /**
     * 判断队列是否为空
     * @return 如果队列为空返回true，否则返回false
     */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    /**
     * 将输入栈中的元素转移到输出栈中
     * 这样做的目的是为了保证弹出和查看操作的元素顺序符合队列的特性
     */
    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
