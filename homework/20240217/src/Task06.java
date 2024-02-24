public class Task06 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(20);
        list.insert(10);
        list.insert(30);
        list.insert(40);

        list.remove(20);
        System.out.println(list);
    }
}
