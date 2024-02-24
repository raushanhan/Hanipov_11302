public class Node {

    int value;

    Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public String toString() {
        return value + " " + next;
    }
}
