import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class SimplisticEditBox028_032 extends TextField implements ISimplisticUIElem028_032 {
    private Color color;
    SimplisticEditBox028_032(String text, double xCoordinate, double yCoordinate){
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
