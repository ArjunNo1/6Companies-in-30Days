class Solution {
    public String getHint(String secret, String guess) {
        int bulls=0;
        int cows=0;
       int sec[]=new int[10];
       int gues[]=new int[10];
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                bulls++;
            }
            else{
                sec[secret.charAt(i)-'0']++;
                gues[guess.charAt(i)-'0']++;
            }
        }
        for(int i=0;i<=9;i++){
            if(sec[i]!=0 || gues[i]!=0){
                cows+=Math.min(sec[i],gues[i]);
            }
        }

        return bulls+"A"+cows+"B";
    }
}