package UIElements;
import javafx.scene.paint.Color;

// Describes methods that must be implemented by a Simplistic UI Element
public interface ISimplisticUIElem {
    public static final Color color = Color.RED;
    void changeColor(String color);
}
