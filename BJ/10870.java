
public class Main {
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		int N = in.nextInt();
  // 피보나치 . 
		System.out.println(fibonacci(N));
 
	}
 
	static int fibonacci(int N) {
		if (N == 0)	return 0;
		if (N == 1)	return 1;
		return fibonacci(N - 1) + fibonacci(N - 2);
	}
}
