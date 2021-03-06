import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(new InputStreamReader(System.in));

		int N = scan.nextInt(); // 보석 수
		int K = scan.nextInt(); // 가방 수
		int[] bag = new int[K];// 가방의 최대 무게;

		Gam[] gam = new Gam[N];
		for (int i = 0; i < N; i++) {
			int wei = scan.nextInt(); // 무게
			int val = scan.nextInt(); // 가격
			gam[i] = new Gam(wei,val);
		}

		
		// 우선 무게대로 정렬 합니다. 
		Arrays.sort(gam, new Comparator<Gam>() {

			@Override
			public int compare(Gam o1, Gam o2) {
				if( o1.weight == o2.weight) {
					return o2.value - o1.value;
				}
				
				return o1.weight -o2.weight;
			}
			
		});
		
		
		for (int i = 0; i < K; i++) {
			bag[i] = scan.nextInt(); // 가방 최대 무게
		}
		
		Arrays.sort(bag);
		// 최대 1개의 보석만 넣을 수 있다.
		// 오름 차순 정렬
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		long answer =0;
		
		int pos =0;
		for(int i=0;i<K;i++) {
			// 지금 가방의무게보다 작거나 같은 보석을 보두 우선순위에 넣는다. 
			while( pos<N&& gam[pos].weight<=bag[i]) {
				pq.offer(gam[pos].value);
				pos++;
			}
			System.out.println(" size "+pq.size());
			// 한깨씩 뽑음 결국 가방 갯수 만큼만 뽑으면 댐. 
			if(!pq.isEmpty()) {
				answer+= pq.poll();
			}
		}
		
		
		
		System.out.println(answer);
	}
}

class Gam{
	int weight;
	int value;
	
	Gam(int weight, int value){
		this.weight =weight;
		this.value =value;
	}
}






/* 수정 요망 


import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(new InputStreamReader(System.in));

		int N = scan.nextInt(); // 보석 수  
		int K = scan.nextInt(); // 가방 수 
		boolean[] check = new boolean[N]; // 보석이 들어간 여부 
		int[][] gem = new int[N][2];// 보석 무게 , 가격
		int[] bag = new int[K];// 가방의 최대 무게; 
		
		for(int i =0; i<gem.length;i++) {
			gem[i][0] =scan.nextInt(); // 무게
			gem[i][1] =scan.nextInt(); // 가격
			
		}
		
		for(int i =0; i<bag.length;i++) {
			bag[i] =scan.nextInt(); // 가방 최대 무게 
		}
		// 최대 1개의 보석만 넣을 수 있다. 
		// 오름 차순 정렬 
		Arrays.sort(gem, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o2[1]==o1[1]) return o2[0]-o1[0];
				return o2[1] -o1[1];
			}
			
		}
				);
		Arrays.sort(bag);
		int pos = 0;
		int sum =0;
		int cnt =0;//몇개일까
		
		for(int i=0; i<bag.length;i++) {
			int weight = bag[i];
			for(int k=0; k<gem.length;k++) {
				if(check[k]) continue;
				if(weight>=gem[k][0]) {
					System.out.println("i : "+i+"  K : "+k);
					sum+=gem[k][1];
					check[k]= true;
					break;
				}
			}
			
		}
		
		
		System.out.println();
		for(int i =0; i<gem.length;i++) {
			System.out.println(Arrays.toString(gem[i]));
		}
		System.out.println();
		System.out.println(Arrays.toString(bag));
		System.out.println();
		System.out.println(sum);
	}
}

5 3
1 99
1 44
5 23
2 99
2 88
10
2
1

3 2
1 65
5 23
2 99
10
2



*/
