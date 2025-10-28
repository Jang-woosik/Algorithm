class Solution {
    static boolean[]visit;
    static int[][]map;
    static int n;
    public int solution(int n, int[][] computers) {
        map=computers;
        int answer=0;
        this.n=n;
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(computers[i][j]==1){
                    map[i][j]=1;
                }
            }
        }
        visit=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visit[i]){
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
    private void dfs(int start){
        visit[start]=true;
        
        for(int i=0;i<n;i++){
            if(map[start][i]==1&&!visit[i]){
                dfs(i);
            }
        }
    }
}