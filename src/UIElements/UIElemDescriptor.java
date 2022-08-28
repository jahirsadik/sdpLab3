package UIElements;

public class UIElemDescriptor {
    public String type;
    public String text;
    public double xCoordinate;
    public double yCoordinate;

    public UIElemDescriptor(String type, String text, double xCoordinate, double yCoordinate) {
        this.type = type;
        this.text = text;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
}
