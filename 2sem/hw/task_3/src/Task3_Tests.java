import org.junit.Assert;
import org.junit.*;

public class Task3_Tests extends Assert {
    class TestComparator implements MyComparator<Integer> {
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    }

    @Test
    public void HeapSort_HeapSortSameElements_ArrayNotChange() {
        HeapSort<Integer> hs = new HeapSort<>();
        Integer[] data = {1, 1, 1};
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 1, 1}, data);
    }

    @Test
    public void HeapSort_HeapSortAlreadySortedArray_ArrayIsCorrect() {
        HeapSort<Integer> hs = new HeapSort<>();
        Integer[] data = {1, 2, 3};
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void HeapSort_HeapSortArray_ArrayIsCorrect() {
        HeapSort<Integer> hs = new HeapSort<>();
        Integer[] data = {1, 3, 2};
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void HeapSort_HeapSortNegativeElementsWithNormal_ArrayIsCorrect() {
        HeapSort<Integer> hs = new HeapSort<>();
        Integer[] data = {1, 0, -1};
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{-1, 0, 1}, data);
    }

    @Test
    public void HeapSort_HeapSortUnsortedArray_ArrayIsCorrect() {
        HeapSort<Integer> hs = new HeapSort<>();
        Integer[] data = {9, 2, 3, 6, 1, 0, 8, 5, 7, 4};
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, data);
    }

    @Test
    public void HeapSort_HeapSortUnsortedArrayWithSameElements_ArrayIsCorrect() {
        HeapSort<Integer> hs = new HeapSort<>();
        Integer[] data = {9, 2, 3, 6, 1, 0, 8, 5, 7, 4, 1};
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{0, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9}, data);
    }

    @Test
    public void HeapSort_HeapSortUnsortedArrayWithNegativeElements_ArrayIsCorrect() {
        HeapSort<Integer> hs = new HeapSort<>();
        Integer[] data = {9, 2, 3, 6, 1, -2, 0, 8, 5, 7, 4, -1};
        hs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, data);
    }

    @Test
    public void MergeSort_MergeSortSameElements_ArrayIsCorrect() {
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {1, 1, 1};
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 1, 1}, data);
    }

    @Test
    public void MergeSort_MergeSortAlreadySortedArray_ArrayIsCorrect() {
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {1, 2, 3};
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void MergeSort_MergeSortUnsortedArray_ArrayIsCorrect() {
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {1, 3, 2};
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void MergeSort_MergeSortBigUnsortedArray_ArrayIsCorrect() {
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {9, 2, 3, 6, 1, 0, 8, 5, 7, 4};
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, data);
    }

    @Test
    public void MergeSort_MergeSortNegativeElementsWithNormal_ArrayIsCorrect() {
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {1, 0, -1};
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{-1, 0, 1}, data);
    }

    @Test
    public void MergeSort_MergeSortUnsortedArrayWithNegativeElements_ArrayIsCorrect() {
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {9, 2, 3, 6, 1, -2, 0, 8, 5, 7, 4, -1};
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, data);
    }

    @Test
    public void MergeSort_MergeSortUnsortedArrayWithSameElements_ArrayIsCorrect() {
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {0, 0, 1, 2, 2, 1, 2};
        ms.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{0, 0, 1, 1, 2, 2, 2}, data);
    }

    @Test
    public void QuickSort_QuickSortArrayWithSameElements_ArrayIsCorrect() {
        QuickSort<Integer> qs = new QuickSort<>();
        Integer[] data = {1, 1, 1};
        qs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 1, 1}, data);
    }

    @Test
    public void QuickSort_QuickSortAlreadySortedArray_ArrayIsCorrect() {
        QuickSort<Integer> qs = new QuickSort<>();
        Integer[] data = {1, 2, 3};
        qs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void QuickSort_QuickSortUnsortedArray_ArrayIsCorrect() {
        QuickSort<Integer> qs = new QuickSort<>();
        Integer[] data = {1, 3, 2};
        qs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{1, 2, 3}, data);
    }

    @Test
    public void QuickSort_QuickSortNegativeElementsWithNormal_ArrayIsCorrect() {
        QuickSort<Integer> qs = new QuickSort<>();
        Integer[] data = {1, 0, -1};
        qs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{-1, 0, 1}, data);
    }


    @Test
    public void QuickSort_QuickSortBigUnsortedArray_ArrayIsCorrect() {
        QuickSort<Integer> qs = new QuickSort<>();
        Integer[] data = {9, 2, 3, 6, 1, 0, 8, 5, 7, 4};
        qs.sort(data, new TestComparator());
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, data);
    }
}