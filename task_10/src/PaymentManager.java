import java.util.ArrayList;
import java.util.List;

public class PaymentManager {
    private List<Contract> contracts;

    public PaymentManager(){
        contracts=new ArrayList<>();
    }

    public List<Contract> getContracts(){
        return contracts;
    }

    public void addContract(Contract contract){
        contracts.add(contract);
    }

    public void registerPaymentDocument(String contractNumber, PaymentDocument paymentDocument) {
        for(int i=0; i<contracts.size(); i++){
            Contract contract = contracts.get(i);
            if(contract.getNumber().equals(contractNumber)){
                contract.getPayments().add(paymentDocument);
            }
        }
    }
}
