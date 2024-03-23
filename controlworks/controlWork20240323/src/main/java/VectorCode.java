public class VectorCode {

    Node head;

    int length;

    public VectorCode(int[] array) {
        length = array.length;

        for (int i = 0; i < array.length; i++) {
            insert(i, array[i]);
        }
    }

    public int[] decode() {

        int[] result = new int[length];

        Node current = head;

        while (current != null) {
            int i = current.index;
            int v = current.value;

            result[i] = v;

            current = current.next;
        }

        return result;

    }

    public void insert(int index, int value) {
        if (value != 0 & index < length) {
            Node newNode = new Node(index, value);

            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                boolean elementIsNotLast = false;
                while (current.next != null) {
                    if (index == current.index) {
                        current.value = value;
                        break;
                    }
                    if (current.next.index > index) {
                        elementIsNotLast = true;
                        break;
                    }
                    current = current.next;
                }

                if (index != current.index) {
                    if (elementIsNotLast) {
                        newNode.next = current.next;
                    }
                    current.next = newNode;
                }
            }
        }
    }

    public void delete(int index) {
        Node current = head;

        if (index == 0) {
            head = current.next;
        } else {
            while (current.next != null) {
                if (current.next.index == index) {
                    current.next = current.next.next;
                    break;
                }
                current = current.next;
            }
        }

    }

    public int scalarProduct(VectorCode v) {

        int result = 0;

        int length = Math.min(this.length, v.length);

        for (int i = 0; i < length; i++) {
            result += getValueByIndex(i) * v.getValueByIndex(i);
        }

        return result;
    }

    private int getValueByIndex(int index) {
        Node current = head;

        if (index > length) {
            return 0;
        }

        while (current != null) {
            if (current.index == index) {
                return current.value;
            }
            current = current.next;
        }

        return 0;
    }

    public VectorCode sum(VectorCode v) {
        int length = Math.max(this.length, v.length);

        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            result[i] = getValueByIndex(i) + v.getValueByIndex(i);
        }

        return new VectorCode(result);
    }

    public VectorCode vectorSum() {
        VectorCode result = new VectorCode(decode());

        Node current = result.head;

        int prevValue = current.value;
        while (current.next != null) {
            current = current.next;
            current.value += prevValue;
            prevValue = current.value;
        }

        return result;
    }

    public String toString() {
        String result = "";
        Node current = head;
        boolean first = true;
        while (current != null) {
            if (!first) {
                result += ", ";
            } else {
                first = false;
            }
            result += current;
            current = current.next;
        }
        return result;
    }

    private class Node {

        int index;

        int value;

        Node next;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public String toString() {
            return "(" + index + "," + value + ")";
        }
    }
}
