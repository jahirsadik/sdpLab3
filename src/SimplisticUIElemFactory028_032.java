import javafx.scene.control.Control;

public class SimplisticUIElemFactory028_032 implements IUIElemFactory028_032 {
    /* creates a JavaFx control object(UI node) from parsed UI Element Description
        In this case, the created object follows simplistic style
     */
    @Override
    public Control create(UIElemDescriptor028_032 uiElemDescriptor) throws Exception {
        Control control;
        String uiElemType = uiElemDescriptor.type;
        switch (uiElemType){
            case "Button":
                control = new SimplisticButton028_032(uiElemDescriptor.text, uiElemDescriptor.xCoordinate, uiElemDescriptor.yCoordinate);
                break;
            case "EditBox":
                control = new SimplisticEditBox028_032(uiElemDescriptor.text, uiElemDescriptor.xCoordinate, uiElemDescriptor.yCoordinate);
                break;
            case "TextBox":
                control = new SimplisticTextBox028_032(uiElemDescriptor.text, uiElemDescriptor.xCoordinate, uiElemDescriptor.yCoordinate);
                break;
            default:
                control = null;
                throw new Exception("Wrong argument passed to simplistic ui element factory class");
        }
        return control;
    }
    @Override
    public String toString() {
        return "SimplisticUIElemFactory028_032";
    }
}
