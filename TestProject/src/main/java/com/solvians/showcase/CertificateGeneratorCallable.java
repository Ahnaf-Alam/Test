package com.solvians.showcase;

import java.util.concurrent.Callable;

public class CertificateGeneratorCallable implements Callable<String> {

    private com.solvians.showcase.CertificateUpdate certificateUpdate;
    public CertificateGeneratorCallable(com.solvians.showcase.CertificateUpdate certificateUpdate) {
        this.certificateUpdate = certificateUpdate;
    }
    @Override
    public String call() throws Exception {
        String value = this.getValue();
        System.out.println("Thread name: " + Thread.currentThread().getName() + " value: " + value);

        return value;
    }

    private String getValue() {
        return certificateUpdate.getISIN() + ", " +
                certificateUpdate.getBidPrice() + ", " +
                certificateUpdate.getBidSize() + ", " +
                certificateUpdate.getAskPrice() + ", " +
                certificateUpdate.getAskSize() + ", " +
                certificateUpdate.getMaturityDate();
    }
}
