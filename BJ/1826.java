/*
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));
		PriorityQueue<Stat> q = new PriorityQueue<>(); // 거리 대로 정렬 합니다.
		// 거리별로 오름 차순 정렬 후 
		int n = sc.nextInt(); // 1부터 n까지 숫자의 수 
		
		for(int i =0; i<n;i++) {
			int a = sc.nextInt(); //거리 
			int b = sc.nextInt();// 기름 값
			q.add(new Stat(a,b));
		}
		
		int dis = sc.nextInt(); // 최종 거리 
		int save = sc.nextInt(); // 비축한 기음의 량 
		
		Stat[] stat = new Stat[n];
		int pos = 0;
		
		while(!q.isEmpty()) {
			Stat s = q.poll();
			stat[pos] = new Stat(s.pos,s.oil);
			pos++;
		} // 배열에 입력하고 . 
		
		int cnt =0;
		pos= 0;
		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
		// 최대가 앞으로 나올 수 있도록 역순 정렬 이비다 
		while(true) {
			if(save>=dis) break; // 비축한것이 더 많이 지면 이제는 할 필요가 없습니다. 
			while(pos<n&& stat[pos].pos<=save) {
				max.add(stat[pos].oil);
				pos++;
			}
			if( max.isEmpty()) break;
			save += max.poll();
			cnt++;
		}
		
		if(save>=dis) System.out.println(cnt);
		else System.out.println("-1");
	}
	
}
// 위치 저장용 우선순위 튜 사요
class Stat implements Comparable<Stat>{
	int pos;
	int oil;
	Stat (int pos, int oil){
		this.pos= pos;
		this.oil=oil;
	}
	public int compareTo(Stat o) {
		return this.pos -o.pos;
	}
	
}

*/

/*
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {

		Scanner sc = new Scanner(new InputStreamReader(System.in));
		PriorityQueue<Stat> q = new PriorityQueue<>(); // 거리 대로 정렬 합니다.
		
		int n = sc.nextInt(); // 1부터 n까지 숫자의 수 
		for(int i =0; i<n;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			q.add(new Stat(a,b));
		}
		int dis = sc.nextInt();
		int save = sc.nextInt();
		
		Stat[] stat = new Stat[n];
		int pos = 0;
		
		while(!q.isEmpty()) {
			Stat s = q.poll();
			stat[pos] = new Stat(s.pos,s.oil);
			pos++;
		}
		int cnt =0;
		pos= 0;
		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
		// 최대가 앞으로 나올 수 있도록 역순 정렬 이비다 
		while(true) {
			if(save>=dis) break;
			while(pos<n&& stat[pos].pos<=save) {
				max.add(stat[pos].oil);
				pos++;
			}
			if( max.isEmpty()) break;
			save += max.poll();
			cnt++;
		}
		
		if(save>=dis) System.out.println(cnt);
		else System.out.println("-1");
	}
	
}
// 위치 저장용 우선순위 튜 사요
class Stat implements Comparable<Stat>{
	int pos;
	int oil;
	Stat (int pos, int oil){
		this.pos= pos;
		this.oil=oil;
	}
	public int compareTo(Stat o) {
		return this.pos -o.pos;
	}
	
}

*/
