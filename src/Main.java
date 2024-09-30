public class Main {
    public static void main(String[] args) {
        StatementReaderFactory readerFactory = new StatementReaderFactory();
        StatementAnalyser analyser = new StatementAnalyser(readerFactory);

        analyser.analyseStatement();
    }
}
