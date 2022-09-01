import javafx.scene.control.Label;
import javafx.scene.paint.Color;
public class SimplisticTextBox028_032 extends Label implements ISimplisticUIElem028_032 {
    private Color color;
    SimplisticTextBox028_032(String text, double xCoordinate, double yCoordinate){
        super(text);
        this.setLayoutX(xCoordinate);
        this.setLayoutY(yCoordinate);
    }
    @Override
    public void changeColor(String color) {
        this.color = Color.web(color);
        this.setStyle(String.format("-fx-background-color: %s;", this.color.toString()));
    }
}
