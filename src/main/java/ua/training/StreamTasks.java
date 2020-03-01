package ua.training;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class StreamTasks {

    public static void main(String[] args) {
        // Сделать массив int. Из него получить IntStream. Для него:
        int[] arr = {2, -4, 3, 0, 1, 4, 5, 0};
        System.out.println("Array: " + Arrays.toString(arr));

        // task 1: Найти среднее значение элементов массива (с использованием average и без).
        // with average
        System.out.println("Task 1.1 (using average): " + Arrays.stream(arr).average());

        // without average
        IntSummaryStatistics statistics = Arrays.stream(arr).summaryStatistics();
        System.out.print("Task 1.2 (does not use average): ");
        if (statistics.getCount() != 0) {
            System.out.println((double) statistics.getSum() / statistics.getCount());
        } else {
            System.out.println(0);
        }

        // task 2: Найти минимальный элемент и вернуть значение и индекс (одновременно)
        System.out.println("Task 2 (min): " + Arrays.stream(arr).min().getAsInt() + ", index: " + IntStream.range(0, arr.length)
                .reduce((i, j) -> arr[i] > arr[j] ? j : i)
                .getAsInt());

        // task 3: Посчитать количество элементов равных нулю
        System.out.println("Task 3 (count of elements = 0): " + Arrays.stream(arr).filter((x) -> x == 0).count());

        // task 4: Посчитать количество элементов больше нуля
        System.out.println("Task 4 (count of elements > 0): " + Arrays.stream(arr).filter((x) -> x > 0).count());

        // task 5: Помножить элементы массива на число
        System.out.print("Task 3 (x * 3): " + Arrays.toString(Arrays.stream(arr).map((x) -> x * 3).toArray()));
    }

}
