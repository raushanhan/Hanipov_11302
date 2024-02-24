public class Task10 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(20);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        list.insertAfterAll(20, 10);
        System.out.println(list);
    }
}
