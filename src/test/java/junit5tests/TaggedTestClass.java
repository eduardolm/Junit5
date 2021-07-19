package junit5tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaggedTestClass {

    @BeforeAll
    public void beforeAll() {

        System.out.println("--This is the before All method");
    }

    @BeforeEach
    public void beforeEach() {

        System.out.println("----This is the before Each method");
    }

    @AfterAll
    public void afterAll() {

        System.out.println("--This the after All method");
    }

    @AfterEach
    public void afterEach() {

        System.out.println("----This is the after Each method");
    }

    @Test
    @Tag(value = "sanity")
    public void firstMethod() {
        System.out.println("This is the first test method");
    }

    @Test
    @Tag(value = "sanity")
    @Tag(value = "acceptance")
    @DisplayName("US1234 - TC12 - this method is the second one")
    public void secondMethod() {
        System.out.println("This is the second test method");
    }

    @Test
    @Tag(value = "acceptance")
    public void thirdMethod() {
        System.out.println(" This is the third test method");
    }

    @Tag(value = "acceptance")
    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1, 5, 6})
    public void intValues(int theParam) {
        System.out.println("theParam = " + theParam);
    }
}
