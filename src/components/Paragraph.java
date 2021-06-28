package components;

public class Paragraph{
    private String text;
    private String num;
    private boolean deadEnd = false;

    public Paragraph() {}

    public String getText() {
        return text;
    }

    public String getNum() {
        return num;
    }

    public boolean isDeadEnd() {
        return deadEnd;
    }

    public void setDeadEnd(boolean deadEnd) {
        this.deadEnd = deadEnd;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Paragraph{" +
                "num='" + num + '\'' +
                '}';
    }
}