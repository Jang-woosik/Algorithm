import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int L=Integer.parseInt(st.nextToken());
        int[] arr=new int[N];
        int n=0;
        int sum=0;
        arr[0]+=1;
        while(true) {
        	if(arr[n]==M) {
        		break;
        	}
        	
        	if(arr[n]%2==1) {
        		n=n+L;
        		n=n%(N);
        		arr[n]++;

        	}else if(arr[n]%2==0) {
        		if(n-L<0) {
        			n=(n - L + N) % N;
        			arr[n]++;

        		}else {
        			n=n-L;
        			arr[n]++;

        		}
        	}
        	
        	
        }
        for(int i=0;i<N;i++) {
        	sum+=arr[i];
        }
        System.out.println(sum-1);

    }
   
}
