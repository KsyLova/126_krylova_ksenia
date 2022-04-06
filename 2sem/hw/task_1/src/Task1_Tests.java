import org.junit.*;

public class Task1_Tests extends Assert {


    // class Node

    @Test
    public void getNext_getDataOfNextElement_DataCorrect() {
        var prev = new Node<>(0);
        var next = new Node<>(0);
        var node = new Node<>(1, next, prev);
        assertEquals(next, node.getNext());
    }

    @Test
    public void getNext_getDataOfPrevElement_DataCorrect() {
        var prev = new Node<>(0);
        var next = new Node<>(0);
        var node = new Node<>(1, next, prev);
        assertEquals(prev, node.getPrev());
    }

    // class DoubleLinkedList

    @Test
    public void isEmpty_CheckList_isEmptyFalse() {
        var list = new DoubleLinkedList<>();
        assertTrue(list.isEmpty());
        list.insertAfter(list.getHead(), 0);
        assertFalse(list.isEmpty());
    }

    @Test
    public void getHead_getHeadOfListWithTwoElements_HeadIsCorrect() {
        var list = new DoubleLinkedList<>();
        list.insertBefore(list.getHead(), 0);
        var node = list.insertBefore(list.getHead(), 0);
        assertEquals(node, list.getHead());
    }

