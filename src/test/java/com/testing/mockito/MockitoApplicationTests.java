package com.testing.mockito;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("Default test cases")
class MockitoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("Junit Works")
    void junitWorks() {
        assertEquals(true, true);
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class A_year_is_not_supported {

        @Test
        void if_it_is_zero() {
        }

        @DisplayName("A negative value for year is not supported by the leap year computation.")
        @ParameterizedTest(name = "For example, year {0} is not supported.")
        @ValueSource(ints = { -1, -4 })
        void if_it_is_negative(int year) {
        }

    }



}
