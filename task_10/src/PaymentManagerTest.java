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

    @Test
    public void registerPaymentDocument(){
        PaymentManager paymentManager= new PaymentManager();


        Contract contract= new Contract("1","20201231");
        paymentManager.addContract(contract);

        PaymentDocument paymentDocument=
                new PaymentDocument(200,111,"20200101",DocumentType.PAYMENT_ORDER);
        paymentManager.registerPaymentDocument("1",paymentDocument);

        Assert.assertEquals(1, contract.getPayments().size());
    }
}
