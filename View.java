import java.util.Scanner;
public class View {
	
	public static int printMainMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===== Главное меню =====");
		System.out.println("1. Играть");
		System.out.println("2. Помощь");
		System.out.println("3. Выйти");
		int ch = sc.nextInt();
		return ch;
	}



}