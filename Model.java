public class Model {
	
	public static void mainMenu() {
		boolean isClose = false;
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
					options();
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

	public static void options(){
		switch (View.printSettingsPage()) {
			case 1:
				Game.setDifficulty(View.Difficulties());
				break;
			default:
				View.refresh("Настройки не выбраны");
				break;
		}
	}
}