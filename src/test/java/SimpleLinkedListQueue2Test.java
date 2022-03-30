import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

class SimpleLinkedListQueue2Test {

    @Test
    void test1() throws Exception {
        String[] str = {"asdad", "gsdfsadassda", "faf", "a"};
        String[] expected = {"gsdfsadassda", "asdad", "faf", "a"};
        StringComparator comparator = new StringComparator();
        SimpleLinkedListQueue2<String> myQueue = new SimpleLinkedListQueue2<>(comparator);


        for (String elem : str) {
            myQueue.add(elem);
        }

        for(String elem : expected){
            Assertions.assertEquals(elem, myQueue.remove());
        }
    }

    @Test
    void test2() throws Exception {
        String[] str = {"gsdfsadassda", "b", "abc", "faf", "a"};
        String[] expected = {"gsdfsadassda", "abc", "faf","b", "a"};
        StringComparator comparator = new StringComparator();
        SimpleLinkedListQueue2<String> myQueue = new SimpleLinkedListQueue2<>(comparator);


        for (String elem : str) {
            myQueue.add(elem);
        }

        for(String elem : expected){
            Assertions.assertEquals(elem, myQueue.remove());
        }
    }

    @Test
    void test3() throws Exception {
        String[] str = {"111", "aaa", "1234","1", "a"};
        String[] expected = {"1234", "111", "aaa", "1", "a"};
        StringComparator comparator = new StringComparator();
        SimpleLinkedListQueue2<String> myQueue = new SimpleLinkedListQueue2<>(comparator);


        for (String elem : str) {
            myQueue.add(elem);
        }

        for(String elem : expected){
            Assertions.assertEquals(elem, myQueue.remove());
        }
    }

    @Test
    void test4() throws Exception {
        String[] str = {"1", "2", "3"};
        String[] expected = {"1", "2", "3"};
        StringComparator comparator = new StringComparator();
        SimpleLinkedListQueue2<String> myQueue = new SimpleLinkedListQueue2<>(comparator);


        for (String elem : str) {
            myQueue.add(elem);
        }

        for(String elem : expected){
            Assertions.assertEquals(elem, myQueue.remove());
        }
    }

    @Test
    void test5() throws Exception {
        String[] str = {};
        String[] expected = {};
        StringComparator comparator = new StringComparator();
        SimpleLinkedListQueue2<String> myQueue = new SimpleLinkedListQueue2<>(comparator);


        for (String elem : str) {
            myQueue.add(elem);
        }

        for(String elem : expected){
            Assertions.assertEquals(elem, myQueue.remove());
        }
    }

    @Test
    void test6JavaQueue(){
        String[] str = {"asdad", "gsdfsadassda", "faf", "a"};
        String[] expected = {"gsdfsadassda", "asdad", "faf", "a"};
        StringComparator comparator = new StringComparator();
        PriorityQueue<String> myQueue = new PriorityQueue<>(comparator);


        myQueue.addAll(Arrays.asList(str));

        for(String elem : expected){
            Assertions.assertEquals(elem, myQueue.remove());
        }
    }

    @Test
    void test7JavaQueue(){
        String[] str = {"asd", "gsdfsadassda", "faf", "a", "b"};
        String[] expected = {"gsdfsadassda", "asd", "faf", "a", "b"};
        StringComparator comparator = new StringComparator();
        PriorityQueue<String> myQueue = new PriorityQueue<>(comparator);


        myQueue.addAll(Arrays.asList(str));

        for(String elem : expected){
            Assertions.assertEquals(elem, myQueue.remove());
        }
    }

    @Test
    void test8JavaQueue() throws Exception {
        String[] str = {"111", "aaa", "1234","1", "a"};
        String[] expected = {"1234", "aaa", "111", "1", "a"};
        StringComparator comparator = new StringComparator();
        PriorityQueue<String> myQueue = new PriorityQueue<>(comparator);


        myQueue.addAll(Arrays.asList(str));

        for(String elem : expected){
            Assertions.assertEquals(elem, myQueue.remove());
        }
    }
}