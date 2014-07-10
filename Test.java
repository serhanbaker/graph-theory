public class Test {
    public static void main (String[] args) {
        Node p = new Node(7);
        Node k = new Node(300);
        p.next = k;
        System.out.printf("this will be a field in our adjacency list %s\n", p);
    }
}
