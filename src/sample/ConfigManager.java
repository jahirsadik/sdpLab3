package sample;

import UIElements.UIElemDescriptor;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ConfigManager {
    private static ConfigManager ref = null;

    private List<UIElemDescriptor> config = new ArrayList<>();

    private ConfigManager(String fileName) {
        loadConfigFile(fileName);
    }

    public static synchronized ConfigManager getInstance(String fileName){
        if(ref == null){
            ref = new ConfigManager(fileName);
        }
        return ref;
    }

    public UIElemDescriptor nextItem(){
        Iterator<UIElemDescriptor> it = config.iterator();
        UIElemDescriptor elem = it.next();
        it.remove();
        return elem;
    }

    public boolean hasMoreItems(){
        Iterator<UIElemDescriptor> it = config.iterator();
        return it.hasNext();
    }
    
    private void loadConfigFile(String fileName) {
        IParseToUIElem parser;
        if (fileName.endsWith(".txt")) {
            try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
                ArrayList<String> configLines = new ArrayList<>();
                stream.forEach(configLines::add);
                parser = new TextParser();
                config.addAll(parser.loadConfig(configLines));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (fileName.endsWith(".xml")) {
            List<String> xmlLines = XMLParser.parseXML(fileName);
            parser = new XMLParserAdapter();
            config.addAll(parser.loadConfig(xmlLines));
        }
    }
}
