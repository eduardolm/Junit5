package junit5tests;

import org.junit.jupiter.api.*;

public class MiscTest {

    /**
     * Default time unit for timeout is seconds.
     * Units can also be directly specified, in all time units avaliable
     */
    @Test
    @Timeout(5)
    public void timeout() throws InterruptedException {
        System.out.println("This is the test with the timeout");
        Thread.sleep(6000);
    }

    @Test
    @Timeout(90)
    @DisplayName("This is the nice method")
    @Tag("theTag")
    public void annotateMethod1() {
        System.out.println(" This is the annotated method");
    }

    /**
     * We can create custom annotations to be used in tests. The custom annotation created here substitutes all the 4
     * annotations from the previews test method
     * @throws InterruptedException
     */
    @MyAnnotation
    public void annotatedMethod2() throws InterruptedException {
        System.out.println("This is the custom annotated method");
        Thread.sleep(3000);
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class NestedTest {
        @BeforeAll
        public void beforeAll() {
            System.out.println("Before All in nested test");
        }

        @Test
        public void nestedTestMethod() {
            System.out.println("Nested test method");
        }
    }
}
