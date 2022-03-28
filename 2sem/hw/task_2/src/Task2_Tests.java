import org.junit.*;
import org.junit.Assert;

public class Task2_Tests extends Assert {
    class TestComparator implements MyComparator<Integer> {
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    }

    private boolean isSorted(Integer[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] > data[i + 1])
                return false;
        }
        return true;
    }

    @Test
    public void bubbleSort_ArrayWithSimilarElements_ArrayNotChange() {
        Integer[] data = {1, 1, 1};
        BubbleSort<Integer> bs = new BubbleSort<>();
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 1, 1}, data);
    }

    @Test
    public void bubbleSort_SortedArray_ArrayNotChange(){
        BubbleSort<Integer> bs = new BubbleSort<>();
        Integer[] data={1,2,3};
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3}, data);
    }

    @Test
    public void bubbleSort_PushUnsortedArray_ElementsSortedCorrect(){
        BubbleSort<Integer> bs = new BubbleSort<>();
        Integer[] data={1,4,3,2};
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3,4}, data);
    }

    @Test
    public void bubbleSort_InvertedArray_ElementsSortedCorrect(){
        BubbleSort<Integer> bs = new BubbleSort<>();
        Integer[] data={4,3,2,1};
        bs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3,4}, data);
    }




    @Test
    public void selectionSort_unSortedArray_ElementsSortedCorrect(){
        SelectionSort<Integer> ss = new SelectionSort<>();
        Integer[] data={5,4,2};
        ss.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{2,4,5}, data);
    }
    @Test
    public void selectionSort_UnsortedArrayWithTwoElements_ElementsSortedCorrect(){
        SelectionSort<Integer> ss = new SelectionSort<>();
        Integer[] data={2,1};
        ss.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1,2}, data);
    }
    @Test
    public void selectionSort_UnsortedArray_ElementsSortedCorrect(){
        SelectionSort<Integer> ss = new SelectionSort<>();
        Integer[] data={4,1,3,2};
        ss.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3,4}, data);
    }



    @Test
    public void insertionSort_SortedArray_ArrayNotChange(){
        InsertionSort<Integer> is = new InsertionSort<>();
        Integer[] data={1,2};
        is.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1,2}, data);
    }
    @Test
    public void insertionSort_unSortedArray_ElementsSortedCorrect(){
        InsertionSort<Integer> is = new InsertionSort<>();
        Integer[] data={2,1};
        is.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1,2}, data);
    }
}
