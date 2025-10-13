class Solution {
    boolean solution(String s) {
        
        int n=s.length();
        int cnt=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                cnt++;
            }else{
                cnt--;
            }
            if(cnt<0){
                return false;
            }
        }
        if(cnt==0){
            return true;
        }else{
            return false;
        }
    }
}