package com.example.plateGenerator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LicensePlateGeneratorUnitTest
{
	LicensePlateGenerator generator = new LicensePlateGenerator();

	static Stream<org.junit.jupiter.params.provider.Arguments> validPlates() {
		return Stream.of(
				org.junit.jupiter.params.provider.Arguments.of(0L, "000000"),
				org.junit.jupiter.params.provider.Arguments.of(1L, "000001"),
				org.junit.jupiter.params.provider.Arguments.of(35L, "00000Z"),
				org.junit.jupiter.params.provider.Arguments.of(36L, "000010"),
				org.junit.jupiter.params.provider.Arguments.of(1295L, "0000ZZ"),
				org.junit.jupiter.params.provider.Arguments.of(46655L, "000ZZZ"),
				org.junit.jupiter.params.provider.Arguments.of(2176782335L, "ZZZZZZ")
		);
	}

	@ParameterizedTest
	@MethodSource("validPlates")
	void testValidPlates(long index, String expected) {
		assertEquals(expected, generator.getPlateNumber(index));
	}

	@Test
	void testNegativeIndexThrowsException()
	{
		assertThrows(IllegalArgumentException.class, () -> generator.getPlateNumber(-1));
	}

	@Test
	void testIndexTooLargeThrowsException() {
		long tooLarge = (long) Math.pow(36, 6);
		assertThrows(IllegalArgumentException.class, () -> generator.getPlateNumber(tooLarge));
	}

}
