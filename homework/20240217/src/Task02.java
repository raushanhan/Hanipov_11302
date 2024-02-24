public class Task02 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(-15);
        list.insert(40);
        list.insert(30);
        list.insert(20);

        System.out.println(list);
        System.out.println(list.contains(-15));
        System.out.println(list.contains(0));
    }
}
