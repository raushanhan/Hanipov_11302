public class OrderedLinkedList extends LinkedList {

    public void insert(int n) {
        Node newNode = new Node(n);

        if (head == null) {
            head = newNode;
        } else if (n <= head.value) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null & n < current.value) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }
}
