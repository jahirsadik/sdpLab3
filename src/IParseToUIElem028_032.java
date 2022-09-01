import java.util.List;

// Common interface needed for adapting to different file types
public interface IParseToUIElem028_032 {
    abstract List<UIElemDescriptor028_032> loadConfig(List<String> configLines);
}
