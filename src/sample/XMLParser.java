package sample;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class XMLParser {
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
