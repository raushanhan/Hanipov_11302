public class Main {

    public static void main(String[] args) {
        VectorCode v1 = new VectorCode(new int[]{1,5,0,3,2,0,66,0,0,0});
        System.out.println(v1);
        for (int elem : v1.decode()) {
            System.out.print(elem + " ");
        }
        System.out.println();

        v1.insert(0, 10);

        v1.insert(11, 5);
        v1.insert(7, 77);
        System.out.println(v1);

        for (int elem : v1.decode()) {
            System.out.print(elem + " ");
        }
        System.out.println();

        v1.delete(11);
        v1.delete(0);
        v1.delete(6);
        System.out.println(v1);

        for (int elem : v1.decode()) {
            System.out.print(elem + " ");
        }
        System.out.println();

        VectorCode v2 = new VectorCode(new int[]{1,5,0,3,2,0,66,0,0,0});

        System.out.println(v1.scalarProduct(v2));

        System.out.println(v1.sum(v2));

        System.out.println(v1.vectorSum());
    }
}
