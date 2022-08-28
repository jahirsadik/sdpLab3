package sample;

import UIElements.UIElemDescriptor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConfigManager {
    List<UIElemDescriptor> config = new ArrayList<>();
    Iterator<UIElemDescriptor> it = config.iterator();

    UIElemDescriptor nextItem(){
        return it.next();
    }

    boolean hasMoreItems(){
        return it.hasNext();
    }

    void loadConfigFile(String fileName){
        //TODO: Load config here
    }
}
