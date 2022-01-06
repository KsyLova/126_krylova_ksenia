import java.util.ArrayList;
import java.util.List;

public class Contract {
    private String number;
    private String date;
    private List<PaymentDocument> payments;

    public Contract(String number, String date) {
        this.number = number;
        this.date = date;
        this.payments=new ArrayList<>();
    }

    public List<PaymentDocument> getPayments() {
        return payments;
    }

    public String getNumber() {
        return number;
    }
}