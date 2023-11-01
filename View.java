import java.util.Scanner;
import java.util.Arrays;

public class View {
	
	public static int printMainMenu() {
		Scanner sc = new Scanner(System.in);
		String text = """
				===== Главное меню =====
				1. Играть
				2. Помощь
				3. Выйти
				""";
		refresh(text);
		return sc.nextInt();
	}

	public static void printHelpPage() {
		Scanner sc = new Scanner(System.in);

		String text = """
				===== Правила =====
				-От вас требуется заполнить свободные клетки цифрами от 1 до 9 так,
				чтобы в каждой строке, в каждом столбце и в каждом малом квадрате 3*3
				каждая цифра встречалась бы только один раз
				===== Управление =====
				-Чтобы поставить цифру, вам нужно выбрать сектор от 1 до 9.
				-Ввести координаты места через пробел.(1 1 или 2 3 или 3 1 и т.д.).
				-Ввести цифру которую, хотите вставить.
				(чтобы вернуться назад введите любую цифру)
				""";
		refresh(text);

		sc.nextLine();
	}

	public static void printGameResult(boolean win) {
		if (win) {
			System.out.println("Поздравляю! Ты выиграл и смог решить эту непростую задачу!");
		} else {
			System.out.println("К сожалению, вы проиграли.");
		}
	}

	public static void refresh(String text){
		System.out.print("\033[H\033[2J");
		System.out.print(text);
	}

	public static int[] printGameField(int[][] field) {
		String text = "---------------------\n";
		Scanner sc = new Scanner(System.in);

		for(int[] line : field) {
			text += "| ";
			for(int dg : line) {
				text += dg + " ";
			}
			text += "|\n";
		}

		text += "---------------------\n";

		refresh(text);
		System.out.print("Введите ход: ");

		return Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	}
}