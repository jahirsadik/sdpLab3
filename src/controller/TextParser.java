package controller;

import java.util.ArrayList;
import java.util.List;

import UIElements.UIElemDescriptor;
public class TextParser implements IParseToUIElem {
    /* Reads lines from a file and returns a list of strings which
            represents config lines
     */
    @Override
    public List<UIElemDescriptor> loadConfig(List<String> configLines) {
        ArrayList<UIElemDescriptor> config = new ArrayList<>();
        for (String configLine : configLines) {
            config.add(new UIElemDescriptor(configLine));
        }
        return config;
    }   
}
