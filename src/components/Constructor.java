package components;

import java.util.Properties;

public class Constructor {
    private Properties properties = new Properties();

    public Constructor() {
    }
    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Paragraph paragraphConstructor(String paragraphNum){
        Paragraph paragraph = new Paragraph();
        paragraph.setText(properties.getProperty(paragraphNum));
        paragraph.setNum(paragraphNum);
        return paragraph;
    }

}
