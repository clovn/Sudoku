public class Model {
	
	public static void mainMenu() {
		boolean isClose = false;
		byte difficulty = 1;
		while (!isClose) {
			int chosen = View.printMainMenu();
			switch (chosen) {
				case 1:
					Game game = new Game();
					game.start();
					break;
				case 2:
					View.printHelpPage();
					break;
				case 3:
					byte setting;
					setting = View.printSettingsPage();
					switch (setting) {
						case 1:
							difficulty = View.Difficulties();
							break;
						case 0:
							View.refresh("Настройки не выбраны");
							break;
					}
					break;
				case 4:
					isClose = true;
					break;
				default:
					System.out.println("Wrong input!");
					break;
			}
		}
		

	}
}