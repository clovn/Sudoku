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
                      "-Чтобы поставить цифру, вам нужно ввести координаты (x, y) места через пробел(1 1 или 4 5 или 9 9 и т.д.)" +
                      "-Ввести цифру которую, хотите вставить.\n" +
                      "(чтобы вернуться назад нажмите Enter)\n";
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
		String text = "    1 2 3 4 5 6 7 8 9 \n  ---------------------\n";
		Scanner sc = new Scanner(System.in);
		int i = 1;

		for(int[] line : field) {
			text += i + " | ";
			i++;
			for(int dg : line) {
				if(dg == 0) text += "_ ";
				else text += dg + " ";
			}
			text += "|\n";
		}

		text += "  ---------------------\n";

		refresh(text);
		System.out.print("Введите ход: ");

		return Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).map(n -> n-1).toArray();
	}
}