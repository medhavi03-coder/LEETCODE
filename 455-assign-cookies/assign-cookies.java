class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int l = g.length;
        int m = s.length;
        int p =0;
        int r =0;
        while(p<l && r<m){
            if(g[p]<=s[r]){
                p += 1;
            }
            r += 1;
        }
        return p;
    }
}