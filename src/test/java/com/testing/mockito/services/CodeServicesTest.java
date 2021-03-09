package com.testing.mockito.services;

import com.testing.mockito.config.ReplaceGenerator;
import com.testing.mockito.exceptions.CustomException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Code Service")
public class CodeServicesTest {

    @InjectMocks
    private CodeServices codeServices;

    @Test
    @Tag("smokeTest")
    public void junitWorks(){
        assertTrue(true);
    }

    @Disabled("Duplicated test")
    @Test
    @Tag("smokeTest")
    public void junitWorksAssertFalse(){
        assertFalse(false);
    }

    @Nested
    @DisplayNameGeneration(ReplaceGenerator.ReplaceCamelCase.class)
    @Tag("checkCode")
    class methodCheckCode {

        @ParameterizedTest(name = "For example, code {0} ")
        @ValueSource(strings = {"123", "111", "1238", "8112", "8891"})
        void shouldReturnTrueWhenCodeIsOnlyNumbers(String number) throws CustomException {

            boolean expected = codeServices.checkCode(number);
            assertTrue(expected);
        }

        @ParameterizedTest(name = "For example, code {0} ")
        @ValueSource(strings = {"-123", "-111", "-1238", "-8112", "-8801"})
        void shouldThrowCustomExceptionWhenCodeHaveNegativeNumbers(String number) throws CustomException {

            Assertions.assertThrows(CustomException.class, () -> {
                codeServices.checkCode(number);
            });
        }

        @ParameterizedTest(name = "For example, code {0} ")
        @ValueSource(strings = {"-ad", "asd", "-´*[{sd", "-{-´+}", "-8bñ801"})
        void shouldThrowCustomExceptionWhenCodeHaveIncorrectCharacters(String number) throws CustomException {

            Assertions.assertThrows(CustomException.class, () -> {
                codeServices.checkCode(number);
            });
        }

        @ParameterizedTest(name = "For example, code {0} ")
        @ValueSource(strings = {"4240", "4534520", "540645", "30540", "024560"})
        void shouldThrowCustomExceptionWhenCodeHave0Character(String number) throws CustomException {

            Assertions.assertThrows(CustomException.class, () -> {
                codeServices.checkCode(number);
            });
        }

        @RepeatedTest(10)
        void shouldReturnTrueEveryTimeWhenCodeIts55() throws CustomException {
            String testNumber = "55";
            boolean expected = codeServices.checkCode(testNumber);
            assertTrue(expected);
        }

    }

}