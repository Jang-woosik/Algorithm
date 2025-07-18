
import java.io.*;
import java.util.*;
//카드들을 리스트에 넣어두고 맨위에 카드를 버리고 그 다음 맨 위 카드를 아래로 옮긴다 이를 반복
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int a=Integer.parseInt(br.readLine());
		Queue<Integer> b=new LinkedList<>();
		for(int i=1;i<a+1;i++) {
			b.offer(i);
		}
		while(b.size()>1) {
			b.poll();
			b.offer(b.poll());
		}
		System.out.println(b.poll());
		
	}
}
