package UIElements;

import javafx.scene.paint.Color;

// Describes methods that must be implemented by a High-Detailed UI Element
public interface IHighDetailedUIElem {
    public static final Color color = Color.BLUE;
    void changeColor(String color);
    void changeTextSize(Double size);
}
