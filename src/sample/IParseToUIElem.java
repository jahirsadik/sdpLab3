package sample;

import java.util.List;

import UIElements.UIElemDescriptor;
// Common interface needed for adapting to different file types
public interface IParseToUIElem {
    abstract List<UIElemDescriptor> loadConfig(List<String> configLines);
}
