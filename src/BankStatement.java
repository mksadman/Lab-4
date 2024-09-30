public class BankStatement {
    private int amount;
    private String date;
    private String category;
    public BankStatement(int amount, String date, String category) {
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

    public void analyse() {
        System.out.println("Analyzing Tom's bank statement");
    }
    public int getAmount() {
        return amount;
    }
    public String getDate() {
        return date;
    }
    public String getCategory() {
        return category;
    }
}
