import java.io.*;
import java.util.*;
class Solution
{
    public int solution(String s){
        Deque<Character>st=new ArrayDeque<>();
        for(int i=0;i<s.length();i++) {
        	char a=s.charAt(i);
        	if(st.size()!=0&&st.peek()==a) {
        		st.pop();
        	}else {
        		st.push(a);
        	}
        }
        if(st.isEmpty()) {
        	return 1;
        }else {
        	return 0;
        }
    }
}