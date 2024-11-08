package com.stacks;

public class StackDriver {
    public static void main(String[] args) throws Exception {
        StackUsingQ st = new StackUsingQ();

        st.push(21);
        st.push(22);
        st.push(23);
        st.pop();

        System.out.println(st.peek());
    }
}
