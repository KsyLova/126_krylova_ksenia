import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PaymentManager manager = new PaymentManager();
        Scanner scanner = new Scanner(System.in);
        while (true){
            print();
            String input = scanner.nextLine();

            if(input.equals("10")){
                break;
            }

            switch (input){
                case "1" -> {
                    System.out.println("Введите номер и дату договора:");
                    String number = scanner.next();
                    String date = scanner.nextLine();
                    manager.addContract(new Contract(number, date));
                }

                default -> System.out.println("Некорректный ввод. Попробуйте еще раз");
            }
        }
    }

    private static void print(){
        System.out.println(
                """
                        Введите пункт меню:
                        1. addContract
                        2. registerPaymentDocument
                        3. findPaymentDocumentsByContractNumber
                        4. getSumOfPaymentsFromContract
                        5. deletePayment
                        6. getAllContractsWithPayments
                        7. getAllPayments
                        8. Закончить работу
                        """
        );
    }
}
