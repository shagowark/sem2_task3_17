import java.util.Comparator;

public class SimpleLinkedListQueue2<T extends Comparable<T>> {

    public class SimpleLinkedListNode {
        protected T value;
        protected SimpleLinkedListNode next;

        public SimpleLinkedListNode(T value, SimpleLinkedListNode next) {
            this.value = value;
            this.next = next;
        }

        public SimpleLinkedListNode(T value) {
            this(value, null);
        }

    }


    private SimpleLinkedListNode head = null;
    private SimpleLinkedListNode tail = null;
    private int size = 0;
    private Comparator<T> comparator;

    public SimpleLinkedListQueue2(){
        this.comparator = new DefaultComparator<>();
    }
    public SimpleLinkedListQueue2(Comparator<T> comparator){
        this.comparator = comparator;
    }

    public void add(T value) {
        if (size == 0) {
            head = tail = new SimpleLinkedListNode(value);
        } else {
            tail.next = new SimpleLinkedListNode(value);
            tail = tail.next;
        }
        size++;
        sort(comparator);
    }

    public void sort(Comparator<T> comparator){
        SimpleLinkedListNode current = head;
        T temp;

        while(current != null) {
            SimpleLinkedListNode next = current.next;
            while (next != null) {
                if (comparator.compare(current.value, next.value) > 0) {
                    temp = current.value;
                    current.value = next.value;
                    next.value = temp;
                }
                next = next.next;
            }
            current = current.next;
        }
    }

    public T remove() throws Exception {
        T result = element();
        head = head.next;
        if (size == 1) {
            tail = null;
        }
        size--;
        return result;
    }

    public T element() throws Exception {
        if (count() == 0) {
            throw new Exception("Empty queue");
        }
        return head.value;
    }

    public int count() {
        return size;
    }

    public boolean empty() {
        return count() == 0;
    }


}



