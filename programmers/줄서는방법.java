import java.util.*;
class Solution {
    String ans ="";
    long[] d = new long[21];
    boolean[] visit;
    public int[] solution(int n, long k) {
        // 숫자 범위 안에 들어가는지 체크 이다.
        d[0] =1;
        visit = new boolean[n+1];
        visit[0]=true;
        
        for(int i=1; i<d.length;i++){
            d[i]= i*d[i-1];
        }
        
        long temp =k;
        int cnt =1;
        while(temp>=0){
            if(visit[cnt]) { // 이 숫자를 사용한 경험이 있다면 순차적인 다음 숫자로 넘어감. 
                cnt++;
                continue;
            }
            if(temp>d[n-1]){
                temp += - d[n-1];
                cnt++;
            }else{
                visit[cnt]=true;
                n--;
                ans+=cnt+",";
                cnt=1;
            }
        }
        
        
        String[] arr = ans.split(",");
        int[] answer = new int[arr.length];
        
        for(int i=0; i<arr.length;i++){
            answer[i] =Integer.valueOf(arr[i]);
        }
        
        return answer;
    }
}
