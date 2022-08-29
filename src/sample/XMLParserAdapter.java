package sample;

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

import UIElements.UIElemDescriptor;

public class XMLParserAdapter implements IParseToUIElem {

    @Override
    public List<UIElemDescriptor> loadConfig(List<String> configLines) {
        ArrayList<UIElemDescriptor> config = new ArrayList<>();
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
                    config.add(new UIElemDescriptor(stringBuilder.toString()));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return config;
    }
}
