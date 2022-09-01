import javafx.scene.control.Control;

/* Abstract Factory method that requires that the classes
 that implement it, also implements the create() method
 needed for creation of different style of UI elements
 */
public interface IUIElemFactory028_032 {
    public abstract Control create(UIElemDescriptor028_032 uiElemDescriptor) throws Exception;
}
