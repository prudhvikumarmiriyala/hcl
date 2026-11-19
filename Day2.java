@FunctionalInterface
interface Welcome {
    void display();
}

@FunctionalInterface
interface GST {
    double calculate(double price);
}

@FunctionalInterface
interface TotalBill {
    double calculate(double price, int quantity);
}

@FunctionalInterface
interface Discount {
    double calculate(double price);
}

@FunctionalInterface
interface FinalAmount {
    double calculate(double price, double discount);
}

public class Day2{
    public static void main(String[] args) {

        Welcome welcome = () -> System.out.println("Welcome to Shopping Application!");

        GST gst = price -> price * 0.18;

        TotalBill bill = (price, quantity) -> price * quantity;

        Discount discount = price -> price * 0.10;

        FinalAmount finalAmount = (price, discountValue) -> {
            double amount = price - discountValue;
            return amount;
        };

        double price = 1000;
        int quantity = 2;

        welcome.display();

        double gstAmount = gst.calculate(price);
        System.out.println("GST (18%): " + gstAmount);

        double totalBill = bill.calculate(price, quantity);
        System.out.println("Total Bill: " + totalBill);

        double discountAmount = discount.calculate(totalBill);
        System.out.println("Discount (10%): " + discountAmount);

        double payable = finalAmount.calculate(totalBill, discountAmount);
        System.out.println("Final Payable Amount: " + payable);
    }
}

/* Expected Output:
                    Welcome to Shopping Application!
                    GST (18%): 180.0
                    Total Bill: 2000.0
                    Discount (10%): 200.0
                    Final Payable Amount: 1800.0
*/