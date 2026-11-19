//Employee Attendance Management – Java Code

import java.util.*;
import java.util.function.*;

public class Day1{
    public static void main(String[] args) {

        List<Integer> attendance = Arrays.asList(95, 45, 80, 30, 100);

        Predicate<Integer> eligible = a -> a >= 75;

        Consumer<Integer> print = a ->
            System.out.println("Eligible Attendance: " + a + "%");

        attendance.forEach(a -> {
            if (eligible.test(a)) {
                print.accept(a);
            }
        });
    }
}

/*Expected Output:
Eligible Attendance: 95%
Eligible Attendance: 80%
Eligible Attendance: 100% */
