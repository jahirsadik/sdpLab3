package sample;

import UIElements.UIElemDescriptor;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ConfigManager {
    /* ConfigManager is a Singleton class,
         ref holds the value of currently initiated ConfigManager reference
     */
    private static ConfigManager ref = null;
    // List of UI element descriptions parsed from file
    private List<UIElemDescriptor> config = new ArrayList<>();

    private ConfigManager(String fileName) {
        loadConfigFile(fileName);
    }
    // getInstance ensures that the class follows Singleton pattern
    public static synchronized ConfigManager getInstance(String fileName){
        if(ref == null){
            ref = new ConfigManager(fileName);
        }
        return ref;
    }
    // returns next UI element in array
    public UIElemDescriptor nextItem(){
        Iterator<UIElemDescriptor> it = config.iterator();
        UIElemDescriptor elem = it.next();
        it.remove();
        return elem;
    }
    // returns true if array has more items
    public boolean hasMoreItems(){
        Iterator<UIElemDescriptor> it = config.iterator();
        return it.hasNext();
    }
    /*
        Loads from a config file by reading the filename
            If the file is .txt, it simply passes the lines to loadConfig
            If the file is .xml, it reads the xml line inputs, parses them
                    using XMLParserAdapter, then feeds those lines to loadConfig
            Thus, the use of XMLParserAdapter and interface IParseToUIElem allows for
                    adapting to new file formats
     */
    private void loadConfigFile(String fileName) {
        // common interface reference is used so that it can parse depending on file type
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
