package com.han.algorithm.example.stack.api;

import java.util.EmptyStackException;
import java.util.Vector;

public class MyStack<E> extends Vector<E> {

    // 无参构造器
    public MyStack(){

    }

    // 压栈
    public E push(E item){
        addElement(item);
        return item;
    }

    // 弹栈
    public E pop(){
        E item = peek();
        removeElement(item);
        return item;
    }

    // 获取栈顶元素（不弹栈）
    public E peek(){
        int len = size();
        if (len == 0)
            throw new EmptyStackException();
        return elementAt(len - 1);
    }

    // 是否非空
    public boolean empty(){
        return size() == 0;
    }

    // 查询
    public int search(Object o) {
        int i = lastIndexOf(o);
        if (i >= 0) {
            return size() - i;
        }
        return -1;
    }

    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();
        myStack.push("aaa");
        myStack.push("bbb");
        myStack.push("ccc");
        System.out.println("myStack.search(\"aaa\") = " + myStack.search("aaa"));
        System.out.println("myStack.pop() = " + myStack.pop());
        System.out.println("myStack.toString() = " + myStack.toString());
        System.out.println("myStack.peek() = " + myStack.peek());
        System.out.println("myStack.toString() = " + myStack.toString());
        myStack.pop();
        myStack.pop();
        System.out.println("myStack.empty() = " + myStack.empty());
    }
}
