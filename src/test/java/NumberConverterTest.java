import static org.junit.Assert.assertEquals;

import com.kishor.converter.NumberToWordConverter;
import org.junit.Test;

public class NumberConverterTest {

    @Test
    public void testGenericFourDigitNumberConversion() {
        NumberToWordConverter nbr2WordConv = new NumberToWordConverter();
        String output = nbr2WordConv.convertAndEnrichOutput(2346);
        assertEquals("Test 4 digit number",output , "two thousand three hundred and forty six");
    }

    @Test
    public void testStandaloneZeroConversion() {
        NumberToWordConverter nbr2WordConv = new NumberToWordConverter();
        String output = nbr2WordConv.convertAndEnrichOutput(000);
        assertEquals("Test for Zero",output , "zero");
    }

    @Test
    public void testTrailingZeroConversion() {
        NumberToWordConverter nbr2WordConv = new NumberToWordConverter();
        String output = nbr2WordConv.convertAndEnrichOutput(9200);
        assertEquals("Test for zero at the end of number",output , "nine thousand two hundred");
    }

    @Test
    public void testInvalidInputConversion() {
        NumberToWordConverter nbr2WordConv = new NumberToWordConverter();
        String output = nbr2WordConv.convertAndEnrichOutput(null);
        assertEquals("Test for null in out - it should not fail - graceful exit",output , "");
    }

    @Test
    public void testSingleDigitConversion() {
        NumberToWordConverter nbr2WordConv = new NumberToWordConverter();
        String output = nbr2WordConv.convertAndEnrichOutput(2);
        assertEquals("Test single digit conversion",output , "two");
    }

    @Test
    public void testForTenThousandConversion() {
        NumberToWordConverter nbr2WordConv = new NumberToWordConverter();
        String output = nbr2WordConv.convertAndEnrichOutput(10000);
        assertEquals("Test for hundred thousand",output , "ten thousand");
    }

    @Test
    public void testForInputsFromQuestionConversion1() {
        NumberToWordConverter nbr2WordConv = new NumberToWordConverter();
        String output = nbr2WordConv.convertAndEnrichOutput(21);
        assertEquals("Test for 21",output , "twenty one");
    }

    @Test
    public void testForInputsFromQuestionConversion2() {
        NumberToWordConverter nbr2WordConv = new NumberToWordConverter();
        String output = nbr2WordConv.convertAndEnrichOutput(1);
        assertEquals("Test for 1",output , "one");
    }

    @Test
    public void testForInputsFromQuestionConversion3() {
        NumberToWordConverter nbr2WordConv = new NumberToWordConverter();
        String output = nbr2WordConv.convertAndEnrichOutput(105);
        assertEquals("Test for 105",output , "one hundred and five");
    }

    @Test
    public void testForInputsFromQuestionConversion4() {
        NumberToWordConverter nbr2WordConv = new NumberToWordConverter();
        String output = nbr2WordConv.convertAndEnrichOutput(56945781);
        assertEquals("Test for 56945781",output , "fifty six million nine hundred and forty five thousand seven hundred and eighty one");
    }

    @Test
    public void testForInputsFromQuestionConversion5() {
        NumberToWordConverter nbr2WordConv = new NumberToWordConverter();
        String output = nbr2WordConv.convertAndEnrichOutput(999999999);
        assertEquals("Test for 999999999",output , "nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine");
    }
}
