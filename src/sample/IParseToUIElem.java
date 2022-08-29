package sample;

import java.util.List;

import UIElements.UIElemDescriptor;

public interface IParseToUIElem {
    abstract List<UIElemDescriptor> loadConfig(List<String> configLines);
}
