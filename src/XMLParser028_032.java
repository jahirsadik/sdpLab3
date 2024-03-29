import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class XMLParser028_032 {
    // reads each line from a .xml file and returns an array of string xml lines
    public static List<String> parseXML(String fileName) {
        ArrayList<String> xmlLines = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(xmlLines::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlLines;
    }
}
