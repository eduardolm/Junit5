package junit5tests;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class ParamProvider {

    static Stream<Arguments> sourceStream_StringDouble() {
        return Stream.of(Arguments.of("apple", 8.9), Arguments.of("pear", 1.9));
    }
}
