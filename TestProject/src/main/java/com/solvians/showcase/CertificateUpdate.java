package com.solvians.showcase;


import java.time.LocalDate;


public class CertificateUpdate {

    public static final int CONVERT_ALPHA_CONSTANT = 55;

    private String timeStamp;
    private String ISIN;
    private double bidPrice;
    private int bidSize;
    private double askPrice;
    private int askSize;
    private LocalDate maturityDate;

    private int checkDigit;

    public int ISINCheckDigit(String isinString) {
        String nums = convertStringToNumber(isinString);
        nums = convertByMultiplication(nums);
        int sum = addNumbers(nums);
        if(sum % 10 == 0) return 0;

        int d = (sum / 10) + 1;
        this.checkDigit = (d*10 - sum);
        return this.checkDigit;
    }

    private int addNumbers(String nums) {
        int num = 0;

        for(int i=0; i < nums.length(); i++) {
            char c = nums.charAt(i);
            num = num + (c - '0');
        }

        return num;
    }

    private String convertStringToNumber(String s) {
        StringBuffer nums = new StringBuffer();

        s.chars()
                .mapToObj(c -> (char) c)
                .forEach(c -> {
                    if(c >= 'A' && c <= 'Z') {
                        int value = (int) c - CONVERT_ALPHA_CONSTANT;
                        nums.append(String.valueOf(value));
                    } else {
                        nums.append(String.valueOf(c));
                    }
                });
        return nums.toString();
    }

    private String convertByMultiplication(String s) {
        StringBuilder sbReverse = new StringBuilder(s);
        sbReverse.reverse();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i < sbReverse.length(); i++) {
            char c = sbReverse.charAt(i);
            if(i%2 == 0) {
                int val = (c - '0') * 2;
                if (val > 9) {
                    sb.append(String.valueOf(val % 10));
                    sb.append(String.valueOf(val / 10));
                } else {
                    sb.append(String.valueOf(val));
                }
            } else sb.append(c);

        }

        sb.reverse();

        return sb.toString();
    }

    public void updateISINWithCheckDigit() {
        this.ISIN = this.ISIN + this.checkDigit;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getISIN() {
        return ISIN;
    }

    public void setISIN(String ISIN) {
        this.ISIN = ISIN;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public int getBidSize() {
        return bidSize;
    }

    public void setBidSize(int bidSize) {
        this.bidSize = bidSize;
    }

    public double getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(double askPrice) {
        this.askPrice = askPrice;
    }

    public int getAskSize() {
        return askSize;
    }

    public void setAskSize(int askSize) {
        this.askSize = askSize;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }
}
