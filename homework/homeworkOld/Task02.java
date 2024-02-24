public class Task02 {
	
	public static void main (String [] args) {
		
		int n = Integer.parseInt(args[0]);
		
		for (int i = 1; i <= n; i++) {
			
			// print n*2-i free spaces
			for (int j = 1; j <= n*2 - i; j++) {
				System.out.print(' ');
			}
			
			for (int j = 1; j <= i * 2 - 1; j++) {
				System.out.print('*');
			}
			
			System.out.println();
		}
		
		//print another n lines
		for (int i = 1; i<= n; i++) {
			// print n-i free spaces
			for (int j = 1; j <= n - i; j++) {
				System.out.print(' ');
			}
			
			// print i * 2 - 1 stars
			for (int j = 1; j <= i * 2 - 1; j++) {
				System.out.print('*');
			}
			
			// print n - i * 2 + 1 free spaces
			for (int j = 1; j <= n * 2 - i * 2 + 1; j++) {
				System.out.print(' ');
			}
			
			// print another i * 2 - 1 stars
			
			for (int j = 1; j <= i * 2 - 1; j++) {
				System.out.print('*');
				
			
			}
		
		System.out.println();
		}
	}
}