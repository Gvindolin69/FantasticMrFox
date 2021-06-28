package menu;

import components.FoxMethods;
import components.Paragraph;
import menu.commands.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class Menu {
    private int wayPoint;
    private FoxMethods methods = new FoxMethods();
    private Paragraph[][] foxAdventures = methods.makeFoxMatrix();
    private Properties foxProperties = methods.getProperties();
    private Scanner scanner = new Scanner(System.in);

    public Menu() {
        methods.initProperties("fox.properties");
        this.foxProperties = methods.getProperties();
    }

    public void startTheGame(){
        wayPoint = 0;
        System.out.println("Для вызова меню введите /menu");
        System.out.println(foxAdventures[1][1].getText());

        while (true) {
            ArrayList<Paragraph> availableWays = FoxMethods.findAvailableWays(wayPoint, foxAdventures);
            String theChoice = scanner.nextLine();
            if (theChoice.equals("1")) {
                System.out.println(availableWays.get(0).getText());
                if (availableWays.get(0).isDeadEnd()) break;
                else wayPoint = Integer.parseInt(availableWays.get(0).getNum());
            }
            if(theChoice.equals("2")){
                System.out.println(availableWays.get(1).getText());
                if (availableWays.get(1).isDeadEnd()) break;
                else wayPoint = Integer.parseInt(availableWays.get(1).getNum());
            }
            if (theChoice.equals("/menu")){
                showMenu();
            }
        }
    }

    public void loadGame(){
        if (!new File("saves.properties").isFile()) {
            System.out.println("Нет доступных сохранений");
            showMenu();
        }else{
            FoxMethods methods1 = new FoxMethods();
            methods1.initProperties("saves.properties");
            Properties properties = methods1.getProperties();
            System.out.println("Имена доступных сохранений: " + properties.stringPropertyNames());
            System.out.println("Выберите сохранение");
            String saveName = scanner.nextLine();
            wayPoint = Integer.parseInt(properties.getProperty(saveName));
            System.out.println("Для вызова меню введите /menu");
            System.out.println(foxProperties.getProperty(Integer.toString(wayPoint)));
            while (true) {
                ArrayList<Paragraph> availableWays = FoxMethods.findAvailableWays(wayPoint, foxAdventures);
                String theChoice = scanner.nextLine();
                if (theChoice.equals("1")) {
                    System.out.println(availableWays.get(0).getText());
                    if (availableWays.get(0).isDeadEnd()) break;
                    else wayPoint = Integer.parseInt(availableWays.get(0).getNum());
                }
                if (theChoice.equals("2")) {
                    System.out.println(availableWays.get(1).getText());
                    if (availableWays.get(1).isDeadEnd()) break;
                    else wayPoint = Integer.parseInt(availableWays.get(1).getNum());
                }
                if (theChoice.equals("/menu")) {
                    showMenu();
                }
            }
        }
    }


    public void saveGame(){
        methods.writeSaveProp(wayPoint, scanner);
        showMenu();
    }

    public void backToGame(){
        System.out.println(foxProperties.getProperty(Integer.toString(wayPoint)));
    }

    public void showMenu() {
        if (wayPoint == 0) {
            Command start = new StartGame(this);
            Command load = new LoadGame(this);
            Command exit = new Exit(this);
            Invoker invoker = new Invoker(start, load, exit);
            System.out.println("Menu:\n1. New Game\n2. Load game\n3. Exit\n(pls enter a number)");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();

            switch (str) {
                case "1":
                    invoker.startGame();
                    break;
                case "2":
                    invoker.loadGame();
                    break;
                case "3":
                    invoker.exit();
                    break;
                default:
                    System.out.println("Pls enter a correct number");
            }

        } else {
            Command start = new StartGame(this);
            Command load = new LoadGame(this);
            Command save = new SaveGame(this);
            Command back = new Back(this);
            Command exit = new Exit(this);
            Invoker invoker = new Invoker(start, load, save, back, exit);
            System.out.println("Menu:\n1. New Game\n2. Load game\n3. Save game\n4. Back to game\n5. Exit\n(pls enter a number)");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();

            switch (str) {
                case "1":
                    invoker.startGame();
                    break;
                case "2":
                    invoker.loadGame();
                    break;
                case "3":
                    invoker.saveGame();
                    break;
                case "4":
                    invoker.back();
                    break;
                case "5":
                    invoker.exit();
                    break;
                default:
                    System.out.println("Pls enter a correct number");
            }
        }
    }

    public void exit(){
        System.out.println("Выход из игры");
        System.exit(0);
    }
}
