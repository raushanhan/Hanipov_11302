import org.example.MyMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class MyMapTest {

    @Test
    public void testPutToFreeCell() {
        MyMap<Integer, String> map = new MyMap<>();
        map.put(1, "one");
        Assert.assertEquals(1, map.getSize());
    }

    @Test
    public void testChangeAValue() {
        MyMap<Integer, String> map = new MyMap();
        map.put(1, "one");
        String returnedElement = map.put(1, "another one");
        Assert.assertEquals("one, size: 1", returnedElement + ", size: " + map.getSize());
    }

    @Test
    public void testPutSameHashCodeKeys() {
        MyMap<Integer, String> map = new MyMap();
        map.put(1, "one");
        map.put(2, "two");
        Assert.assertNull(map.put(17, "seventeen"));
        Assert.assertEquals(3, map.getSize());
    }

    @Test
    public void testChangeAValueOfSameHashCodeKey() {
        MyMap<Integer, String> map = new MyMap();
        map.put(1, "one");
        map.put(2, "two");
        map.put(17, "actually not a seventeen");
        map.put(33, "seventeen");
        String returnedElement = map.put(33, "fake seventeen");
        Assert.assertEquals("seventeen, size: 4, fake seventeen",
                returnedElement + ", size: " + map.getSize() + ", " + map.get(33));
    }

    @Test
    public void testContainsKeyTrue() {
        MyMap<Integer, String> map = new MyMap();
        map.put(1, "one");
        map.put(2, "two");
        Assert.assertTrue(map.containsKey(2));
    }

    @Test
    public void testContainsSameHashCodeKey() {
        MyMap<Integer, String> map = new MyMap();
        map.put(1, "one");
        map.put(17, "two");
        Assert.assertTrue(map.containsKey(17));
    }

    @Test
    public void testContainsKeyFalse() {
        MyMap<Integer, String> map = new MyMap();
        map.put(1, "one");
        map.put(2, "two");
        Assert.assertFalse(map.containsKey(17));
    }

    @Test
    public void testGet() {
        MyMap<Integer, String> map = new MyMap();
        map.put(1, "one");
        map.put(2, "two");
        map.put(17, "seventeen");
        Assert.assertEquals("seventeen", map.get(17));
    }

    @Test
    public void testGetWhenALotOfElementsWithSameHash() {
        MyMap<Integer, String> map = new MyMap();
        map.put(1, "one");
        map.put(2, "two");
        map.put(18, "eighteen");
        map.put(34, "thirty four");
        map.put(50, "fifty fifty");
        Assert.assertEquals("fifty fifty", map.get(50));
    }

    @Test
    public void testRemove() {
        MyMap<Integer, String> map = new MyMap();
        map.put(1, "one");
        map.put(2, "two");
        map.put(17, "seventeen");
        boolean returned = map.remove(17);
        Assert.assertEquals("2 false true", map.getSize() + " " + map.containsKey(17) + " " + returned);
    }

    @Test
    public void testContainsValue() {
        MyMap<Integer, String> map = new MyMap();
        map.put(1, "one");
        map.put(2, "two");
        map.put(17, "seventeen");
        map.put(18, "eighteen");
        Assert.assertEquals("true true false", map.containsValue("seventeen") + " " +
                map.containsValue("eighteen") + " " + map.containsValue("Three"));
    }

}
