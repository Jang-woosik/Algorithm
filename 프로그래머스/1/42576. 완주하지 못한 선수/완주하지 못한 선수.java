import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer>map=new HashMap<>();
        
        for(int i=0;i<participant.length;i++){
            map.put(participant[i],map.getOrDefault(participant[i],0)+1);
        }
        for(String c:completion){
            map.put(c,map.get(c)-1);
        }
        String answer = "";
        for(String key:map.keySet()){
            if(map.get(key)!=0){
                answer=key;
                break;
            }
        }
        return answer;

    }
}