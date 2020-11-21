package com.han.algorithm.example.deque.api;

import java.util.Deque;
import java.util.LinkedList;

//  双端队列（Double Ended Queue）
//  既可以添加到队尾，也可以添加到队首；
//  既可以从队首获取，又可以从队尾获取。
@SuppressWarnings("all")
public class DequeApi {
    public static void main(String[] args) {
        // 创建Deque对象，Deque继承于Queue
        Deque<String> deque = new LinkedList<>();
        //addLast(E e) / offerLast(E e)
        // 添加元素到队尾
        deque.addLast("aaa");
        deque.offerLast("aaa");
        // 取队首元素并删除
        deque.removeFirst();
        deque.pollFirst();
        // 取队首元素但不删除
        deque.getFirst();
        deque.peek();
        // 添加元素到队首
        deque.addFirst("aaa");
        deque.offerFirst("aaa");
        // 取队尾元素并删除
        deque.removeLast();
        deque.pollLast();
        // 取队尾元素但不删除
        deque.getLast();
        deque.peek();
    }
}
