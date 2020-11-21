package com.han.algorithm.example.priorityQueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueApi {
    public static void main(String[] args) {
        // 创建Priority Queue--默认根据数字字典排序
        Queue<Person> queue = new PriorityQueue<>();
        // 1 类继承Comparable

    }

    static class Person implements Comparable<Person> {
        private int age;
        private String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Person o) {
            if (this.age > o.age){
                return 1;
            } else if(this.age < o.age){
                return -1;
            }
            return 0;
        }
    }
}
