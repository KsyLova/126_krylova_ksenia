import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class PaymentManager {
    private List<Contract> contracts;

    public PaymentManager() {
        contracts = new ArrayList<>();
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void addContract(Contract contract) {
        if(contract == null || contract.getNumber().isBlank()){
            throw new RuntimeException("Контракт не может быть null или иметь пустой номер");
        }

        for(int i=0; i<contracts.size(); i++){
            Contract con = contracts.get(i);
            if(con.getNumber().equals(contract.getNumber())){
                throw new RuntimeException("Контракт с номером " + con.getNumber() + " уже существует");
            }
        }

        contracts.add(contract);
    }
    public void registerPaymentDocument(String contractNumber, PaymentDocument paymentDocument) {
        if(contractNumber == null || paymentDocument == null){
            throw new RuntimeException("Номер контракта или платежный документ не могут быть null");
        }

        Contract currentContract = null;

        for(int i=0; i<contracts.size(); i++){
            Contract contract = contracts.get(i);
            if(contract.getNumber().equals(contractNumber)){
                currentContract = contract;
                List<PaymentDocument> payments = contract.getPayments();
                for(int j=0; j<payments.size(); j++){
                    PaymentDocument payment = payments.get(j);
                    if(payment.getDate().equals(paymentDocument.getDate())
                            && payment.getNumber() == paymentDocument.getNumber()
                            && payment.getType().equals(paymentDocument.getType())){
                        throw new RuntimeException
                                ("Дубликат платежного документа для договора с номером " + contractNumber);
                    }
                }
            }
        }
        if(currentContract == null){
            throw new RuntimeException("Контракта с таким номером не существует");
        }
        currentContract.getPayments().add(paymentDocument);
    }

    public List<PaymentDocument> findPaymentDocumentByContractNumber(String contractNumber) {
        if(contractNumber == null){
            throw new RuntimeException("Номер контракта не может быть null");
        }

        List<PaymentDocument> paymentDocuments = new ArrayList<>();

        for(int i=0; i<contracts.size(); i++){
            Contract contract = contracts.get(i);
            if(contract.getNumber() .equals(contractNumber)){
                paymentDocuments.addAll(contract.getPayments());
            }
        }

        return paymentDocuments;
    }

    public int sumPaymentDocumentByContractNumber(String contractNumber) {
        if(contractNumber == null){
            throw new RuntimeException("Номер контракта не может быть null");
        }

        List<PaymentDocument> paymentDocuments = findPaymentDocumentByContractNumber(contractNumber);

        int sum = 0;
        for(int i=0; i<paymentDocuments.size(); i++){
            sum = sum + paymentDocuments.get(i).getSum();
        }

        return sum;
    }

    public void deletePaymentDocumentsByNumberAndContractAndDate
            (int paymentDocumentNumber, String contractNumber, String date) {
        if(contractNumber == null || date == null){
            throw new RuntimeException("Номер контракта или дата не могут быть null");
        }

        int deletedCount = 0;
        List<PaymentDocument> paymentDocuments = findPaymentDocumentByContractNumber(contractNumber);
        for (int i = 0; i < paymentDocuments.size(); i++) {
            PaymentDocument paymentDocument = paymentDocuments.get(i);
            if (paymentDocument.getNumber() == paymentDocumentNumber && paymentDocument.getDate().equals(date)) {
                Contract contract=getContractByNumber(contractNumber);
                contract.getPayments().remove(i);
                deletedCount++;
            }
        }
        if (deletedCount==0){
            throw new RuntimeException("Не найдено ни одного платежа");
        }
    }

    public Map<Contract, Integer> calculateContractTotalPaymentsDocumentsCost(){
        Map<Contract, Integer> map = new HashMap<>();

        for(int i=0; i<contracts.size(); i++){
            int sum = 0;
            List<PaymentDocument> payments = contracts.get(i).getPayments();
            for(int j=0; j<payments.size(); j++){
                PaymentDocument paymentDocument = payments.get(j);
                sum = sum + paymentDocument.getSum();
            }
            map.put(contracts.get(i), sum);
        }
        return map;
    }
    public List<PaymentDocument> findAllPaymentDocuments(){
        List<PaymentDocument> allPaymentDocuments = new ArrayList<>();

        for(int i=0; i<contracts.size(); i++){
            List<PaymentDocument> payments = contracts.get(i).getPayments();

            allPaymentDocuments.addAll(payments);
        }
        return allPaymentDocuments;
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

