import static org.junit.Assert.*;
import static org.junit.Assume.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;

import org.junit.runner.RunWith;
import org.junit.experimental.theories.*;
import org.junit.Test;

import java.util.Collection;
import java.util.Arrays;

@RunWith(Theories.class)
public class MinimalReproducingTest {

    @DataPoints
    public static int[][] arrayDataPoints = new int[][] {
        new int[] {},
        null
    };

    @DataPoints
    public static Collection<int[]> moreDataPointsPlz() {
        int[][] foo = new int[][] {
            new int[] {},
            null
        };
        return Arrays.asList(foo);
    }

    @DataPoints
    public static Collection<int[]> evenmore = Arrays.asList(new int[][] {
            new int[] {},
            null
        });

    @DataPoint
    public static int[] foo = null;

    @DataPoints
    public static String[] stringData = new String[] {
        "Foo",
        "Bar"
    };

    public MinimalReproducingTest(String testString) {
        // assumeNotNull(testString);
        myString = testString;
    }

    public String myString;

    @Theory
    public void testingClassParameterizationWithTheory() {
        assertThat(myString.length(), is(3));
    }

    @Test
    public void testingClassParameterizationWithTest() {
        assertThat(myString.length(), is(3));
    }

    @Theory
    public void testingIntegerArrays(int[] a) {
        assertTrue(arrayProcessingCode(a, myString) <= myString.length());
        assertTrue(arrayProcessingCode(a, myString) > -2);
    }

    public int arrayProcessingCode(int[] a, String str) {
        if (a != null) return str.length();
        return -1;
    }
}
