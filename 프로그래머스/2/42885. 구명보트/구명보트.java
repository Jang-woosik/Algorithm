import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
		Arrays.sort(people);
		int idx=0;
		int answer=0;
		for(int i=people.length-1;i>=0;i--) {
			if(idx>i)break;
			if(people[i]+people[idx]<=limit) {
				idx++;
				answer++;
			}else {
				answer++;
			}
		}
		return answer;
    }
}