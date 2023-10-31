import java.util.Scanner;
public class View {
	private static Scanner sc = new Scanner(System.in);
	
	public static int printMainMenu() {
		String text = "===== Главное меню =====\n" +
		"1. Играть\n" +
		"2. Помощь\n" +
		"3. Выйти\n";
		refresh(text);
		int ch = sc.nextInt();
		return ch;
	}

	public static void printHelpPage() {
		String text = "===== Правила =====\n" +
		"-От вас требуется заполнить свободные клетки цифрами от 1 до 9 так,\nчтобы в каждой строке, в каждом столбце и в каждом малом квадрате 3*3\nкаждая цифра встречалась бы только один раз\n" +
		"===== Управление =====\n" +
		"-Чтобы поставить цифру, вам нужно выбрать сектор от 1 до 9.\n-Ввести координаты места через пробел.(1 1 или 2 3 или 3 1 и т.д.).\n" +
		"-Ввести цифру которую, хотите вставить.\n" +
		"(чтобы вернуться назад введите любую цифру)\n";
		refresh(text);
		sc.nextInt();
	}

	public static void printGameResult(boolean win) {
		if (win) {
			System.out.println("Поздравляю! Ты выиграл и смог решить эту непростую задачу!");
		} else {
			System.out.println("К сожалению, вы проиграли.");
		}
	}

	public static void refresh(String text){
		System.out.print("\033\143");
		System.out.print(text);
	}
}