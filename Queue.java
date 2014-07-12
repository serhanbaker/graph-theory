/**
 * @serhanbaker
 */
public class Queue {
    public static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            next = null;
        }
    }

    Node first;
    Node last;

    public Queue() {
        first = null;
        last = null;
    }

    void enqueue(int item) {
        if (first == null) { // if queue is empty
            last = new Node(item);
            first = last; // new item is the only item in q.
        } else {
            last.next = new Node(item);
            last = last.next; // last element is the new item
        }
    }

    int dequeue() {
        if (first != null) { // if queue is not empty
            int item = first.val;
            first = first.next; // delete the first element
            return item; // return deleted item's value
        }
        return (Integer) null;
    }

    boolean isEmpty() {
        return first == null;
    }
}
