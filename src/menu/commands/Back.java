package menu.commands;

import menu.Menu;

public class Back implements Command{
    private Menu menu;

    public Back(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.backToGame();
    }
}
