public class Task_2 implements Task_2_base {
    @Override
    public int subtask_1_while(int num) {
        // Найти максимальное число, являющееся полным квадратом,
        // не превосходящее заданное натуральное num
        int i=0;
        do {
            i++;
            if (num<i*i)return ((i-1)*(i-1));
        }while (i*i<=num);
        return i*i;
    }

    @Override
    public int subtask_2_while(int num) {
        // Последовательность целых чисел p(n) определяется следующим образом:
        // p(0) = 1
        // p(k) = 2 * p(k - 1) + 6, k > 0
        //Найти элемент последовательности с номером num
        int p = 1;
        int k = 1;
        while (k<=num){
            p=2*p+6;
            k++;
        }
        return p;
    }

    @Override
    public boolean subtask_3_while(int num, int base) {
        // Проверить, является ли число num натуральной степенью числа base
        int a = base;
        if ((num == 1) && (base == 1)) return true;
        if (base <= 1) return false;
        while (base < num) {
            base = base * a;
        }
        return (base==num);
    }

    @Override
    public int subtask_4_while(int start, int end) {
        // Вычислить, за какое минимальное число операций
        // вычесть 1
        // поделить на 2
        // число start можно превратить в end. Гарантируется, что start >= end >= 1
        int i=0;
        while (start > end) {
            if (start % 2 == 0 && start / 2 >= end) {
                start /= 2;
            } else {
                start--;
            }
            i++;
        }
        return i;
    }
}
