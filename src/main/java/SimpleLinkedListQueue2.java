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
            if (comparator.compare(value, head.value) < 0){
                    SimpleLinkedListNode temp = head;
                    head = new SimpleLinkedListNode(value);
                    head.next = temp;
            } else {
                SimpleLinkedListNode current = head;
                while (current.next != null) {
                    if (comparator.compare(value, current.next.value) < 0) {
                        SimpleLinkedListNode temp = current.next;
                        current.next = new SimpleLinkedListNode(value);
                        current.next.next = temp;
                        break;
                    }
                    current = current.next;
                }
                if (current.next == null) {
                    tail.next = new SimpleLinkedListNode(value);
                    tail = tail.next;
                }
            }
        }
        size++;
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



