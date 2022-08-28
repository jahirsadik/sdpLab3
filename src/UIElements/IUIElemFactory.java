package UIElements;
import javafx.scene.control.Control;

public interface IUIElemFactory {
    public abstract Control create(String uiElemType);
}
