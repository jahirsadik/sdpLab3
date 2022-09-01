import java.util.ArrayList;
import java.util.List;

public class TextParser028_032 implements IParseToUIElem028_032 {
    /* Reads lines from a file and returns a list of strings which
            represents config lines
     */
    @Override
    public List<UIElemDescriptor028_032> loadConfig(List<String> configLines) {
        ArrayList<UIElemDescriptor028_032> config = new ArrayList<>();
        for (String configLine : configLines) {
            config.add(new UIElemDescriptor028_032(configLine));
        }
        return config;
    }   
}
