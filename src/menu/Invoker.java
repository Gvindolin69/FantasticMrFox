package menu;

import menu.commands.Command;

public class Invoker {
    private Command start;
    private Command load;
    private Command save;
    private Command exit;
    private Command back;

    public Invoker(Command start, Command load, Command save, Command back, Command exit) {
        this.start = start;
        this.load = load;
        this.exit = exit;
        this.save = save;
        this.back = back;
    }

    public Invoker(Command start, Command load, Command exit) {
        this.start = start;
        this.load = load;
        this.exit = exit;
    }

    public void startGame(){
        start.execute();
    }

    public void loadGame(){
        load.execute();
    }

    public void saveGame(){save.execute();}

    public void back(){back.execute();}

    public void exit(){exit.execute();}
}
