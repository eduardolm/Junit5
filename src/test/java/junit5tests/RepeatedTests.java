package junit5tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class RepeatedTests {

    /**
     * @RepeatedTest: receives at least one parameter that indicates how many times the test should be run
     */
    @RepeatedTest(5)
    public void firstRepeatedMethod() {
        System.out.println("We are repeating this test");
    }

    /**
     * @RepeatedTest receies two parameters. First one is the number of repetitions and the second one is the name of
     * the runing test. Junit also returns currentRepetition and totalRepetitions variables that can be used as well.
     */
    @RepeatedTest(value = 3, name = "Running repetition: {currentRepetition}." + " Total is: {totalRepetitions}")
    @DisplayName("This is a repeated test method")
    public void secondRepeatedMethod() {
        System.out.println("We are repeating a new test");
    }

    /**
     * In this case, JUnit gives us the repetitionInfo, from where we can get the actual repetition occurrence.
     * We can also use this information to make assumptions and verifications in our test method
     *
     * @param repetitionInfo
     */
    @RepeatedTest(3)
    public void thirdRepeatedMethod(RepetitionInfo repetitionInfo) {
        System.out.println("This code will run at each repetition");
        assumingThat(repetitionInfo.getCurrentRepetition() == 3,
                () -> System.out.println("This code only runs for repetition " + "3"));
    }
}
