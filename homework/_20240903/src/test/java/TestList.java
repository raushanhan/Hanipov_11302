import org.junit.Assert;
import org.junit.Test;
import org.example.List;

public class TestList {

    @Test
    public void testAddAndContains() {
        List<Integer> list = new List<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(17);

        Assert.assertEquals("4 true true false",
                list.getSize() + " " + list.contains(1) + " " + list.contains(3) + " " +
                list.contains(18));
    }

    @Test
    public void testRemove() {
        List<Integer> list = new List<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(17);

        list.remove(3);
        list.remove(4);

        Assert.assertArrayEquals(new Integer[]{1, 2, 17}, list.getData());
    }

    @Test
    public void testGet() {
        List<Integer> list = new List<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(17);

        Assert.assertEquals("3 4", list.getValue(2) + " " +
                list.getIndex(17));

    }
}
