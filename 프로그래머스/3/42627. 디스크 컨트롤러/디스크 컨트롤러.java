import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int idx=0;
        int len=jobs.length;
        int answer=0;
        int time=0;
        
        Arrays.sort(jobs,(o1,o2)->o1[0]-o2[0]);
        PriorityQueue<int[]>q=new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        
        while(!q.isEmpty()||idx<len){
            
            while(idx<len&&jobs[idx][0]<=time){
                q.offer(jobs[idx++]);
            }
            if(q.isEmpty()){
                time=jobs[idx][0];
            }
            else{
                int[]job=q.poll();
                time+=job[1];
                answer+=time-job[0];
            }
        }
        return answer/len;
    }
}