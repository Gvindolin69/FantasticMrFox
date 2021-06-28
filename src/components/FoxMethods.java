package components;

import menu.Menu;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class FoxMethods {
    private Properties properties;

    public FoxMethods() {
        this.properties = new Properties();
    }

    public Properties getProperties(){
        return properties;
    }

    public void gameInit(){
        Menu menu = new Menu();
        menu.showMenu();
    }

    public void initProperties(String path){
        try(InputStream input = FoxMethods.class.getClassLoader().getResourceAsStream(path)){
            assert input != null;
            InputStreamReader reader = new InputStreamReader(input, StandardCharsets.UTF_8);
            properties.load(reader);
        }catch(
                IOException e) {
            System.out.println("Reading error");
        }
    }

    public void writeSaveProp(int wayPoint, Scanner scanner){
        wayPoint = wayPoint;
        try(FileWriter writer = new FileWriter("resources/saves.properties", true))
        {
            System.out.println("Веедите название сохранения");
            String saveName = scanner.nextLine();
            writer.write(saveName + "=" + wayPoint);
            writer.append('\n');
            writer.flush();
            System.out.println("Сохранение успешно");
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Paragraph> findAvailableWays(int fromPoint, Paragraph[][] paragraphs) {
        ArrayList<Paragraph> availableWays = new ArrayList<>();
        for (int i = 0; i < paragraphs.length; i++) {
            if (!(paragraphs[fromPoint][i] == null)) {
                availableWays.add(paragraphs[fromPoint][i]);
            }
        }
        return availableWays;
    }

    public Paragraph[][] makeFoxMatrix(){
        Paragraph[][] paragraphs = new Paragraph[13][13];

        Constructor constructor = new Constructor();
        FoxMethods methods = new FoxMethods();
        methods.initProperties("fox.properties");
        Properties properties = methods.getProperties();
        constructor.setProperties(properties);

        Paragraph paragraph0 = constructor.paragraphConstructor("0"); //нулевой
        Paragraph paragraph1 = constructor.paragraphConstructor("1");
        paragraph1.setDeadEnd(true);//тупик
        Paragraph paragraph2 = constructor.paragraphConstructor("2");
        Paragraph paragraph3 = constructor.paragraphConstructor("3");
        paragraph3.setDeadEnd(true);//тупик
        Paragraph paragraph4 = constructor.paragraphConstructor("4");
        Paragraph paragraph5 = constructor.paragraphConstructor("5");
        Paragraph paragraph6 = constructor.paragraphConstructor("6");
        Paragraph paragraph7 = constructor.paragraphConstructor("7");
        Paragraph paragraph8 = constructor.paragraphConstructor("8");
        Paragraph paragraph9 = constructor.paragraphConstructor("9");
        paragraph9.setDeadEnd(true);//тупик
        Paragraph paragraph10 = constructor.paragraphConstructor("10");
        Paragraph paragraph11 = constructor.paragraphConstructor("11");
        paragraph11.setDeadEnd(true);//тупик
        Paragraph paragraph12 = constructor.paragraphConstructor("12");

        paragraphs[1][1] = paragraph0;

        paragraphs[0][1] = paragraph1;
        paragraphs[0][2] = paragraph2;
        paragraphs[2][4] = paragraph3;
        //paragraphs[3][0] = paragraph3;
        paragraphs[2][3] = paragraph4;
        paragraphs[4][5] = paragraph5;
        paragraphs[4][6] = paragraph6;
        paragraphs[5][7] = paragraph3;
        paragraphs[5][3] = paragraph7;
        paragraphs[6][1] = paragraph1;
        paragraphs[6][3] = paragraph3;
        paragraphs[7][3] = paragraph3;
        paragraphs[7][8] = paragraph8;
        paragraphs[8][10] = paragraph9;
        paragraphs[8][9] = paragraph10;
        paragraphs[10][11] = paragraph11;
        paragraphs[10][12] = paragraph12;
        paragraphs[12][1] = paragraph3;
        paragraphs[12][3] = paragraph1;

        return paragraphs;
    }

}
