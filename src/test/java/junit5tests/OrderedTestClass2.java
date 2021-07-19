package junit5tests;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderedTestClass2 {

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
    @Order(2)
    public void firstMethod() {

        System.out.println("This is the first test method");
    }

    @Test
    @DisplayName("US1234 - TC12 - this method is the second one")
    public void secondMethod() {

        System.out.println("This is the second test method");
    }

    @Test
    @Order(1) // This makes this method to be the first to run
    public void thirdTest() {
        System.out.println("This is the third test method");
    }
}
