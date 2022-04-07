import org.junit.Assert;
import org.junit.*;

public class Task2_Tests extends Assert{
    class TestComparator implements MyComparator<Integer> {
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    }

    @Test
    public void BubbleSort_BubbleSortAlreadySortedArray_ArrayNotChange(){
        BubbleSort<Integer> bs = new BubbleSort<>();
        Integer[] data = {1, 2, 3};
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void BubbleSort_BubbleSortUnsortedArray_ArrayIsCorrect(){
        BubbleSort<Integer> bs = new BubbleSort<>();
        Integer[] data = {1, 3, 2};
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void BubbleSort_BubbleSortSameElements_ArrayIsCorrect(){
        BubbleSort<Integer> bs = new BubbleSort<>();
        Integer[] data = {1, 1, 1};
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 1, 1}, data);
    }

    @Test
    public void BubbleSort_BubbleSortNegativeDigitsWithPositive_ArrayIsCorrect(){
        BubbleSort<Integer> bs = new BubbleSort<>();
        Integer[] data = {1, 0, -1};
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{-1, 0, 1}, data);
    }

    @Test
    public void InsertionSort_InsertionSortAlreadySortedArray_ArrayIsCorrect(){
        InsertionSort<Integer> is = new InsertionSort<>();
        Integer[] data = {1, 2, 3};
        is.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void InsertionSort_InsertionSortArray_ArrayIsCorrect(){
        InsertionSort<Integer> is = new InsertionSort<>();
        Integer[] data = {1, 3, 2};
        is.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void InsertionSort_InsertionSortSameElements_ArrayIsCorrect(){
        InsertionSort<Integer> is = new InsertionSort<>();
        Integer[] data = {1, 1, 1};
        is.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 1, 1}, data);
    }

    @Test
    public void InsertionSort_InsertionSortNegativeDigitsWithPositive_ArrayIsCorrect(){
        InsertionSort<Integer> is = new InsertionSort<>();
        Integer[] data = {1, 0, -1};
        is.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{-1, 0, 1}, data);
    }

    @Test
    public void SelectionSort_SelectionSortAlreadySortedArray_ArrayIsCorrect(){
        SelectionSort<Integer> ss = new SelectionSort<>();
        Integer[] data = {1, 2, 3};
        ss.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void SelectionSort_SelectionSortArray_ArrayIsCorrect(){
        SelectionSort<Integer> ss = new SelectionSort<>();
        Integer[] data = {1, 3, 2};
        ss.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void SelectionSort_SelectionSortSameElements_ArrayIsCorrect(){
        SelectionSort<Integer> ss = new SelectionSort<>();
        Integer[] data = {1, 1, 1};
        ss.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 1, 1}, data);
    }

    @Test
    public void SelectionSort_SelectionSortNegativeDigitsWithNormal_DataIsCorrect(){
        SelectionSort<Integer> ss = new SelectionSort<>();
        Integer[] data = {1, 0, -1};
        ss.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{-1, 0, 1}, data);
    }
}