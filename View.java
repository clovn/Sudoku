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

	public static void printHelpPage() {
		System.out.println("===== Правила =====");
		System.out.println("-От вас требуется заполнить свободные клетки цифрами от 1 до 9 так,\nчтобы в каждой строке, в каждом столбце и в каждом малом квадрате 3*3\nкаждая цифра встречалась бы только один раз");
		System.out.println("===== Управление =====");
		System.out.println("-Чтобы поставить цифру, вам нужно выбрать сектор от 1 до 9.\n-Ввести координаты места через пробел.(1 1 или 2 3 или 3 1 и т.д.).");
		System.out.println("-Ввести цифру которую, хотите вставить.");
	}

	public static void printGameResult(boolean win) {
		if (win) {
			System.out.println("Поздравляю! Ты выиграл и смог решить эту непростую задачу!");
		} else {
			System.out.println("К сожалению, вы проиграли.");
		}
	}
}