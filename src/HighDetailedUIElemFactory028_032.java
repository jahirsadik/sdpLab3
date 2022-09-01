import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class HighDetailedUIElemFactory028_032 implements IUIElemFactory028_032 {
    /* creates a JavaFx control object(UI node) from parsed UI Element Description
    In this case, the created object follows HighDetailed style
 */
    @Override
    public Control create(UIElemDescriptor028_032 uiElemDescriptor) throws Exception {
        Control control;
        String uiElemType = uiElemDescriptor.type;
        switch (uiElemType){
            case "Button":
                control = new HighDetailedButton028_032(uiElemDescriptor.text, uiElemDescriptor.xCoordinate, uiElemDescriptor.yCoordinate);
                break;
            case "EditBox":
                control = new HighDetailedEditBox028_032(uiElemDescriptor.text, uiElemDescriptor.xCoordinate, uiElemDescriptor.yCoordinate);
                break;
            case "TextBox":
                control = new HighDetailedTextBox028_032(uiElemDescriptor.text, uiElemDescriptor.xCoordinate, uiElemDescriptor.yCoordinate);
                break;
            default:
                control = null;
                throw new Exception("Wrong argument passed to high detailed ui element factory class");
        }
        return control;
    }

    @Override
    public String toString() {
        return "HighDetailedUIElemFactory028_032";
    }
}

class HighDetailedButton028_032 extends Button implements IHighDetailedUIElem028_032 {
    private Color color;
    private double textSize;

    HighDetailedButton028_032(String text, double xCoordinate, double yCoordinate){
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

class HighDetailedTextBox028_032 extends Label implements IHighDetailedUIElem028_032 {
    private Color color;
    private double textSize;

    HighDetailedTextBox028_032(String text, double xCoordinate, double yCoordinate){
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

class HighDetailedEditBox028_032 extends TextField implements IHighDetailedUIElem028_032 {
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
