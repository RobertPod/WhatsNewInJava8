package pluralsight.robert;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class ReductionExample {

    public static void main(String... args) {

        List<Integer> list1 = Arrays.asList(10, 9);
        List<Integer> list2 = Arrays.asList(11, -12);
        List<Integer> list3 = Arrays.asList(3, 5, 7);

        Integer maxOfList1 =
                list1.stream()
                        .reduce(0, Integer::sum);
        System.out.println("maxOfList1 = " + maxOfList1);

        Optional<Integer> maxOfList2 =
                list2.stream()
                        .reduce(Integer::max);
        System.out.println("maxOfList2 = " + maxOfList2);

    }
}