    @Test
    public void getTail_getTailOfListWithTwoElements_TailIsCorrect() {
        var list = new DoubleLinkedList<>();
        list.insertBefore(list.getTail(), 0);
        var node = list.insertAfter(list.getTail(), 0);
        assertEquals(node, list.getTail());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get_getElementByIndexEqualsSize_getException() {
        var list = new DoubleLinkedList<>();
        list.get(0);
    }

    @Test
    public void get_getElementByIndex_ElementIsCorrect() {
        var list = new DoubleLinkedList<>();
        list.insertAfter(list.getHead(), 0);
        var node = list.insertAfter(list.getHead(), 0);
        assertEquals(node, list.get(1));
    }

    @Test
    public void insertAfter_InsertIntoEmptyList_sizeEqualsOne() {
        var list = new DoubleLinkedList<>();
        list.insertAfter(list.getHead(), 2);
        assertEquals(1, list.getSize());
    }

    @Test
    public void pushFront_pushElements_HeadIsCorrect() {
        var list = new DoubleLinkedList<>();
        list.pushFront(0);
        list.pushFront(0);
        var node = list.pushFront(0);
        assertEquals(node, list.get(0));
    }

    @Test
    public void pushBack_pushElements_TailIsCorrect() {
        var list = new DoubleLinkedList<>();
        list.pushBack(0);
        list.pushBack(0);
        var node = list.pushBack(0);
        assertEquals(node, list.get(2));
    }

    @Test
    public void remove_removeElement_getNextIsCorrect() {
        var list = new DoubleLinkedList<>();
        list.pushBack(0);
        var node = list.pushBack(0);
        list.pushBack(0);
        list.remove(node);
        assertEquals(list.getTail(), list.getHead().getNext());
    }

    @Test
    public void remove_removeElement_getPrevIsCorrect() {
        var list = new DoubleLinkedList<>();
        list.pushBack(0);
        var node = list.pushBack(0);
        list.pushBack(0);
        list.remove(node);
        assertEquals(list.getHead(), list.getTail().getPrev());
    }

    @Test
    public void insertListAfter_insertListIntoItself_ListIsNotEmpty() {
        var list = new DoubleLinkedList<>();
        list.pushBack(1);
        list.insertListAfter(list.getHead(), list);
        assertFalse(list.isEmpty());
    }

    @Test
    public void insertListAfter_insertListAfterHead_PrevIsCorrect() {
        var list1 = new DoubleLinkedList<>();
        list1.pushBack(0);
        list1.pushBack(0);

        var list2 = new DoubleLinkedList<>();
        var node = list2.pushBack(0);
        list2.pushBack(0);

        list1.insertListAfter(list1.getHead(), list2);
        assertEquals(list1.getHead(), node.getPrev());
    }

    @Test
    public void insertListAfter_insertListAfterHead_NextIsCorrect() {
        var list1 = new DoubleLinkedList<>();
        list1.pushBack(0);
        list1.pushBack(0);

        var list2 = new DoubleLinkedList<>();
        list2.pushBack(0);
        var node = list2.pushBack(0);

        list1.insertListAfter(list1.getHead(), list2);
        assertEquals(list1.getTail(), node.getNext());
    }

    @Test
    public void insertListBefore_insertListIntoItself_ListIsNotEmpty() {
        var list = new DoubleLinkedList<>();
        list.pushBack(0);
        list.insertListBefore(list.getHead(), list);
        assertFalse(list.isEmpty());
    }

    @Test
    public void insertListBefore_insertListBeforeTail_GetPrevIsCorrect() {
        var list1 = new DoubleLinkedList<>();
        list1.pushBack(0);
        list1.pushBack(0);

        var list2 = new DoubleLinkedList<>();
        var node = list2.pushBack(0);
        list2.pushBack(0);

        list1.insertListBefore(list1.getTail(), list2);
        assertEquals(list1.getHead(), node.getPrev());
    }

    @Test
    public void insertListBefore_insertListBeforeSecondElem_SequenceOfElementsIsCorrect() {
        var list1 = new DoubleLinkedList<>();
        list1.pushBack(0);
        list1.pushBack(0);

        var list2 = new DoubleLinkedList<>();
        list2.pushBack(0);
        var node = list2.pushBack(0);

        list1.insertListBefore(list1.getTail(), list2);
        assertEquals(list1.getTail(), node.getNext());
    }

    // class DynamicArray

    @Test
    public void getSize_getSizeOfEmptyArray_SizeEqualsZero() {
        var arr = new DynamicArray<>();
        assertEquals(0, arr.getSize());
    }

    @Test
    public void get_getElementFromArray_ElementIsCorrect() {
        var arr = new DynamicArray<>(1);
        arr.set(0, 0);
        assertEquals(0, arr.get(0));
    }

    @Test
    public void resize_setNewSizeWithNegativeValue_ThrowsException() {
        var arr = new DynamicArray<>();
        var thrown = assertThrows(NegativeArraySizeException.class, () -> arr.resize(-1));
        assertEquals("Size can not be negative", thrown.getMessage());
    }

    @Test
    public void resize_setNewSizeWithPositiveValue_NewSizeIsCorrect() {
        var arr = new DynamicArray<>();
        arr.resize(1);
        assertEquals(1, arr.getSize());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get_getElementWithIndexEqualsSize_ThrowsException() {
        var arr = new DynamicArray<>();
        arr.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get_setElementWithIndexEqualsSize_ThrowsException() {
        var arr = new DynamicArray<>();
        arr.set(0, 0);
        assertEquals(0, arr.get(0));
    }

    @Test
    public void insert_DynamicArray_insert_get() {
        var arr = new DynamicArray<>();
        arr.insert(0, 0);
        assertEquals(0, arr.get(0));
    }

    @Test
    public void insert_DynamicArray_insert_grow() {
        var arr = new DynamicArray<>(1);
        arr.insert(0, 0);
        assertEquals(0, arr.get(0));
    }

    @Test
    public void insert_DynamicArray_insert_growZero() {
        var arr = new DynamicArray<>(0);
        arr.insert(0, 0);
        assertEquals(0, arr.get(0));
    }

    @Test
    public void insert_DynamicArray_insert_growZeroCap() {
        var arr = new DynamicArray<>(0);
        arr.insert(0, 0);
        arr.insert(0, 0);
        assertEquals(0, arr.get(0));
    }

    @Test
    public void pushBack_pushBackElement_ElemIsCorrect() {
        var arr = new DynamicArray<>();
        arr.pushBack(0);
        assertEquals(0, arr.get(0));
    }

    @Test
    public void pushBack_DynamicArray_pushBack_growZero() {
        var arr = new DynamicArray<>(0);
        arr.pushBack(0);
        assertEquals(0, arr.get(0));
    }

    @Test
    public void pushBack_DynamicArray_pushBack_growZeroCap() {
        var arr = new DynamicArray<>(0);
        arr.pushBack(0);
        arr.pushBack(0);
        assertEquals(0, arr.get(0));
    }

    @Test
    public void pushBack_pushToArrayWithSizeBackElement_ElemIsCorrect() {
        var arr = new DynamicArray<>(1);
        arr.pushBack(1);
        assertEquals(1, arr.get(1));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void popBack_popBackElementFromEmptyArray_ThrowsException() {
        var arr = new DynamicArray<>();
        arr.popBack();

    }

    @Test
    public void remove_removeElementWithIndexEqualsSize_ThrowsException() {
        var arr = new DynamicArray<>();
        var thrown = assertThrows(IndexOutOfBoundsException.class, () -> arr.remove(0));
        assertEquals("Index out of bounds", thrown.getMessage());
    }
}