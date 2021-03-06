
/* 초과하느 잘 못된 솔루션 . import java.util.*;
class Solution {
    int cnt =9;
    public int solution(int N, int number) {
        int answer = -1;
        if(N==number) return 1;//수정
        
        
        check(number,N,N+N,2);
        check(number,N,N*N,2);
        check(number,N,N/N,2);
        check(number,N,N-N,2);
        check(number,N,N*10+N,2);// 수정 반영
        
        if (cnt<=8){ // 최소값 8 이다. 수정
            answer =cnt;
        }
        return answer;
    }
    public void check(int num,int N, int ans,int count){
        if(num==ans){
            cnt = Math.min(cnt,count);
            return;
        }
        if(cnt<count) return;
        
        
            check(num,N,ans+N,count+1);
            check(num,N,ans*N,count+1);
            check(num,N,ans*10+N,count+1);// 수정
            check(num,N,ans/N,count+1);
            check(num,N,ans-N,count+1);
        
        
        
    }
}

// 정답 입니다. 
import java.util.*;
class Solution {
// 숫자를 최대 8개 까지 이용이 가능합니다. 
// Set 을 이용해 겹치는 숫자를 제외ㅏㄴ 답만 저장할 수 있도록
    
    HashSet<Integer>[] dp = new HashSet[9];
    public int solution(int N, int number) {
        if(N==number) return 1; // 같으면 그냥 1이얌.
        
        String n = String.valueOf(N);
        for(int i=0; i<=8;i++){
            dp[i]= new HashSet<Integer>(); // 생성자
            if(i==1) dp[1].add(Integer.valueOf(n));
            if(i<2) continue;
            // dp[3]에는 NNN이렇게 입력이 될 수 있도록
            n+=String.valueOf(N);
            dp[i].add(Integer.valueOf(n));
            // 숫자로 입력합니다. 
            for(int j=1;j<i;j++){
                // 계산해 봅니다.
                cal(j,i);
                if(dp[i].contains(number)){
                    return i;
                }   
            }
        }
        return -1;
    }
    // N의 갯수 마다 사칙연산 해줘서 배열에 담는 것이다.
    public void cal(int a, int b ){
        Iterator<Integer> listA = dp[a].iterator();
        Iterator<Integer> listB = dp[b-a].iterator();//?
        
        while(listA.hasNext()){
            int numA = listA.next();
            while(listB.hasNext()){
                int numB = listB.next();
                dp[b].add(numA+numB);
                dp[b].add(numA-numB);
                dp[b].add(numA*numB);
                if(numB!=0) dp[b].add(numA/numB);
            }
            listB =dp[b-a].iterator();
        }
    }
    
}
*/
