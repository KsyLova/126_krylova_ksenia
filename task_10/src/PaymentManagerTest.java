import org.junit.Assert;
import org.junit.Test;
import java.util.Map;

public class PaymentManagerTest {
    @Test
    public void addManager_success(){
        PaymentManager paymentManager= new PaymentManager();

        Contract contract=new Contract("1","20201231");
        paymentManager.addContract(contract);

        Assert.assertEquals(1,paymentManager.getContracts().size());
    }

    @Test(expected = RuntimeException.class)
    public void addManager_fail_duplicateContractNumber(){
        PaymentManager paymentManager = new PaymentManager();

        Contract contract1 = new Contract("1", "20201231");
        paymentManager.addContract(contract1);

        Contract contract2 = new Contract("1", "20201231");
        paymentManager.addContract(contract2);
    }


    @Test(expected = RuntimeException.class)
    public void addManager_fail_blankContractNumber(){
        PaymentManager paymentManager = new PaymentManager();

        Contract contract1 = new Contract("", "20201231");

        paymentManager.addContract(contract1);
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

    @Test
    public void findPaymentDocumentByContractNumber(){
        PaymentManager paymentManager = new PaymentManager();

        Contract contract = new Contract("1", "20201231");
        paymentManager.addContract(contract);

        paymentManager.registerPaymentDocument("1",
                new PaymentDocument(200, 111, "20220101", DocumentType.PAYMENT_ORDER));

        paymentManager.registerPaymentDocument("1",
                new PaymentDocument(300, 222, "20220101", DocumentType.PAYMENT_ORDER));

        paymentManager.registerPaymentDocument("1",
                new PaymentDocument(400, 333, "20220101", DocumentType.PAYMENT_ORDER));

        Assert.assertEquals(3, paymentManager.findPaymentDocumentByContractNumber("1").size());
    }

    @Test
    public void sumPaymentDocumentByContractNumber(){
        PaymentManager paymentManager = new PaymentManager();

        Contract contract = new Contract("1", "20201231");
        paymentManager.addContract(contract);

        paymentManager.registerPaymentDocument("1",
                new PaymentDocument(200, 111, "20220101", DocumentType.PAYMENT_ORDER));

        paymentManager.registerPaymentDocument("1",
                new PaymentDocument(300, 222, "20220101", DocumentType.PAYMENT_ORDER));

        paymentManager.registerPaymentDocument("1",
                new PaymentDocument(400, 333, "20220101", DocumentType.PAYMENT_ORDER));

        Assert.assertEquals(900, paymentManager.sumPaymentDocumentByContractNumber("1"));
    }

    @Test
    public void deletePaymentDocumentsByNumberAndContractAndDate_success(){
        PaymentManager paymentManager = new PaymentManager();

        Contract contract = new Contract("1", "20201231");
        paymentManager.addContract(contract);

        paymentManager.registerPaymentDocument("1",
                new PaymentDocument(200, 111, "20220101", DocumentType.PAYMENT_ORDER));

        paymentManager.registerPaymentDocument("1",
                new PaymentDocument(300, 222, "20220101", DocumentType.PAYMENT_ORDER));


        paymentManager.deletePaymentDocumentsByNumberAndContractAndDate
                (111, "1", "20220101");

        Assert.assertEquals(1, contract.getPayments().size());
    }

    @Test(expected = RuntimeException.class)
    public void deletePaymentDocuments_fail_zeroPaymentDocumentsFound(){
        PaymentManager paymentManager = new PaymentManager();

        Contract contract = new Contract("1", "20201231");
        paymentManager.addContract(contract);

        paymentManager.registerPaymentDocument("1",
                new PaymentDocument(200, 111, "20220101", DocumentType.PAYMENT_ORDER));

        paymentManager.registerPaymentDocument("1",
                new PaymentDocument(300, 222, "20220101", DocumentType.PAYMENT_ORDER));

        paymentManager.deletePaymentDocumentsByNumberAndContractAndDate
                (111, "2", "20220101");
    }

    @Test
    public void sumAllPaymentDocuments(){
        PaymentManager paymentManager = new PaymentManager();

        Contract contract1 = new Contract("1", "20201231");
        paymentManager.addContract(contract1);

        Contract contract2 = new Contract("2", "20201231");
        paymentManager.addContract(contract2);

        paymentManager.registerPaymentDocument("1",
                new PaymentDocument(200, 111, "20220101", DocumentType.PAYMENT_ORDER));

        paymentManager.registerPaymentDocument("1",
                new PaymentDocument(300, 222, "20220101", DocumentType.PAYMENT_ORDER));

        paymentManager.registerPaymentDocument("2",
                new PaymentDocument(100, 111, "20220101", DocumentType.PAYMENT_ORDER));

        paymentManager.registerPaymentDocument("2",
                new PaymentDocument(500, 222, "20220101", DocumentType.PAYMENT_ORDER));

        Map<Contract, Integer> contractTotalSums = paymentManager.calculateContractTotalPaymentsDocumentsCost();

        int totalFirstContractSum = contractTotalSums.get(contract1);
        int totalSecondContractSum = contractTotalSums.get(contract2);

        Assert.assertEquals(500, totalFirstContractSum);
        Assert.assertEquals(600, totalSecondContractSum);
    }
    @Test
    public void findAllPaymentDocuments(){
        PaymentManager paymentManager = new PaymentManager();

        Contract contract1 = new Contract("1", "20201231");
        paymentManager.addContract(contract1);

        Contract contract2 = new Contract("2", "20201231");
        paymentManager.addContract(contract2);

        paymentManager.registerPaymentDocument("1",
                new PaymentDocument(200, 111, "20220101", DocumentType.PAYMENT_ORDER));

        paymentManager.registerPaymentDocument("1",
                new PaymentDocument(300, 222, "20220101", DocumentType.PAYMENT_ORDER));

        paymentManager.registerPaymentDocument("2",
                new PaymentDocument(100, 333, "20220101", DocumentType.PAYMENT_ORDER));

        paymentManager.registerPaymentDocument("2",
                new PaymentDocument(500, 444, "20220101", DocumentType.PAYMENT_ORDER));

        Assert.assertEquals(4, paymentManager.findAllPaymentDocuments().size());
    }
}
