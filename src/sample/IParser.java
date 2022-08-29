package sample;

import java.util.List;

public interface IParser {
    abstract void loadConfig(List<String> configLines);
}
