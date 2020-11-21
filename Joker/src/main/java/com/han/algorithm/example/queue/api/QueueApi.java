package com.han.algorithm.example.queue.api;

import org.junit.Test;

import java.util.*;

// 队列：先进先出（FIFO：First In First Out）
// 注意：队列要避免添加null元素
@SuppressWarnings("all")
public class QueueApi {
    public static void main(String[] args) {
        // 创建队列对象
        Queue<String> queue  = new LinkedList<>();
        // 获取元素长度
        queue.size();
        // 添加元素到队尾-添加失败会抛出异常
        queue.add("aaa");
        // 添加元素到队尾-添加失败返回false或者null
        queue.offer("aaa");
        // 获取队首元素并从队列中删除-删除失败抛出异常
        queue.remove();
        // 获取队首元素并从队列中删除-删除失败返回false或者null
        queue.poll();
        // 获取队首元素但并不从队列中删除-获取失败抛出异常
        queue.element();
        // 获取队首元素但并不从队列中删除-获取失败返回false或者null
        queue.peek();


    }
}
