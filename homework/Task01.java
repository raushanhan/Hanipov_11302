public class Task01 {
	
	public static void main(String [] args) {

		int n = Integer.parseInt(args[0]);

		// выведи n строчек, номер строки = количество *
		for (int i = 1; i <= n; i++) {
			
			//вывести i звёздочек в строчку

			for (int j = 1; j <= i; j++) {
				System.out.print('*');
			}
			// перенести строку
			System.out.println();
			
		}
		
		System.out.println();
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= n - i; j++) {
				System.out.print("*");
				}
			
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 1; i <= n; i++) {
			
			//выведи сколько-то пробелов
			for (int j = 1; j <= n - i; j++) {
				System.out.print(' ');
			}

			for (int j = 1; j <= i; j++) {
				System.out.print('*');
			}
			// перенести строку
			System.out.println();
			
		}
	}
}