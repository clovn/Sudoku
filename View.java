import java.util.Scanner;
import java.util.Arrays;

public class View {
	
	public static int printMainMenu() {
		Scanner sc = new Scanner(System.in);
		String text = "===== Главное меню =====\n" +
                      "1. Играть\n" +
                      "2. Помощь\n" +
                      "3. Выйти\n";
		refresh(text);
		return sc.nextInt();
	}

	public static void printHelpPage() {
		Scanner sc = new Scanner(System.in);

		String text = "===== Правила =====\n" +
                      "-От вас требуется заполнить свободные клетки цифрами от 1 до 9 так,\n" +
                      "чтобы в каждой строке, в каждом столбце и в каждом малом квадрате 3*3\n" +
                      "каждая цифра встречалась бы только один раз\n" +
                      "===== Управление =====\n" +
                      "-Чтобы поставить цифру, вам нужно выбрать сектор от 1 до 9.\n" +
                      "-Ввести координаты места через пробел.(1 1 или 2 3 или 3 1 и т.д.).\n" +
                      "-Ввести цифру которую, хотите вставить.\n" +
                      "(чтобы вернуться назад введите любую цифру)\n";
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