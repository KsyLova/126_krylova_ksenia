public class Task_4 implements Task_4_base {
    @Override
    public int[] subtask_1_arrays(int size, int a0, int d) {
        // сгенерировать и вернуть массив размера size, содержащий элементы
        // арифметической прогрессии с первым членом a0 и разностью d
        int[] arprog = new int[size];
        arprog[0] = a0;
        for (int i = 1; i < size; i++) {
            arprog[i] = arprog[i - 1] + d;
        }

        return arprog;
    }

    @Override
    public int[] subtask_2_arrays(int size) {
        // сгенерировать и вернуть массив размера size, первые два элемента
        // которого равны единице, а каждый следующий - сумме всех предыдущих
        int[] a = new int[size];
        a[0] = 1;
        if (size > 1) {
            a[1] = 1;
            for (int i = 2; i < size; i++) {
                a[i] = a[i - 1] * 2;
            }
        }
        return a;
    }

    @Override
    public int[] subtask_3_arrays(int size) {
        // сгенерировать и вернуть массив размера size, содержащий первые
        // size чисел последовательности фибоначчи.
        // https://ru.wikipedia.org/wiki/Числа_Фибоначчи
        int[] fib = new int[size];
        fib[0] = 0;
        if (size > 1) {
            fib[1] = 1;
            for (int i = 2; i < size; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        }
        return fib;
    }

    @Override
    public int subtask_4_arrays(int[] data) {
        // Для данного массива вычислить максимальный элемент
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }

    @Override
    public int subtask_5_arrays(int[] data, int k) {
        // Для данного массива вычислить максимальный элемент
        // кратный k. Гарантируется, что как минумум один такой элемент
        // в массиве есть
        int max = -900000000;
        for (int i = 1; i < data.length; i++) {
            if ((data[i] > max) && (data[i] % k == 0)) {
                max = data[i];
            }
        }
        return max;
    }

    @Override
    public int[] subtask_6_arrays(int[] arr1, int[] arr2) {
        // Даны два массива arr1, arr2.
        // Произвести слияние данных массивов в один отсортированный
        // по возрастанию массив.

        return null;
    }

    @Override
    public int[] subtask_7_arrays(int[] arr1, int[] arr2) {
        // Даны два отсортированных по возрастанию массива arr1, arr2.
        // Произвести слияние данных массивов в один также отсортированный
        // по возрастанию массив.
        // Используйте алгоритм, время работы которого будет пропорционально сумме
        // размеров arr1 и arr2, а не их произведению

        return null;
    }}