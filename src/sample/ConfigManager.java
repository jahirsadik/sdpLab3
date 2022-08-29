package sample;

import UIElements.UIElemDescriptor;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ConfigManager implements IParser {
    List<UIElemDescriptor> config = new ArrayList<>();
    Iterator<UIElemDescriptor> it = config.iterator();

    UIElemDescriptor nextItem(){
        return it.next();
    }

    boolean hasMoreItems(){
        return it.hasNext();
    }
    
    void loadConfigFile(String fileName) {
        if (fileName.endsWith(".txt")) {
            ArrayList<String> configLines = new ArrayList<>();
            try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
                stream.forEach(configLines::add);
                loadConfig(configLines);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (fileName.endsWith(".xml")) {
            
        }
    }

    @Override
    public void loadConfig(List<String> configLines) {
        for (String line : configLines) {
            config.add(new UIElemDescriptor(line));
        }
    }
}
