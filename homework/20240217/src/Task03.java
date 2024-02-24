public class Task03 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(-15);
        list.insert(40);
        list.insert(30);
        list.insert(20);

        System.out.println(list);
        list.sort();
        System.out.println(list);
    }
}