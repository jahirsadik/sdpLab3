package UIElements;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class SimplisticButton extends Button implements ISimplisticUIElem{
    private Color color;
    SimplisticButton(String text, double xCoordinate, double yCoordinate){
        super(text);
        this.setLayoutX(xCoordinate);
        this.setLayoutY(yCoordinate);
    }
    @Override
    public void changeColor(String color) {
        this.color = Color.web(color);
        this.setStyle(String.format("-fx-background-color: #%s;", this.color.toString()));
    }
}
