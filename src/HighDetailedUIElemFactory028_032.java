import javafx.scene.control.Control;

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
