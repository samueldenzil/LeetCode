package All_Problems;
// https://leetcode.com/problems/decode-xored-array/

class DecodeXORedArray {
    public int[] decode(int[] encoded, int first) {
        int[] ans = new int[encoded.length + 1];
        ans[0] = first;
        
        for (int i = 0; i < encoded.length; i++) {
            ans[i + 1] = ans[i] ^ encoded[i];
        }
        
        return ans;
    }
}