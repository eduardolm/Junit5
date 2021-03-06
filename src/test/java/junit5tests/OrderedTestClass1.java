package junit5tests;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.DisplayName.class) // Defines run method order
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderedTestClass1 {

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
    public void firstMethod() {

        System.out.println("This is the first test method");
    }

    @Test
    @DisplayName("US1234 - TC12 - this method is the second one")
    public void secondMethod() {

        System.out.println("This is the second test method");
    }

    @Test
    @DisplayName("A display name")
    public void thirdMethod() {
        System.out.println("This is the third test method");
    }
}
