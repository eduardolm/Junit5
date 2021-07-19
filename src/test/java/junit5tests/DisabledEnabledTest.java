package junit5tests;

import listeners.Listener;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@ExtendWith(Listener.class)
public class DisabledEnabledTest {

    /**
     * @Disabled when used alone simply disables the annotated test. When passed with a value inside (), outputs this
     * value, for the disabled test
     */
    @Test
    @Disabled(value = "Disabled for demo of @Disabled")
    public void firstTest() {
        System.out.println("This is the first test method");
    }

    /**
     * @DisabledOnOs receives two parameters: The first one is the OS on which the test should be disabled and
     * the second one is the reason for the test to be disabled
     */
    @Test
    @DisabledOnOs(value = OS.WINDOWS, disabledReason = "Disabled for demo of @DisabledOnOs")
    public void secondTest() {
        System.out.println("This is the second test method");
    }

    /**
     * @EnabledOnOs receives two parameters. The first one is the OS on which the test should be enabled and the
     * second one is the reason for this
     */
    @Test
    @EnabledOnOs(value = OS.MAC, disabledReason = "Enabled for demo of @EnabledOnOs. Will only run on MAC OS")
    public void thirdTest() {
        System.out.println("This is the third test method");
    }

    /**
     * @DisabledIfSystemProperty receives three parameters. The first one is the name of the property, the second one
     * is the value of the property and the third one is the reason for the test to be disabled
     */
    @Test
    @DisabledIfSystemProperty(named = "env", matches = "staging", disabledReason = "Disabled for demo of @DisabledIfSystemProperty")
    public void fourthTest() {
        System.out.println("This is the fourth test method");
    }

    /**
     * @DisabledIf received two parameters: The first one is the boolean condition that if true disables the test. The
     * second one is the reason for the test to be disabled
     */
    @Test
    @DisabledIf(value = "provider", disabledReason = "Disabled for demo of @DisabledIf")
    public void fifthTest() {
        System.out.println("This is the fifth test method");
    }

    boolean provider() {
        return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.THURSDAY);
    }
}
