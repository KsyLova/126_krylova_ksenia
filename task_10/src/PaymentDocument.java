public class PaymentDocument {
    private int sum;
    private int number;
    private String date;
    private DocumentType type;

    public PaymentDocument(int sum, int number, String date, DocumentType type) {
        this.sum = sum;
        this.number = number;
        this.date = date;
        this.type = type;
    }
}
