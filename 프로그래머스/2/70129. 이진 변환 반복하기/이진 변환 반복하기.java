class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int cnt2=0;
        int result=0;
        while(!s.equals("1")){
            int cnt=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='1'){
                    cnt++;
                }else{
                    cnt2++;
                }
            }
            s=Integer.toBinaryString(cnt);
            result++;
        }
        answer[0]=result;
        answer[1]=cnt2;
        return answer;
    }
}