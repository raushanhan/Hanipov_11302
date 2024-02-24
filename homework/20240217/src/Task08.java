public class Task08 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        list.insertAfter(20, 10);
        System.out.println(list);
    }
}
