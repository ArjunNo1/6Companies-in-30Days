import java.util.*;
class Solution {
    public int evalRPN(String[] tokens) {
            Stack<Integer>st=new Stack<>();
        for(int i=0;i<tokens.length;i++){
        String str=tokens[i];
        if(str.equals("+")){
            int val1=st.pop();
            int val2=st.pop();
            st.add(val2+val1);
        }
              else if(str.equals("*")){
            int val1=st.pop();
            int val2=st.pop();
            st.add(val2*val1);
        }
              else if(str.equals("-")){
            int val1=st.pop();
            int val2=st.pop();
            st.add(val2-val1);
        }
              else if(str.equals("/")){
            int val1=st.pop();
            int val2=st.pop();
            st.add(val2/val1);
        }
        else{
            int res=Integer.parseInt(str);
            st.add(res);
        }
        }
        return st.pop();
    }
}
