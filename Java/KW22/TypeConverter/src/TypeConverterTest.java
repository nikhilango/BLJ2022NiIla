import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.HashSet;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TypeConverterTest {
    TypeConverter tc;

    @BeforeEach
    public void setup(){
        tc = new TypeConverter();
    }


    @Test
    public void isConvertStringToShort(){
        tc = new TypeConverter();
        short result = tc.convertStringToShort("13_000");
        assertEquals( 13000, result);
    }

    @Test
    public void isConvertStringToDouble(){
        double result = tc.convertStringToDouble("13_000");
        assertEquals( 13000.0, result);
    }

    @Test
    public void isConvertStringToLong(){
        long result = tc.convertStringToLong("13");
        assertEquals(13L, result);
    }

    @Test
    public void isStringToCharArray(){
        char[] expected = {'M', 'a', 'r', 'h', 'a', 'b', 'a', 'n'};
        char[] result = tc.StringToCharArray("Marhaban");
        boolean endResult = Arrays.equals(expected, result);
        assertTrue(endResult);
    }

    @Test
    public void isStringToCharSet(){
        HashSet<Character> expected = new HashSet<>();
        expected.add('t');
        expected.add('u');
        expected.add('r');
        expected.add('k');
        expected.add('e');
        expected.add('y');
        HashSet<Character> result = (HashSet<Character>) tc.StringToCharSet("turkey");
        assertEquals(expected, result);
    }
}
