class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        String sar = "+-*/";
        for (int i = 0; i < tokens.length; i++) {
            int a = 0, b = 0, c = 0;
            if (!(sar.contains(tokens[i]))) {
                st.push(Integer.parseInt(tokens[i]));

            } else {

                if (tokens[i].equals("+")) {

                    b = st.pop();
                    a = st.pop();

                    c = a + b;
                    st.push(c);

                } else if (tokens[i].equals("-")) {
                    b = st.pop();
                    a = st.pop();
                    c = a - b;
                    st.push(c);

                } else if (tokens[i].equals("*")) {
                    b = st.pop();
                    a = st.pop();
                    c = a * b;
                    st.push(c);

                } else if (tokens[i].equals("/")) {
                    b = st.pop();
                    a = st.pop();
                    c = a / b;
                    st.push(c);

                }
            }
        }

        int r = st.pop();
        return r;
    }
}
