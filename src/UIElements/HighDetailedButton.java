package UIElements;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class HighDetailedButton extends Button implements IHighDetailedUIElem{
    private Color color;
    private double textSize;

    HighDetailedButton(String text, double xCoordinate, double yCoordinate){
        super(text);
        this.setLayoutX(xCoordinate);
        this.setLayoutY(yCoordinate);
    }

    @Override
    public void changeColor(String color) {
        this.color = Color.web(color);
        this.setStyle(String.format("-fx-background-color: %s;", this.color.toString()));
    }

    @Override
    public void changeTextSize(Double size) {
        this.textSize = size;
        this.setStyle(String.format("-fx-font-size: %.2fpt;", this.textSize));
    }
}
