import java.util.Scanner;
import java.util.Arrays;

public class View {

	public static int printMainMenu() {
		Scanner sc = new Scanner(System.in);

		String text = "===== Главное меню =====\n" +
				"1. Играть\n" +
				"2. Помощь\n" +
				"3. Настройки\n" +
				"4. Выйти\n";
		refresh(text);

		try {
			return sc.nextInt();
		} catch (Exception e) {
			return -1;
		}
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

	public static int printSettingsPage() {
		Scanner sc = new Scanner(System.in);
		String text;
		text = "1. Выбрать сложность игры.\n";
		refresh(text);
		int chosen = 0;
		try {
			chosen = sc.nextInt();
		} catch (Exception e) {
			printException(e.getMessage());
			printSettingsPage();
		}

		return chosen;
	}

	public static int Difficulties() {
		Scanner sc = new Scanner(System.in);
		int difficulty;
		String text = "1. Легко\n" +
				"2. Средне\n" +
				"3. Сложно\n";

		do {
			refresh(text);
			difficulty = sc.nextByte();
		} while (!(1 <= difficulty && difficulty <= 3));

		return difficulty;
	}

	public static void printGameResult(boolean win, double time) {
		Scanner sc = new Scanner(System.in);

		if (win) {
			refresh("Поздравляю! Ты выиграл и смог решить эту непростую задачу!\n");
		} else {
			refresh("К сожалению, вы проиграли.\n");
		}
		if (time < 60) {
			System.out.println("Вы закончили игру за: " + time + " секунд.");
		} else {
			System.out.println("Вы закончили игру за: " + time/60.0 + " минут.");
		}
		System.out.println("press enter to continue...");
		sc.nextLine();
	}

	public static void refresh(String text) {
		System.out.print("\033[H\033[2J");
		System.out.print(text);
	}

	public static int[] printField(int[][] field) {
		String text = "    1 2 3   4 5 6   7 8 9 \n  -------------------------\n";
		Scanner sc = new Scanner(System.in);
		int[] guess = new int[3];
		int i = 1;

		for (int[] line : field) {
			text += i + " | ";

			for (int j = 0; j < 9; j++) {
				text += line[j] != 0 ? line[j] + " " : "_ ";
				if (j % 3 == 2) text += "| ";

			}

			text += "\n";

			if (i == 9) text += "  -------------------------\n";
			else if ((i - 1) % 3 == 2) text += "  |-------|-------|-------|\n";

			i++;
		}

		text += "Введите ход: ";

		refresh(text);

		try {
			guess = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).map(n -> n - 1).toArray();
		} catch (Exception e) {
			printException("Wrong input");
			return null;
		}


		for (int n : guess) {
			if (n < 0 || n > 8) {
				printException("использовать можно только цифры");
				return null;
			}

		}
		return guess;

	}

	public static void printException(String e) {
		Scanner sc = new Scanner(System.in);
		String line;
		line = "ERROR: " + e + "\n" + "press enter to continue...";
		refresh(line);
		sc.nextLine();
	}
}