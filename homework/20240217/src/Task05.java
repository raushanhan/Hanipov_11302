public class Task05 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        list.removeFirstTwo();
        System.out.println(list);
    }
}
