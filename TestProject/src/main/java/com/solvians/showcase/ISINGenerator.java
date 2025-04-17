package com.solvians.showcase;


import java.util.concurrent.ThreadLocalRandom;

public class ISINGenerator {

    private String ISIN;
    public ISINGenerator() {

    }

    public String generateISINString() {
        StringBuffer sb = new StringBuffer();
        sb.append(getRandomAlphaNumericString());
        sb.append(getRandomAlphaNumericValue(9));

        this.ISIN = sb.toString();
        return ISIN;
    }

    public String getRandomAlphaNumericString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getRandomChar());
        stringBuffer.append(getRandomChar());

        this.ISIN = stringBuffer.toString();

        return ISIN;
    }

    private char getRandomChar() {
        return (char) ThreadLocalRandom.current().nextInt('A', 'Z' + 1);
    }

    private String getRandomAlphaNumericValue(int length) {
        String alphaNum = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(length);

        for(int i=0; i < length; i++) {
            int idx = ThreadLocalRandom.current().nextInt(alphaNum.length());
            sb.append(alphaNum.charAt(idx));
        }

        return sb.toString();
    }

    public String getISIN() {
        return ISIN;
    }

    public void setISIN(String ISIN) {
        this.ISIN = ISIN;
    }
}
