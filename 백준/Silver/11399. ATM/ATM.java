import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        ArrayList<Integer>a=new ArrayList<>();
        ArrayList<Integer>b=new ArrayList<>();
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	a.add(Integer.parseInt(st.nextToken()));
        }
        int sum=0;
        Collections.sort(a);
        for(int i=0;i<N;i++) {
        	sum+=a.get(i);
        	b.add(sum);
        }
        int sum1=0;
        for(int i=0;i<N;i++) {
        	sum1+=b.get(i);
        }
        System.out.println(sum1);

    }
   
}
