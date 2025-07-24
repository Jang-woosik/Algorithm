import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        ArrayList<Integer>a=new ArrayList<>();
        st=new StringTokenizer(br.readLine());
        int max=0;
        for(int i=0;i<N;i++) {
        	a.add(Integer.parseInt(st.nextToken()));
        }
        for(int i=0;i<N-2;i++) {
        	for(int j=i+1;j<N-1;j++) {
        		for(int k=j+1;k<N;k++) {
        			if(a.get(i)+a.get(j)+a.get(k)<=M) {
        				max=Math.max(a.get(i)+a.get(j)+a.get(k), max);
        			}
        		}
        	}
        }
        
        System.out.println(max);

    }
   
}
