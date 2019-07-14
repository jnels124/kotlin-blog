package org.example.blog

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.time.LocalDateTime
import java.time.Month
import java.util.stream.Stream

class ExtensionsTests {
    //region LocalDateTime.format()
    private fun dateFormatCases() = Stream.of(
            Arguments.of(LocalDateTime.of(2019, Month.AUGUST, 15, 0, 0, 0), "2019-08-15 15th 2019"),
            Arguments.of(LocalDateTime.of(2019, Month.JUNE, 30, 0, 0, 0), "2019-06-30 30th 2019"),
            Arguments.of(LocalDateTime.of(2019, Month.JANUARY, 11, 0, 0, 0), "2019-01-11 11th 2019")
    )

    @ParameterizedTest
    @MethodSource("dateFormatCases")
    fun `given some date, expect format() to give the formatted string`(givenDate: LocalDateTime, expectedFormat: String) {
        assertThat(givenDate.format()).isEqualTo(expectedFormat)
    }
    //endregion

    //region String.toSlug()
    @ParameterizedTest
    @CsvSource(value = arrayOf("The  11th Doctor--- is the best Doctor!!!,the-11th-doctor-is-the-best-doctor-",
            "DiNoSAur$!@#In_SpaCe,dinosaur-in-space"))
    fun `given a String, expect toSlug() to give the formatted string`() {
        // given
        val givenString = "The 11th Doctor is the best Doctor!!!"
        val expectedString = "the-11th-doctor-is-the-best-doctor-"

        // expect
        assertThat(givenString.toSlug()).isEqualTo(expectedString)
    }
    //endregion
}