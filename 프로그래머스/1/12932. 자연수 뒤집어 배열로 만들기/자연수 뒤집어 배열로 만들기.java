class Solution {
    public int[] solution(long n) {
        String str=String.valueOf(n);
        int cnt=str.length();
        int[]result=new int[cnt];
        for(int i=0;i<cnt;i++){
            result[cnt-i-1]=str.charAt(i)-'0';
        }
        
        return result;
    }
}