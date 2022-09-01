import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class HighDetailedEditBox028_032 extends TextField implements IHighDetailedUIElem028_032 {
    private Color color;
    private double textSize;
    HighDetailedEditBox028_032(String text, double xCoordinate, double yCoordinate){
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
