import java.io.*;
import java.util.*;

/*
 * 3번째에 있는걸 비교해
 * 0번이면 1번 1번이 돌면 2번 2번이 돌면 3번
 * 1번 돌면 0,2번 다음 3번
 * 2번 돌면 1,3번 다음 0번
 * 3번 돌면 2->1->0
 * 자석 처음에 수가 1이면 더해짐
 */


public class Solution { 
	
	
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int T = Integer.parseInt(br.readLine());
      
      for(int s = 1; s < T+1 ; s++) {
    	  int K = Integer.parseInt(br.readLine());
    	  
    	  int[][]map=new int[4][8];
    	  int[][]map2=new int[4][8];
    	  
    	  for(int i=0;i<4;i++) {
    		  StringTokenizer st = new StringTokenizer(br.readLine());
    		  for(int j=0;j<8;j++) {
    			  map[i][j] = Integer.parseInt(st.nextToken());
    		  }
    	  }
    	  //a가 뭔지에 따라 회전을 어떻게 시킬지
    	  for(int i=0;i<K;i++) {
    		  for(int j=0;j<4;j++) {
        		  for(int k=0;k<8;k++) {
        			  map2[j][k] = map[j][k];
        		  }
        	  }
    		  StringTokenizer st = new StringTokenizer(br.readLine());
    		  int a=Integer.parseInt(st.nextToken());
    		  int b=Integer.parseInt(st.nextToken());
    		  if(a==1) {
    			  if(b==1) {//시계방향
    				  map2[0][0]=map[0][7];
    				  for(int j=0;j<7;j++) {
    					  map2[0][j+1]=map[0][j];
    				  }
    				  if(map[0][2]!=map[1][6]) {//다르면 반시계
    					  map2[1][7]=map[1][0];
        				  for(int j=0;j<7;j++) {
        					  map2[1][j]=map[1][j+1];
        				  }
        				  if(map[1][2]!=map[2][6]) {//&&다르면 시계
        					  map2[2][0]=map[2][7];
            				  for(int j=0;j<7;j++) {
            					  map2[2][j+1]=map[2][j];
        				  }
            				  if(map[2][2]!=map[3][6]) {//&& && 다르면 반시계
            					  map2[3][7]=map[3][0];
                				  for(int j=0;j<7;j++) {
                					  map2[3][j]=map[3][j+1];
                				  }
            				  }
        				  }
    				  }
    			  }
    			  else {//반시계
    				  map2[0][7]=map[0][0];
    				  for(int j=0;j<7;j++) {
    					  map2[0][j]=map[0][j+1];
    				  }if(map[0][2]!=map[1][6]) {//다르면 시계
    					  map2[1][0]=map[1][7];
        				  for(int j=0;j<7;j++) {
        					  map2[1][j+1]=map[1][j];
        				  }
        				  if(map[1][2]!=map[2][6]) {//&&다르면 반시계
        					  map2[2][7]=map[2][0];
            				  for(int j=0;j<7;j++) {
            					  map2[2][j]=map[2][j+1];
        				  }
            				  if(map[2][2]!=map[3][6]) {//&& && 다르면 시계
            					  map2[3][0]=map[3][7];
                				  for(int j=0;j<7;j++) {
                					  map2[3][j+1]=map[3][j];
                				  }
            				  }
        				  }
    				  }
    			  }
    		  }else if(a==2) {//1번은 0,2랑 연결 2는 3이랑 연결
    			  if(b==1) {//시계
    				  map2[1][0]=map[1][7];
    				  for(int j=0;j<7;j++) {
    					  map2[1][j+1]=map[1][j];
    				  }
    				  if(map[0][2]!=map[1][6]) {//다르면 반시계
    					  map2[0][7]=map[0][0];
        				  for(int j=0;j<7;j++) {
        					  map2[0][j]=map[0][j+1];
        				  }
    				  }
    				  if(map[2][6]!=map[1][2]) {//다르면 반시계
    					  map2[2][7]=map[2][0];
        				  for(int j=0;j<7;j++) {
        					  map2[2][j]=map[2][j+1];
        				  }if(map[2][2]!=map[3][6]) {//&& && 다르면 시계
        					  map2[3][0]=map[3][7];
            				  for(int j=0;j<7;j++) {
            					  map2[3][j+1]=map[3][j];
            				  }
        				  }
        				  
    				  }
    			  }else {//반시계
    				  map2[1][7]=map[1][0];
    				  for(int j=0;j<7;j++) {
    					  map2[1][j]=map[1][j+1];
    				  }
    				  if(map[0][2]!=map[1][6]) {//다르면 반시계
    					  map2[0][0]=map[0][7];
        				  for(int j=0;j<7;j++) {
        					  map2[0][j+1]=map[0][j];
        				  }
    				  }
    				  if(map[2][6]!=map[1][2]) {//다르면 반시계
    					  map2[2][0]=map[2][7];
        				  for(int j=0;j<7;j++) {
        					  map2[2][j+1]=map[2][j];
        				  }if(map[2][2]!=map[3][6]) {//&& && 다르면 시계
        					  map2[3][7]=map[3][0];
            				  for(int j=0;j<7;j++) {
            					  map2[3][j]=map[3][j+1];
            				  }
        				  }
        				  
    				  }
    			  }
    			  
    		  }else if(a==3) {
        			  if(b==1) {//시계
        				  map2[2][0]=map[2][7];
        				  for(int j=0;j<7;j++) {
        					  map2[2][j+1]=map[2][j];
        				  }
        				  if(map[2][2]!=map[3][6]) {//다르면 반시계
        					  map2[3][7]=map[3][0];
            				  for(int j=0;j<7;j++) {
            					  map2[3][j]=map[3][j+1];
            				  }
        				  }
        				  if(map[2][6]!=map[1][2]) {//다르면 반시계
        					  map2[1][7]=map[1][0];
            				  for(int j=0;j<7;j++) {
            					  map2[1][j]=map[1][j+1];
            				  }if(map[1][6]!=map[0][2]) {//&& && 다르면 시계
            					  map2[0][0]=map[0][7];
                				  for(int j=0;j<7;j++) {
                					  map2[0][j+1]=map[0][j];
                				  }
            				  }
            				  
        				  }
        			  }else {//반시계
        				  map2[2][7]=map[2][0];
        				  for(int j=0;j<7;j++) {
        					  map2[2][j]=map[2][j+1];
        				  }
        				  if(map[2][2]!=map[3][6]) {//다르면 반시계
        					  map2[3][0]=map[3][7];
            				  for(int j=0;j<7;j++) {
            					  map2[3][j+1]=map[3][j];
            				  }
        				  }
        				  if(map[2][6]!=map[1][2]) {//다르면 반시계
        					  map2[1][0]=map[1][7];
            				  for(int j=0;j<7;j++) {
            					  map2[1][j+1]=map[1][j];
            				  }if(map[1][6]!=map[0][2]) {//&& && 다르면 시계
            					  map2[0][7]=map[0][0];
                				  for(int j=0;j<7;j++) {
                					  map2[0][j]=map[0][j+1];
                				  }
            				  }
            				  
        				  }
        			  }
    			  
    		  }else if(a==4) {//a가 4일때
    			  if(b==1) {//시계방향
    				  map2[3][0]=map[3][7];
    				  for(int j=0;j<7;j++) {
    					  map2[3][j+1]=map[3][j];
    				  }
    				  if(map[3][6]!=map[2][2]) {//다르면 반시계
    					  map2[2][7]=map[2][0];
        				  for(int j=0;j<7;j++) {
        					  map2[2][j]=map[2][j+1];
        				  }
        				  if(map[1][2]!=map[2][6]) {//&&다르면 시계
        					  map2[1][0]=map[1][7];
            				  for(int j=0;j<7;j++) {
            					  map2[1][j+1]=map[1][j];
        				  }
            				  if(map[1][6]!=map[0][2]) {//&& && 다르면 반시계
            					  map2[0][7]=map[0][0];
                				  for(int j=0;j<7;j++) {
                					  map2[0][j]=map[0][j+1];
                				  }
            				  }
        				  }
    				  }
    			  }
    			  else {//반시계
    				  map2[3][7]=map[3][0];
    				  for(int j=0;j<7;j++) {
    					  map2[3][j]=map[3][j+1];
    				  }if(map[2][2]!=map[3][6]) {//다르면 시계
    					  map2[2][0]=map[2][7];
        				  for(int j=0;j<7;j++) {
        					  map2[2][j+1]=map[2][j];
        				  }
        				  if(map[1][2]!=map[2][6]) {//&&다르면 반시계
        					  map2[1][7]=map[1][0];
            				  for(int j=0;j<7;j++) {
            					  map2[1][j]=map[1][j+1];
        				  }
            				  if(map[0][2]!=map[1][6]) {//&& && 다르면 반시계
            					  map2[0][0]=map[0][7];
                				  for(int j=0;j<7;j++) {
                					  map2[0][j+1]=map[0][j];
                				  }
            				  }
        				  }
    				  }
    			  }  
    			  }
    		  for(int j=0;j<4;j++) {
    			  for(int k=0;k<8;k++) {
    				  map[j][k]=map2[j][k];
    			  }
    		  }
    	  }
    		
    	  int total=0;
    	  for(int i=0;i<4;i++) {
    		  total+=map[i][0]*Math.pow(2, i);
    	  }
    	  System.out.println("#"+s+" "+total);
      }
    }
    
}