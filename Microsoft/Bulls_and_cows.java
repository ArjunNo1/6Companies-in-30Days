class Solution {
    public String getHint(String secret, String guess) {
        int arr[] = new int[10];
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < secret.length(); i++) {
            int x = Character.getNumericValue(secret.charAt(i));
            int y = Character.getNumericValue(guess.charAt(i));
            if (x == y) {
                bull++;
            }
            arr[x]++;
            // arr[y] --;
        }
        for (int i = 0; i < guess.length(); i++) {
            int x = Character.getNumericValue(guess.charAt(i));
            if (arr[x] != 0) {
                cow++;
                arr[x]--;
            }
        }
        cow -= bull;
        String r = bull + "A" + cow + "B";
        return r;
    }
}