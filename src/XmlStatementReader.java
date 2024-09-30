import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XmlStatementReader implements StatementReader {
    @Override
    public List<BankStatement> readStatements(String filePath) {
        List<BankStatement> statements = new ArrayList<>();
        return statements;
    }
}
