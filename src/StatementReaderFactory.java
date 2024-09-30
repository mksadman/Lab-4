import java.util.HashMap;
import java.util.Map;

public class StatementReaderFactory {
    private final Map<String, StatementReader> readers = new HashMap<>();

    public StatementReaderFactory() {
        readers.put("json", new JsonStatementReader());
        readers.put("xml", new XmlStatementReader());
    }

    public StatementReader createReader(String fileType) {
        StatementReader reader = readers.get(fileType.toLowerCase());
        if (reader == null) {
            throw new IllegalArgumentException("Invalid file type: " + fileType);
        }
        return reader;
    }
}
