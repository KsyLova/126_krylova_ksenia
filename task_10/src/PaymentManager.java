import java.util.ArrayList;
import java.util.List;

public class PaymentManager {
    private List<Contract> contracts;

    public PaymentManager() {
        contracts = new ArrayList<>();
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void addContract(Contract contract) {
        contracts.add(contract);
    }

    public void registerPaymentDocument(String contractNumber, PaymentDocument paymentDocument) {
        for (int i = 0; i < contracts.size(); i++) {
            Contract contract = contracts.get(i);
            if (contract.getNumber().equals(contractNumber)) {
                contract.getPayments().add(paymentDocument);
            }
        }
    }

    public List<PaymentDocument> findPaymentDocumentByContractNumber(String contractNumber) {
        List<PaymentDocument> paymentDocuments = new ArrayList<>();

        for (int i = 0; i < contracts.size(); i++) {
            Contract contract = contracts.get(i);
            if (contract.getNumber().equals(contractNumber)) {
                paymentDocuments.addAll(contract.getPayments());
            }
        }
        return paymentDocuments;
    }

    public int sumPaymentDocumentByContractNumber(String contractNumber) {
        List<PaymentDocument> paymentDocuments = findPaymentDocumentByContractNumber(contractNumber);


        int sum = 0;
        for (int i = 0; i < paymentDocuments.size(); i++) {
            sum = sum + paymentDocuments.get(i).getSum();
        }
        return sum;
    }

    public void deletePaymentDocumentsByNumberAndContractAndDate
            (int paymentDocumentNumber, String contractNumber, String date) {

        List<PaymentDocument> paymentDocuments = findPaymentDocumentByContractNumber(contractNumber);
        for (int i = 0; i < paymentDocuments.size(); i++) {
            PaymentDocument paymentDocument = paymentDocuments.get(i);
            if (paymentDocument.getNumber() == paymentDocumentNumber && paymentDocument.getDate().equals(date)) {
                Contract contract=getContractByNumber(contractNumber);
                contract.getPayments().remove(i);
            }
        }
    }

    public int sumAllPaymentDocumentsCost(){
        int sum=0;
        for (int i=0; i<contracts.size();i++){
            List<PaymentDocument> payments=contracts.get(i).getPayments();
            for (int j=0;j<payments.size();j++){
                PaymentDocument paymentDocument=payments.get(j);
                sum=sum+paymentDocument.getSum();
            }
        }
        return sum;
    }

    private Contract getContractByNumber(String number) {
        for (int i = 0; i < contracts.size(); i++) {
            Contract contract = contracts.get(i);
            if (contract.getNumber().equals(number)) {
                return contract;
            }
        }
        return null;
    }
}

