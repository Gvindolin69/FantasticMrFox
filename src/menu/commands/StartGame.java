package menu.commands;


import menu.Menu;

public class StartGame implements Command{
    private Menu menu;

    public StartGame(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.startTheGame();
    }
}
