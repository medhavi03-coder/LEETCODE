class Solution {
    public int[] plusOne(int[] a) {
        for(int i =a.length-1; i >=0;i--){
            if(a[i] < 9) {
                a[i] += 1;
                return a;
            }
            a[i] = 0;
        }

        a = new int[a.length+1];
        a[0] = 1;
        return a;
    }
}