import com.structure.ArrayList;
import org.junit.Test;

public class ArrayListTest {

    @Test
    public void Test1(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        for (int i = 0; i < 50; i++) {
            list.add(i);
        }
        System.out.println(list.size());
        System.out.println(list);
    }
}
