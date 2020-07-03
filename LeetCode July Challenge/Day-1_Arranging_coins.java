class Solution {
    public int arrangeCoins(int n) {
        int count=0;
        int x=1;
        while(n-x>=0){
            count++;
            n=n-x;
            x++;
        }
        return count;
    }
}