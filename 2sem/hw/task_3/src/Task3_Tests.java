import org.junit.Assert;
import org.junit.*;

public class Task3_Tests extends Assert{
    class TestComparator implements MyComparator<Integer>{
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    }
    @Test
    public void quickSort_sortUnsortedArray_ElementsSortedCorrect(){
        Integer[] arr = new Integer[]{3,1};
        QuickSort<Integer> qs = new QuickSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1, 3}, arr);
    }
    @Test
    public void quickSort_unSortedArrayWithTwoSameElements_ElementsSortedCorrect(){
        Integer[] arr = new Integer[]{1,3,1,2};
        QuickSort<Integer> qs = new QuickSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,1,2, 3}, arr);
    }
    @Test
    public void quickSort_UnsortedArray_ElementsSortedCorrect(){
        Integer[] arr = new Integer[]{1,6,0,3,6};
        QuickSort<Integer> qs = new QuickSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{0,1,3,6,6}, arr);
    }




    @Test
    public void mergeSort_sortUnsortedArray_ElementsSortedCorrect(){
        Integer[] arr = new Integer[]{2,1};
        MergeSort<Integer> qs = new MergeSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2}, arr);
    }
    @Test
    public void mergeSort_InvertedArray_ElementsSortedCorrect(){
        Integer[] arr = new Integer[]{3,2,1};
        MergeSort<Integer> qs = new MergeSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,2, 3}, arr);
    }
    @Test
    public void mergeSort_SortedArray_ArrayNotChange(){
        Integer[] arr = new Integer[]{1,2,3};
        MergeSort<Integer> qs = new MergeSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,2,3}, arr);
    }
    @Test
    public void mergeSort_UnsortedArrayWithTwoSameElements_ElementsSortedCorrect(){
        Integer[] arr = new Integer[]{1,3,2,1};
        MergeSort<Integer> qs = new MergeSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,1,2,3}, arr);
    }
    @Test
    public void mergeSort_UnsortedArrayWithFourSameElements_ElementsSortedCorrect(){
        Integer[] arr = new Integer[]{1,5,1,5,3,2};
        MergeSort<Integer> qs = new MergeSort();
        qs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,1,2,3,5,5}, arr);
    }




    @Test
    public void heapSort_sortUnsortedArray_ElementsSortedCorrect(){
        Integer[] arr = new Integer[]{2,1};
        HeapSort<Integer> hs = new HeapSort();
        hs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2}, arr);
    }
    @Test
    public void heapSort_sortedArray_ArrayNotChange(){
        Integer[] arr = new Integer[]{1,2};
        HeapSort<Integer> hs = new HeapSort();
        hs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2}, arr);
    }
    @Test
    public void heapSort_unsortedArray1_ElementsSortedCorrect(){
        Integer[] arr = new Integer[]{3,0,4};
        HeapSort<Integer> hs = new HeapSort();
        hs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{0,3,4}, arr);
    }
    @Test
    public void heapSort_unsortedArray2_ElementsSortedCorrect(){
        Integer[] arr = new Integer[]{3,0,2,0,0,2};
        HeapSort<Integer> hs = new HeapSort();
        hs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{0,0,0,2,2,3}, arr);
    }
    @Test
    public void heapSort_unsortedArray3_ElementsSortedCorrect(){
        Integer[] arr = new Integer[]{5,1,2,3,1,5,5,2};
        HeapSort<Integer> hs = new HeapSort();
        hs.sort(arr, new TestComparator());
        assertArrayEquals(new Integer[]{1,1,2,2,3,5,5,5}, arr);
    }
}