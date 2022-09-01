import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class SimplisticButton028_032 extends Button implements ISimplisticUIElem028_032 {
    private Color color;
    SimplisticButton028_032(String text, double xCoordinate, double yCoordinate){
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
