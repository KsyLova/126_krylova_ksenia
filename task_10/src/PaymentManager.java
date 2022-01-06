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
}
