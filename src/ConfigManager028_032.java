import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ConfigManager028_032 {
    /* ConfigManager028_032 is a Singleton class,
         ref holds the value of currently initiated ConfigManager028_032 reference
     */
    private static ConfigManager028_032 ref = null;
    // List of UI element descriptions parsed from file
    private List<UIElemDescriptor028_032> config = new ArrayList<>();

    private ConfigManager028_032(String fileName) {
        loadConfigFile(fileName);
    }
    // getInstance ensures that the class follows Singleton pattern
    public static synchronized ConfigManager028_032 getInstance(String fileName){
        if(ref == null){
            ref = new ConfigManager028_032(fileName);
        }
        return ref;
    }
    // returns next UI element in array
    public UIElemDescriptor028_032 nextItem(){
        Iterator<UIElemDescriptor028_032> it = config.iterator();
        UIElemDescriptor028_032 elem = it.next();
        it.remove();
        return elem;
    }
    // returns true if array has more items
    public boolean hasMoreItems(){
        Iterator<UIElemDescriptor028_032> it = config.iterator();
        return it.hasNext();
    }
    /*
        Loads from a config file by reading the filename
            If the file is .txt, it simply passes the lines to loadConfig
            If the file is .xml, it reads the xml line inputs, parses them
                    using XMLParserAdapter028_032, then feeds those lines to loadConfig
            Thus, the use of XMLParserAdapter028_032 and interface IParseToUIElem028_032 allows for
                    adapting to new file formats
     */
    private void loadConfigFile(String fileName) {
        // common interface reference is used so that it can parse depending on file type
        IParseToUIElem028_032 parser;
        if (fileName.endsWith(".txt")) {
            try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
                ArrayList<String> configLines = new ArrayList<>();
                stream.forEach(configLines::add);
                parser = new TextParser028_032();
                config.addAll(parser.loadConfig(configLines));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (fileName.endsWith(".xml")) {
            List<String> xmlLines = XMLParser028_032.parseXML(fileName);
            parser = new XMLParserAdapter028_032();
            config.addAll(parser.loadConfig(xmlLines));
        }
    }
}
