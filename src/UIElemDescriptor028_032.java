import javafx.scene.paint.Color;

public class UIElemDescriptor028_032 {
    public String type;
    public String text;
    public double xCoordinate;
    public double yCoordinate;

    @Override
    public String toString() {
        return "UIElemDescriptor028_032{" +
                "type='" + type + '\'' +
                ", text='" + text + '\'' +
                ", xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                '}';
    }

    public UIElemDescriptor028_032(String type, String text, double xCoordinate, double yCoordinate) {
        this.type = type;
        this.text = text;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
    /*
     method to parse out info about UIElements from a config line,
        like the ones given in problem statement
     */
    public UIElemDescriptor028_032(String configLine) {
        String[] config = configLine.split(",");
        this.type = config[0];
        this.text = config[1];
        this.xCoordinate = Double.parseDouble(config[2].split(":")[1]);
        this.yCoordinate = Double.parseDouble(config[3].split(":")[1]);
    }
}
