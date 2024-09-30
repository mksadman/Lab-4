import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class StatementAnalyser {
    private StatementReaderFactory factory;

    public StatementAnalyser(StatementReaderFactory factory) {
        this.factory = factory;
    }

    public void analyseStatement() {
        String fileType = "json";
        String filePath = "src/resources/transactions.json";

        StatementReader reader = factory.createReader(fileType);
        List<BankStatement> statements = reader.readStatements(filePath);

        int totalAmount = calculateTotalAmount(statements);
        System.out.println("The total for all transactions is " + totalAmount);
        System.out.println(totalAmount > 0 ? "Profit" : "Loss");

        int month = 5;
        int count = countTransactionsInMonth(statements, month);
        System.out.println("Number of transactions in month " + month + ": " + count);

        List<BankStatement> topExpenses = getTopExpenses(statements, 10);
        System.out.println("Top 10 expenses:");
        for (BankStatement statement : topExpenses) {
            System.out.println("Date: " + statement.getDate() + ", Amount: " + statement.getAmount());
        }

        String maxCategory = getMaxCategory(statements);
        System.out.println("Category with maximum total amount: " + maxCategory);
    }

    private int calculateTotalAmount(List<BankStatement> statements) {
        int total = 0;
        for (BankStatement statement : statements) {
            total += statement.getAmount();
        }
        return total;
    }

    private int countTransactionsInMonth(List<BankStatement> statements, int month) {
        int count = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (BankStatement statement : statements) {
            LocalDate date = LocalDate.parse(statement.getDate(), formatter);
            if (date.getMonthValue() == month) {
                count++;
            }
        }
        return count;
    }

    private List<BankStatement> getTopExpenses(List<BankStatement> statements, int n) {
        return statements.stream()
                .sorted(Comparator.comparing(BankStatement::getAmount).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    private String getMaxCategory(List<BankStatement> statements) {
        Map<String, Integer> totalAmountByCategory = statements.stream()
                .collect(Collectors.groupingBy(BankStatement::getCategory, Collectors.summingInt(BankStatement::getAmount)));

        return totalAmountByCategory.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}
