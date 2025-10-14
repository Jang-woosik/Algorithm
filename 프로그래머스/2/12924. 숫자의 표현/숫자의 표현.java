class Solution {
    public int solution(int n) {
        int a=1;
        int cnt=0;
        while(a<=n){
            int sum=0;
            for(int i=a;i<=n;i++){
                sum+=i;
                if(sum==n){
                    a++;
                    cnt++;
                    break;
                    
                }else if(sum>n){
                    a++;
                    break;
                }
            }

        }
        
        return cnt;
    }
}