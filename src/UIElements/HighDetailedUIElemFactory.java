package UIElements;
import javafx.scene.control.Control;

public class HighDetailedUIElemFactory implements IUIElemFactory{
    /* creates a JavaFx control object(UI node) from parsed UI Element Description
    In this case, the created object follows HighDetailed style
 */
    @Override
    public Control create(UIElemDescriptor uiElemDescriptor) throws Exception {
        Control control;
        String uiElemType = uiElemDescriptor.type;
        switch (uiElemType){
            case "Button":
                control = new HighDetailedButton(uiElemDescriptor.text, uiElemDescriptor.xCoordinate, uiElemDescriptor.yCoordinate);
                break;
            case "EditBox":
                control = new HighDetailedEditBox(uiElemDescriptor.text, uiElemDescriptor.xCoordinate, uiElemDescriptor.yCoordinate);
                break;
            case "TextBox":
                control = new HighDetailedTextBox(uiElemDescriptor.text, uiElemDescriptor.xCoordinate, uiElemDescriptor.yCoordinate);
                break;
            default:
                control = null;
                throw new Exception("Wrong argument passed to high detailed ui element factory class");
        }
        return control;
    }

    @Override
    public String toString() {
        return "HighDetailedUIElemFactory";
    }
}
