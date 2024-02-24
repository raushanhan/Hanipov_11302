public class LinkedList {

    protected Node head;

    protected Node end;

    protected int size;

    public LinkedList() {
        this.head = null;
        this.end = null;
        this.size = 0;
    }

    public void insert(int n) {
        Node newNode = new Node(n);

        if (head == null) {
            head = newNode;
        } else {
            if (end == null) {
                end = newNode;
                head.next = end;
            } else {
                end.next = newNode;
                end = end.next;
            }
        }
        size++;
    }

    public void insertAfter(int x, int y) { // task 08
        Node newNode = new Node(y);

        Node current = head;
        while (current != null) {
            if (current.value == x) {
                newNode.next = current.next;
                current.next = newNode;
                break;
            }
            current = current.next;
        }
    }

    public void insertBefore(int x, int y) { // task 09
        Node newNode = new Node(y);


        if (head.value == x) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                if (current.next.value == x) {
                    newNode.next = current.next;
                    current.next = newNode;
                    break;
                }
                current = current.next;
            }
        }
    }

    public void insertAfterAll(int x, int y) { // task 10
        Node current = head;
        while (current != null) {
            Node newNode = new Node(y);
            if (current.value == x) {
                newNode.next = current.next;
                current.next = newNode;
            }
            current = current.next;
        }
    }

    public String toString() {
        if (head == null) {
            return "[]";
        }

        String result = "[";

        Node current = head;

        while (current.next != null) {
            result += current.value + ", ";
            current = current.next;
        }
        result += current.value + "]";

        return result;
    }

    public int getMax() { // task 01
        int res = head.value;

        Node current = head.next;

        while (current != null) {
            if (current.value > res) {
                res = current.value;
            }
            current = current.next;
        }

        return res;
    }

    public boolean contains(int x) { // task 02
        Node current = head;

        while (current != null) {
            if (current.value == x) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void sort() { // task 03
        Node current = head;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < size - 1; i++) {
                if (current.value > current.next.value) {
                    int mid = current.value;
                    current.value = current.next.value;
                    current.next.value = mid;
                    sorted = false;
                }
                current = current.next;
            }
            current = head;
        }
    }

    public void removeFirstTwo() { // task05
        if (size < 3) {
            head = null;
            size = 0;
            end = null;
        } else {
            head = head.next.next;
            size -= 2;
        }
    }

    public void remove(int x) { // task06
        if (size > 0) {
            if (head.value == x) {
                head = head.next;
                size--;
            } else if (size >= 2) {
                Node current = head;

                while (current.next != null) {
                    if (current.next.value == x) {
                        current.next = current.next.next;
                        size--;
                        break;
                    }
                    current = current.next;
                }
            }
        }
    }

    public void removeAll(int x) {
        if (size > 0) {

            Node current = head;

            while (current.next != null) {
                if (current.next.value == x) {
                    current.next = current.next.next;
                    size--;
                }
                if (current.next != null) {
                    if (current.next.value != 20) {
                        current = current.next;
                    }
                }
            }

            if (head.value == x) {
                head = head.next;
            }
        }
    }

}