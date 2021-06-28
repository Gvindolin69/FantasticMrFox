package menu.commands;


import menu.Menu;

public class LoadGame implements Command{
    private Menu menu;

    public LoadGame(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.loadGame();
    }
}
