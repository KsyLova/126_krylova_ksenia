import org.junit.*;
import org.junit.Assert;


public class Task1_Tests extends Assert {

    DoubleLinkedList<Integer> DoubleLinkedList;

    @Before
    public void setUp() {
        DoubleLinkedList = new DoubleLinkedList<>();
    }

    @Test
    public void emptyShouldReturnEmpty() {
        assertTrue(DoubleLinkedList.isEmpty());
    }

    @Test
    public void isEmptyWithNotEmptyListShouldReturnFalse() {
        DoubleLinkedList.pushBack(100);
        assertFalse(DoubleLinkedList.isEmpty());
    }

    @Test
    public void getHeadGetTail_PushTwoElements_HeadAndTailIsCorrect() {
        DoubleLinkedList.pushBack(10);
        DoubleLinkedList.pushBack(100);
        Node<Integer> head = (Node<Integer>) DoubleLinkedList.getHead();
        Node<Integer> tail = (Node<Integer>) DoubleLinkedList.getTail();

        assertEquals(10, head.getData().intValue());
        assertEquals(100, tail.getData().intValue());
    }

    @Test
    public void get_PushElementWithIndexEqualsSize_Exception() {
        DoubleLinkedList.pushBack(10);
        try {
            DoubleLinkedList.get(1);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
    public void get_PushTwoElements_TheSecondElementIsCorrect() {
        DoubleLinkedList.pushBack(10);
        DoubleLinkedList.pushBack(20);
        Node<Integer> elem = (Node<Integer>) DoubleLinkedList.get(1);
        assertEquals(20, elem.getData().intValue());
    }

    @Test
    public void pushOneElementToFront() {
        DoubleLinkedList.pushFront(10);
        int result = ((Node<Integer>) DoubleLinkedList.get(0)).getData();
        assertEquals(10, result);
    }

    @Test
    public void pushTwoElementToFront() {
        DoubleLinkedList.pushFront(10);
        DoubleLinkedList.pushFront(100);
        int result = ((Node<Integer>) DoubleLinkedList.get(0)).getData();
        assertEquals(100, result);
    }

    @Test
    public void pushOneElementToBack() {
        DoubleLinkedList.pushBack(10);
        int result = ((Node<Integer>) DoubleLinkedList.get(0)).getData();
        assertEquals(10, result);
    }

    @Test
    public void pushTwoElementToBack() {
        DoubleLinkedList.pushBack(10);
        DoubleLinkedList.pushBack(100);
        int result = ((Node<Integer>) DoubleLinkedList.get(0)).getData();
        assertEquals(10, result);
    }

    @Test
    public void insertElementInMiddle() {
        DoubleLinkedList.pushBack(10);
        DoubleLinkedList.pushBack(100);
        DoubleLinkedList.insertAfter(DoubleLinkedList.get(0), 200);
        int result = ((Node<Integer>) DoubleLinkedList.get(1)).getData();
        assertEquals(200, result);
    }


    @Test
    public void pushFront_PushTwoElements_HeadAndTailIsCorrect() {

        DoubleLinkedList.pushFront(20);
        DoubleLinkedList.pushFront(30);

        Node<Integer> head = (Node<Integer>) DoubleLinkedList.getHead();
        Node<Integer> tail = (Node<Integer>) DoubleLinkedList.getTail();

        assertEquals(30, head.getData().intValue());
        assertEquals(20, tail.getData().intValue());
    }

    @Test
    public void remove_RemoveElementFromList_ConnectionNextAndPrevCorrect() {
        Node<Integer> elem = (Node<Integer>) DoubleLinkedList.pushBack(20);
        Node<Integer> next = (Node<Integer>) DoubleLinkedList.insertAfter(elem, 40);
        Node<Integer> prev = (Node<Integer>) DoubleLinkedList.insertBefore(elem, 15);

        DoubleLinkedList.remove(elem);

        Node<Integer> elem1 = (Node<Integer>) prev.getNext();
        Node<Integer> elem2 = (Node<Integer>) next.getPrev();

        assertEquals(40, elem1.getData().intValue());
        assertEquals(15, elem2.getData().intValue());
    }

    @Test
    public void insertListAfter_insertListOneInListTwoAfterSecondElement_SequenceOfElementsIsCorrect() {

        DoubleLinkedList.pushBack(0);
        DoubleLinkedList.pushBack(10);
        DoubleLinkedList.pushBack(40);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushBack(20);
        list2.pushBack(30);

        DoubleLinkedList.insertListAfter(DoubleLinkedList.get(1), list2);

        for (int i = 0; i < 5; i++)
            assertEquals(i * 10, ((Node<Integer>) DoubleLinkedList.get(i)).getData().intValue());

    }

    /*@Test
    public void insertListAfter_insertListOneInListTwoAfterSecondElement_SequenceOfElementsIsCorrect1() {

        DoubleLinkedList.pushBack(0);
        DoubleLinkedList.pushBack(10);
        DoubleLinkedList.pushBack(20);
        DoubleLinkedList.pushBack(30);
        DoubleLinkedList.pushBack(40);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushBack(50);
        list2.pushBack(60);

        DoubleLinkedList.insertListAfter(DoubleLinkedList.get(DoubleLinkedList.getSize()-1), list2);
        DoubleLinkedList.insertListAfter(DoubleLinkedList.get(1), list2);

        for (int i = 0; i < 7; i++)
            assertEquals(i * 10, ((Node<Integer>) DoubleLinkedList.get(i)).getData().intValue());

    }*/
    @Test
    public void insertListAfter_insertListAfterSecondElement_SequenceIsCorrect(){

        DoubleLinkedList.pushBack(10);
        DoubleLinkedList.pushBack(20);
        DoubleLinkedList.pushBack(30);
        DoubleLinkedList.pushBack(40);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushBack(50);
        list2.pushBack(60);

        DoubleLinkedList.insertListAfter(DoubleLinkedList.get(1), list2);

        Node<Integer> zero = (Node<Integer>) DoubleLinkedList.get(0);
        Node<Integer> one = (Node<Integer>) DoubleLinkedList.get(1);
        Node<Integer> two = (Node<Integer>) DoubleLinkedList.get(2);
        Node<Integer> three = (Node<Integer>) DoubleLinkedList.get(3);
        Node<Integer> four = (Node<Integer>) DoubleLinkedList.get(4);
        Node<Integer> five = (Node<Integer>) DoubleLinkedList.get(5);

        assertEquals(10, zero.getData().intValue());
        assertEquals(20, one.getData().intValue());
        assertEquals(50, two.getData().intValue());
        assertEquals(60, three.getData().intValue());
        assertEquals(30, four.getData().intValue());
        assertEquals(40, five.getData().intValue());
    }

    @Test
    public void insertListBefore_insertListBeforeSecondElement_SequenceIsCorrect(){

        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.pushBack(10);
        list1.pushBack(20);
        list1.pushBack(30);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();
        list2.pushBack(50);
        list2.pushBack(60);

        list1.insertListBefore(list1.get(1), list2);

        Node<Integer> zero = (Node<Integer>) list1.get(0);
        Node<Integer> one = (Node<Integer>) list1.get(1);
        Node<Integer> two = (Node<Integer>) list1.get(2);
        Node<Integer> three = (Node<Integer>) list1.get(3);
        Node<Integer> four = (Node<Integer>) list1.get(4);

        assertEquals(10, zero.getData().intValue());
        assertEquals(50, one.getData().intValue());
        assertEquals(60, two.getData().intValue());
        assertEquals(20, three.getData().intValue());
        assertEquals(30, four.getData().intValue());

    }





    @Test
    public void getSize_getSizeOfEmptyArray_SizeEqualsDefault() {
        DynamicArray<Integer> DynamicArray = new DynamicArray<>();

        assertEquals(1024, DynamicArray.getSize());
    }

    @Test
    public void createArray_CreateArrayWithSize_SizeIsCorrect() {
        DynamicArray<Integer> DynamicArray = new DynamicArray<>(20);

        assertEquals(20, DynamicArray.getSize());
    }

    @Test
    public void resize_setNewSize_NewSizeIsCorrect() {
        DynamicArray<Integer> DynamicArray = new DynamicArray<>(2);
        DynamicArray.resize(6);
        assertEquals(6, DynamicArray.getSize());
    }

    @Test
    public void get_getElementWithIndexEqualsSize_ThrowsException() {
        DynamicArray<Integer> array = new DynamicArray<>(3);

        array.set(0, 10);
        array.set(1, 20);
        array.set(2, 30);
        try {
            array.get(3);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
    public void set_setElementWithIndexEqualsSize_ThrowsException() {
        DynamicArray<Integer> array = new DynamicArray<>(3);
        try {
            array.set(3, 100);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
    public void insert_insertElementWithIndexEqualsSize_ThrowsException() {
        DynamicArray<Integer> array = new DynamicArray<>(3);
        try {
            array.insert(3, 100);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
    public void insert_InsertElements_ElementsAreCorrect() {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        array.set(0, 1);
        array.set(1, 2);
        array.set(2, 3);
        array.insert(1, 5);

        assertEquals(1, array.get(0).intValue());
        assertEquals(5, array.get(1).intValue());
        assertEquals(2, array.get(2).intValue());
        assertEquals(3, array.get(3).intValue());
    }

    @Test
    public void pushBack_pushBackElements_ElementsAreCorrect() {
        DynamicArray<Integer> array = new DynamicArray<>(3);
        array.set(0, 100);
        array.set(1, 200);
        array.set(2, 300);

        array.pushBack(400);

        assertEquals(400, array.get(3).intValue());
    }

    @Test
    public void popBack_popBackElementFromEmptyArray_ThrowsException() {
        DynamicArray<Integer> array = new DynamicArray<>(0);
        try {
            array.popBack();
            fail();
        } catch (UnsupportedOperationException e) {
            assertTrue(true);
        }
    }

    @Test
    public void remove_removeIndexOutOfBounds_ThrowsException() {
        DynamicArray<Integer> array = new DynamicArray<>(3);
        try {
            array.remove(3);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }
}
