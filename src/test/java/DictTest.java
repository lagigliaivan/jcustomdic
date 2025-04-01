import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DictTest {
    @Test
    public void TestAddMethod(){
        Dictionary dic = new Dictionary();
        dic.Add("hello");

        assertEquals(true, dic.Contains("hello"));
    }

    @Test
    public void TestSearchMethod(){
        Dictionary dic = new Dictionary();
        dic.Add("hello");

        assertEquals(true, dic.Contains("hello"));
        assertEquals(false, dic.Contains("bye"));
    }

    @Test
    public void TestAutoComplete(){
        Dictionary dic = new Dictionary();
        dic.Add("hello");
    	dic.Add("world");
    	dic.Add("hello world");
    	dic.Add("world hell");
    	dic.Add("world hello");
    	dic.Add("foo");
    	dic.Add("bar");

       Dictionary d = dic.Prefix("hell");
       
       assertEquals(true, d.Contains("hello"));
       assertEquals(true, d.Contains("hello world"));
       assertEquals(true, d.Contains("world hell"));
       assertEquals(true, d.Contains("world hello"));
    }

    @Test
    public void Remove(){
        Dictionary dic = new Dictionary();
        dic.Add("hello");
        dic.Add("bye");

        dic.Remove("bye");

        assertEquals(true, dic.Contains("hello"));
        assertEquals(false, dic.Contains("bye"));
    }
}
