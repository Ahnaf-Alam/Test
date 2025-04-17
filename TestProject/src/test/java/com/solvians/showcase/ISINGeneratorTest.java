package com.solvians.showcase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ISINGeneratorTest {

    @Test
    public void generateISINStringTest() {

        ISINGenerator isinGenerator = new ISINGenerator();
        String result = isinGenerator.generateISINString();

        assertNotNull(result);
        assertEquals(result.length(), 11);
    }

}
