package UIElements;

import javafx.scene.control.Control;

public class SimplisticUIElemFactory implements IUIElemFactory{
    @Override
    public Control create(UIElemDescriptor uiElemDescriptor) throws Exception {
        Control control;
        String uiElemType = uiElemDescriptor.type;
        switch (uiElemType){
            case "Button":
                control = new SimplisticButton(uiElemDescriptor.text, uiElemDescriptor.xCoordinate, uiElemDescriptor.yCoordinate);
                break;
            case "EditBox":
                control = new SimplisticEditBox(uiElemDescriptor.text, uiElemDescriptor.xCoordinate, uiElemDescriptor.yCoordinate);
                break;
            case "TextBox":
                control = new SimplisticTextBox(uiElemDescriptor.text, uiElemDescriptor.xCoordinate, uiElemDescriptor.yCoordinate);
                break;
            default:
                control = null;
                throw new Exception("Wrong argument passed to simplistic ui element factory class");
        }
        return control;
    }
    @Override
    public String toString() {
        return "SimplisticUIElemFactory";
    }
}
