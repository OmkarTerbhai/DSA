package com.hashmaps;

import java.util.Random;


class CustomMapNode<T, V> {
    T key;
    V value;

    LinkedListImplMap<T, V> list;

    public CustomMapNode(T key, V value) {
        this.key = key;
        this.value = value;
        this.list = new LinkedListImplMap<>();
    }
}
public class CustomHashMap<T, V> {

    CustomMapNode<T, V>[] arr;
    int size;

    public CustomHashMap() {
        size = 16;
        arr = new CustomMapNode[size];
    }

    public void insert(T key, V value) {
        int hash = -1;
        if(key == null)   hash = 0;
        else {
            hash = (key.hashCode() * 2000) % size;
        }

        if(arr[hash] == null) {
            arr[hash] = new CustomMapNode<>(key, value);
        }
        else {
            CustomMapNode<T, V> existingNode = arr[hash];

            if(existingNode.key.equals(key)) {
                existingNode.value = value;
            }
            else {
                LinkedListImplMap<T, V> myList = existingNode.list;
                myList.addLast(key, value);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();


        for(CustomMapNode n : arr) {
            if(n != null) {
                sb.append(n.key).append(" -> ").append(n.value);

                Node temp = n.list.head;
                sb.append(" ");
                while(temp != null) {
                    sb.append(temp.key).append(" -> ").append(temp.value);
                    temp = temp.next;
                }
            }
        }
        return sb.toString();
    }
}
