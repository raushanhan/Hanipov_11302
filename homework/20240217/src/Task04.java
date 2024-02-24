public class Task04 {

    public static void main(String[] args) {
        LinkedList list = new OrderedLinkedList();

        list.insert(-15);
        list.insert(40);
        list.insert(30);
        list.insert(20);
        list.insert(-20);

        System.out.println(list);
    }
}
