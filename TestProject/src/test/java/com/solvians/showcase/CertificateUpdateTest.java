package com.solvians.showcase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CertificateUpdateTest {

    @Test
    public void generateCheckDigitTest() {
        String isinString = "DE123456789";
        CertificateUpdate certificateUpdate = new CertificateUpdate();

        int result = certificateUpdate.ISINCheckDigit(isinString);
        
        assertEquals(result, 6);
    }
}
