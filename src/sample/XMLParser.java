package sample;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import UIElements.UIElemDescriptor;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;

public class XMLParser {
    public static void parseXML(String filename, ArrayList<UIElemDescriptor> elemsList){
        try {
            File file = new File(filename);
            StringBuilder stringBuilder = new StringBuilder();
            DocumentBuilderFactory dbf
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getDocumentElement().getChildNodes();
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node node = nList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    stringBuilder.append(elem.getNodeName() + ",");
                    stringBuilder.append(elem.getAttribute("value") + ",");
                    stringBuilder.append("X:" + elem.getAttribute("X") + ",");
                    stringBuilder.append("Y:" + elem.getAttribute("Y"));
                    stringBuilder.append('\n');
                    elemsList.add(new UIElemDescriptor(elem.getNodeName(), elem.getAttribute("value"), Double.parseDouble(elem.getAttribute("X")), Double.parseDouble(elem.getAttribute("Y"))));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
