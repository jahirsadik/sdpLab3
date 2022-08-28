package UIElements;

public class UIElemDescriptor {
    public String type;
    public String text;
    public double xCoordinate;
    public double yCoordinate;

    @Override
    public String toString() {
        return "UIElemDescriptor{" +
                "type='" + type + '\'' +
                ", text='" + text + '\'' +
                ", xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                '}';
    }

    public UIElemDescriptor(String type, String text, double xCoordinate, double yCoordinate) {
        this.type = type;
        this.text = text;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
}
