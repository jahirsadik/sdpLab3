package sample;

import UIElements.UIElemDescriptor;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ConfigManager {
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
            try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
                ArrayList<String> configLines = new ArrayList<>();
                stream.forEach(configLines::add);
                config.addAll(new TextParser().loadConfig(configLines));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (fileName.endsWith(".xml")) {
            
        }
    }
}
