package com.han.algorithm.example.queue.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("all")
public class MyQueue<E> implements Collection<E> {
    // 元素长度
    int size = 0;
    MyQueue.Node<E> first;
    MyQueue.Node<E> last;

    private static class Node<E> {
        E item;
        MyQueue.Node<E> next;
        MyQueue.Node<E> prev;

        Node(MyQueue.Node<E> prev, E element, MyQueue.Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public int indexOf(Object o) {
        int index = 0;
        if (o == null){
            for(Node<E> x = first; x != null; x = x.next){
                if (x.item == null){
                    return index;
                }
                index++;
            }
        } else {
            for(Node<E> x = first; x != null; x = x.next){
                if (x.item.equals(o)){
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        new ArrayList<>();
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        for (Node<E> x = first; x != null; x = x.next){
            array[index++] = x.item;
        }
        return array;
    }

    // 存疑
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            a = (T[])java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);
        int i = 0;
        Object[] result = a;
        for (MyQueue.Node<E> x = first; x != null; x = x.next)
            result[i++] = x.item;
        if (a.length > size){
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    void linkLast(E e) {
        final MyQueue.Node<E> oldNode = last;
        final MyQueue.Node<E> newNode = new MyQueue.Node<E>(oldNode, e, null);
        last = newNode;
        if (oldNode == null){
            first = newNode;
        } else {
            oldNode.next = newNode;
        }
        size++;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null){
            for(MyQueue.Node<E> x = first; x != null; x = x.next){
                if (x.item == null){
                    unlink(x);
                    return true;
                }
            }
        } else {
            for(MyQueue.Node<E> x = first; x != null; x = x.next){
                if (x.item.equals(o)){
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    E unlink(MyQueue.Node<E> x) {
        final Node<E> prev = x.prev;
        final E item = x.item;
        final Node<E> next = x.next;

        if (prev == null){
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }
        if (next == null){
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.item = null;
        size--;
        return item;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c.size() == 0){
            return false;
        }
        for (Object o : c) {
            if (indexOf(o) == -1){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c == null || c.size() == 0){
            return false;
        }
        for (E e : c) {
            add(e);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null || c.size() == 0){
            return false;
        }
        for (Object o : c) {
            remove(o);
        }
        return true;
    }
    // 是否有交集
    @Override
    public boolean retainAll(Collection<?> c) {
        if (c == null || c.size() == 0){
            return false;
        }
        boolean flag = false;
        for (Object o : c) {
            if (indexOf(o) != -1){
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public void clear() {
        for (MyQueue.Node<E> x = first; x != null; x = x.next){
            x.prev = null;
            x.next = null;
            x.item = null;
        }
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(MyQueue.Node<E> x = first; x != null; x = x.next){
            builder.append(x.item.toString());
            builder.append(" ");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.add("aaa");
        myQueue.add("bbb");
        myQueue.add("ccc");
        System.out.println(myQueue);
        List<String> list = new ArrayList<>();
        list.add("ccc");
        list.add("bbb");
        myQueue.addAll(list);
        System.out.println(myQueue);
        myQueue.removeAll(list);
        System.out.println(myQueue);
        List<String> list2 = new ArrayList<>();
        list2.add("eee");
        list2.add("aaa");
        System.out.println(myQueue.retainAll(list2));
    }
}
