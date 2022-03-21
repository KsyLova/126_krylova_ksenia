public class PaymentDocument {
    private int sum;
    private int number;
    private String date;
    private DocumentType type;

    public PaymentDocument(int sum, int number, String date, DocumentType type) {
        if(sum <= 0){
            throw new RuntimeException("Отрицательная или нулевая сумма плажета недопустами");
        }

        this.sum = sum;
        this.number = number;
        this.date = date;
        this.type = type;
    }

    public int getSum() {
        return sum;
    }

    public int getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public DocumentType getType() {
        return type;
    }
}
