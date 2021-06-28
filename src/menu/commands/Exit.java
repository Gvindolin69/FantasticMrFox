package menu.commands;


import menu.Menu;

public class Exit implements Command {
   //завершение всех процессов
   private Menu menu;

    public Exit(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.exit();
    }
}
