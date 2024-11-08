package com.stacks;

public class StackDriver {
    public static void main(String[] args) throws Exception {
        StackImplArrays<Integer> st = new StackImplArrays<>(Integer.class, 10);

        st.push(21);
        st.push(101);
        st.push(11);
        st.push(21);
        st.push(11);
        st.push(21);
        st.push(11);
        st.push(21);
        st.push(11);
        st.pop();
        st.push(21);
        st.push(56);

        System.out.println(st.peek());
    }
}
