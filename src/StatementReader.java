import java.util.List;

public interface StatementReader {
    List<BankStatement> readStatements(String filePath);
}
