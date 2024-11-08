package com.stacks;

public class StackDriver {
    public static void main(String[] args) throws Exception {
        StackImplLinkedList<Integer> st = new StackImplLinkedList<>();

        st.push(21);
        st.push(23);
        st.push(24);
        st.pop();
        st.push(34);

        System.out.println(st.peek());
    }
}
