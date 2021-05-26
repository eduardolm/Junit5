package junit5tests;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @TestInstance -> if lifecycle set PER_CLASS, methodSource doesn't need to be static. Otherwise, methodSource
 * must be static
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Allows methodSource not to be declared as static.
public class ParameterizedTests {

    /**
     * When using @ValueSource, we can only pass one parameter to the test
     * @param theParam
     */
    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1, 5, 6})
    public void intValues(int theParam) {

        System.out.println("theParam = " + theParam);
    }

    /**
     * @NullSource -> Passes null as the parameter
     * @EmptySource -> Passes empty string as the parameter
     * @NullAndEmptySource -> Passes both null and empty string as the parameters
     * @param theParam
     */
    @ParameterizedTest
    @NullAndEmptySource // Passes both null and empty string as the parameter
    @ValueSource(strings = {"firstString", "secondString"})
    public void stringVales(String theParam) {

        System.out.println("theParam = " + theParam);
    }

    /**
     * @CsvSourrce -> Each collection of test parameters are passed inside "A, B", so "A" and "B" are passed as
     * parameters
     * @param param1
     * @param param2
     */
    @ParameterizedTest
    @CsvSource(value = {"Steve, Rogers", "Captain, Marverl", "Bucky, Barnes"})
    public void csvSource_StringString(String param1, String param2) {

        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    /**
     * When defining the parameter types, we can pass different parameters to the test method. All the passed parameters
     * are enclosed inside ""
     * @param param1
     * @param param2
     * @param param3
     */
    @ParameterizedTest
    @CsvSource(value = {"Steve, 32, true", "Captain, 21, false", "Bucky, 5, true"})
    public void csvSource_StringIntBoolean(String param1, int param2, boolean param3) {

        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }

    @ParameterizedTest
    @CsvSource(value = {"Captain America, 'Steve, Rogers'", "Winter Soldier, 'Bucky, Barnes'"})
    public void csvSource_StringWithComma(String param1, String param2) {

        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"Steve? Rogers", "Bucky? Barnes"}, delimiter = '?')
    public void csvSource_StringWithDiffDelimiter(String param1, String param2) {

        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    /**
     * When passing parameters from csv file, if there are headers or other info that should not be imported,
     * we can use the numLinesToSkip parameter to skip those lines. At our example, we skip the first line
     * @param name
     * @param price
     * @param qty
     * @param measure
     * @param provider
     */
    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/params/shoppinglist.csv",
            "src/test/resources/params/shoppinglist2.csv"}, numLinesToSkip = 1)
    public void csvFileSource_StringDoubleIntStringString(String name, Double price, Integer qty, String measure,
                                                          String provider) {

        System.out.println("Name = " + name + ", Price = " + price + ", Qty = " + qty + ", Measure = " +
                measure + ", Provider = " + provider);
    }

    /**
     * When we want to specify an empty string on the csv file, we pass "".
     * If we want to pass null from the empty file, just leave the corresponding field totally blank
     * @param name
     * @param price
     * @param qty
     * @param measure
     * @param provider
     */
    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/params/shoppinglist3.csv", numLinesToSkip = 1, delimiterString = "___")
    public void csvFileSource_StringDoubleIntStringStringSpecifiedDelimiter(String name, Double price, Integer qty, String measure,
                                                          String provider) {

        System.out.println("Name = " + name + ", Price = " + price + ", Qty = " + qty + ", Measure = " +
                measure + ", Provider = " + provider);
    }

    @ParameterizedTest
    @MethodSource(value = "sourceString")
    public void methodSource_String(String param1) {
        System.out.println("param1 = " + param1);
    }

    List<String> sourceString() {
        // Processing done here
        return Arrays.asList("tomato", "Carrot", "cabbage");
    }


    @ParameterizedTest
    @MethodSource(value = "sourceStringAsStream")
    public void methodSource_Stream(String param1) {
        System.out.println("param1 = " + param1);
    }

    Stream<String> sourceStringAsStream() {
        // processing...
        return Stream.of("beetroot", "apple", "pear");
    }

    @ParameterizedTest
    @MethodSource(value = "sourceList_String_Double")
    public void methodSource_StringDoubleList(String param1, Double param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    List<Arguments> sourceList_String_Double() {
        return Arrays.asList(Arguments.of("tomato", 2.0), Arguments.of("carrot", 4.5), Arguments.of("cabbage", 7.8));
    }

    /**
     * When our method source is in another class, we have to provide the full location of the file:
     * package.Class#method_name
     * @param param1
     * @param param2
     */
    @ParameterizedTest
    @MethodSource(value = "junit5tests.ParamProvider#sourceStream_StringDouble")
    public void methodSource_StringDoubleStream(String param1, Double param2) {
        System.out.println("\nParams from another class");
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
        System.out.println();
    }

}
