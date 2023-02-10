class Solution {

    int maxScore = 0;
    int[] maxStore = null;
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        helper(numArrows , 0 , 0 , aliceArrows , new int[12]);
        return maxStore;
    }
    public void helper(int numArrows , int i , int score , int[] arr , int[] store){
        if (i == 12 || numArrows == 0) {
            if (score > maxScore) {
                maxScore = score; 
                maxStore = store.clone();
                maxStore[0] += numArrows;
            }
            return;
        }
        int val = arr[i];
        if(numArrows - (val + 1) >= 0){ 
            store[i] = val + 1; 
            helper(numArrows - (val + 1) , i + 1 , score + i , arr , store);
            store[i] = 0; 
        }
        helper(numArrows , i + 1 , score , arr , store);
    }
}