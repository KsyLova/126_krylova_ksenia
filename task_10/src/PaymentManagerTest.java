import org.junit.Assert;
import org.junit.Test;

public class PaymentManagerTest {
    @Test
    public void addManager(){
        PaymentManager paymentManager= new PaymentManager();

        Contract contract=new Contract("1","20201231");
        paymentManager.addContract(contract);

        Assert.assertEquals(1,paymentManager.getContracts().size());
    }

}
