import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/*
    This class (along with the interface) has been used to implement adapter pattern.
    The system already had .txt config-line parsing capabilities and
        now we've defined a common interface and an adapter that can adapter
        new .xml file types
 */
public class XMLParserAdapter028_032 implements IParseToUIElem028_032 {
    // Like TextParser028_032, it reads each config line and after adapting to the
    //      xml syntax, it creates UIElementDescriptions from those lines
    @Override
    public List<UIElemDescriptor028_032> loadConfig(List<String> configLines) {
        ArrayList<UIElemDescriptor028_032> config = new ArrayList<>();
        try {
            String xmlBody = String.join("", configLines);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(xmlBody));
            Document doc = db.parse(is);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getDocumentElement().getChildNodes();
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node node = nList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(elem.getNodeName() + ",");
                    stringBuilder.append(elem.getAttribute("value") + ",");
                    stringBuilder.append("X:" + elem.getAttribute("X") + ",");
                    stringBuilder.append("Y:" + elem.getAttribute("Y"));
                    config.add(new UIElemDescriptor028_032(stringBuilder.toString()));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return config;
    }
}
