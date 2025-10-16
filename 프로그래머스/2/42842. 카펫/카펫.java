class Solution {
    public int[] solution(int brown, int yellow) {
        int[]answer=new int[2];
		for(int W=1;W<brown;W++) {
			for(int H=1;H<brown;H++) {
				if(W*H-yellow==brown&&(W-2)*(H-2)==yellow) {
					answer[0]=W;
					answer[1]=H;
				}else {
					continue;
				}
			}
		}
		return answer;
    }
}