import java.util.*;
class Solution {
    int maxSplit;
    String s;
    public int maxUniqueSplit(String s) {
        maxSplit = 0;
        this.s = s;
        helper(0, new HashSet<String>());
        return maxSplit;
    }
    
    private void helper(int start, HashSet<String> visited){
        // start out of bound, reaching the end of the string, update maxSplit accordingly
        if(start == s.length()){
            maxSplit = Math.max(visited.size(), maxSplit);
            return;
        }
        // end is ranging from [1...N] because we take the substring s[index, end)
        for(int end = start + 1; end <= s.length(); end++){
            String newStr = s.substring(start, end);
            if(!visited.contains(newStr)){
                visited.add(newStr);
                helper(end, visited);
                visited.remove(newStr);
            }
        }
        
    }
}