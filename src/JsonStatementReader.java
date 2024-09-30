import java.util.ArrayList;
import java.util.List;
import org.json.*;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;

public class JsonStatementReader implements StatementReader{
    @Override
    public List<BankStatement> readStatements(String filePath) {
        List<BankStatement> statements = new ArrayList<>();
        return statements;
    }
}
