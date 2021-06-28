package menu.commands;

import menu.Menu;

public class SaveGame implements Command {
    private Menu menu;

    public SaveGame(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.saveGame();
    }
}
