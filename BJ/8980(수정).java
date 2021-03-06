import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	
	static int[] now;
	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		int last_city = sc.nextInt(); // 마지막 시티 .
		int cargo = sc.nextInt(); // 최대 값
		
		int n = sc.nextInt();

		ArrayList<City> city = new ArrayList<>();
		for(int i =0; i<n;i++) {
			int st = sc.nextInt();
			int end = sc.nextInt();
			int cnt = sc.nextInt();
			city.add(new City(st,end,cnt));
			
		}
		int[] box = new int[last_city+1]; // 해당 마들 별로 얼마나 실고 있는지. 
		Collections.sort(city); // 받은 마을 오름차순 정렬 합니다. 
		int total = 0;
		for(City ct : city) {
			int st = ct.st;
			int end = ct.end;
			int cnt = ct.cnt;
			
			int max = 0; 
			boolean flag = true; // 실을 수 있는지 없는지. 
			for(int i= st; i<end;i++) {
				if(box[i]>=cargo) {
					flag = false;
					break;
				}
				max = Math.max(max,box[i]);// 현상황에서의 실은 최대 값. 
			}
			if(flag) { // 실을수 있다면
				int load = cargo - max; // 얼마나 가능한가. 
				if( load > cnt) load = cnt;
				total +=load;
				for(int i =st; i<end;i++) {
					box[i]+=load;
				}
				
			}
			
		}
		System.out.println(total);
		
	}
}

class City implements Comparable<City>{
	int st;
	int end;
	int cnt;
	City(int st, int end , int cnt ){
		this.st = st;
		this.end = end;
		this.cnt = cnt;
	}
	public int compareTo(City city) { // 정렬의 기준이 되는것. 
		if(this.end<city.end) return -1;
		else if ( this.end == city.end) return 0;
		else return 1;
		
	}
	
}
/* 두번쨰.. 흠.. 
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	
	static int[] now;
	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		int city = sc.nextInt(); // 마지막 시티 .
		int cargo = sc.nextInt(); // 최대 값
		
		int n = sc.nextInt();
		int[][] arr = new int[n][3];
		
		for(int i =0; i<n;i++) {
			arr[i][0] =sc.nextInt();
			arr[i][1] =sc.nextInt();
			arr[i][2] =sc.nextInt();
		}
		
		int total =0; // 운반 수 
		now = new int[city+1];
		
		
		// 정렬하기 마을 순서, 마을 순서 오름 차준 
		Arrays.sort(arr,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) return o2[0]-o1[0];
				
				return o1[1]-o2[1];
			}
			
		});
		
		System.out.println();
		for(int i =0; i<n;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
		

		// now 에 총 갯수 보다 많은지. 많으면 그냥 가 .. 
		//
		for(int i =0; i < n;i++) {
			if(check(cargo)) continue;
			total += insert(arr,i,cargo);
			
		}
		System.out.println(total);
		
	}
	private static int insert(int[][] arr, int pos, int cargo) {
		int num = cargo -now[arr[pos][0] ]; // 이번에 실을 수 있는량 
		
		for(int i =arr[pos][0]; i <now.length;i++) {
			if(now[arr[i][0] ]==0) break;
			num = Math.min(num,cargo -now[arr[i][0] ]); 
		}
		num = Math.min(num, arr[pos][2]); //실은수 있는 것과, 진짜 실은 양중 작은거   
		now[arr[pos][0]]+=num; // 자기 자신은 일단 시록 
		
		
		for(int i =arr[pos][0]+1; i <now.length;i++) {
			if(now[i]==0) break;
			now[i]+=num;
		}
		
		System.out.println("pos : "+ pos + " 배열수 : "+ Arrays.toString(now));
		return num; //이만큼 실음. 
	}
	
	// 총 갯수 보다 많은게 있다면 체크 
	private static boolean check(int cargo) {
		boolean flag = false;
		for(int i=0; i<now.length;i++) {
			if(now[i]>=cargo) {
				flag=true;
				break;
			}
		}
		
		return flag;
	}
}

*/
/* 처음 푸넉 
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	static int num =0;
	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));
		
		int city = sc.nextInt(); // 마지막 시티 .
		int cargo = sc.nextInt(); // 최대 값
		
		int n = sc.nextInt();
		int[][] arr = new int[n][3];
		
		for(int i =0; i<n;i++) {
			arr[i][0] =sc.nextInt();
			arr[i][1] =sc.nextInt();
			arr[i][2] =sc.nextInt();
		}
		int total =0; // 운반 수 
		int now =0; // 현재 담는 수 
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=1; i<=city;i++) {
			map.put(i, 0);
		}
		
		// 정렬하기 마을 순서, 마을 순서 오름 차준 
		Arrays.sort(arr,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) return o1[1]-o2[1];
				
				return o1[0]-o2[0];
			}
			
		});
		System.out.println();
		for(int i =0; i<n;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
		// 맥스로 계속 더하기 
		// 맵에 각 마을 담기  배송 담기 
		for(int i=0;i<n;i++) {
			if(map.get(arr[i][0])!=0) { // 현재 마을에서 내릴 물건이 0이 아니면
				now += - map.get(arr[i][0]); // 물건 내리고 
				total += map.get(arr[i][0]);// 운송 수량 하핳 
				System.out.println("totalc "+total+" 변경 값 "+now +" 배열 "+Arrays.toString(arr[i]));
				map.put(arr[i][0],0);// 다 내렸으니 현재 0 으로 한다. 
			}
			int max =cargo - now  ; // 몇개 까지 실을 수 있나 .  최대 수량 - 현재 실은 수량
			max = Math.min(max, arr[i][2]);
			if( max !=0) { // 아직 실을 수 있다.
				now += max; // 실었으니 최대 값 더하기 
				System.out.println(i+"<-I "+now);
				map.put(arr[i][1],map.get(arr[i][1])+max);// 마을로 배송할 운반 수량 
			}
			// 0 이면 지나가기 
		
		}
		
		System.out.println();
		System.out.println(cargo +" toatl "+total);
		
		total += map.get(city);// 마지막장소에 얼마나 갔을까.
		System.out.println(total);
		
	}
}

*/
