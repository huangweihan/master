package com.han.algorithm.example.stack.api;

import java.util.Stack;

// 栈：后进先出:Last In First Out   LIFO
public class StackApi {
    public static void main(String[] args) {
        // 创建栈对象
        Stack<String> stack = new Stack<>();
        // 压栈
        stack.push("aaa");
        // 弹栈（栈顶元素）
        stack.pop();
        // 获取栈顶元素（不弹栈）
        stack.peek();
        // 查询
        stack.search("aaa");
    }
}
