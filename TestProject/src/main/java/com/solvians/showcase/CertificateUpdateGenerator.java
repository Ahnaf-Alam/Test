package com.solvians.showcase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class CertificateUpdateGenerator {
    private final int threads;
    private final int quotes;

    public CertificateUpdateGenerator(int threads, int quotes) {
        this.threads = threads;
        this.quotes = quotes;
    }

    public Stream<CertificateUpdate> generateQuotes() throws ExecutionException, InterruptedException {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        List<CertificateUpdate> updateList = new ArrayList<CertificateUpdate>();

        ExecutorService executorService = Executors.newFixedThreadPool(threads);

        for (int i = 0; i < threads; i++) {
            Future<String> certificateUpdateFuture = executorService.submit(updateCertificate());
        }

        return Stream.generate(CertificateUpdate::new).parallel().limit(quotes);
    }

    public CertificateGeneratorCallable updateCertificate() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        LocalDate currentDate = LocalDate.now();

        String isinString = getIisinGeneratorString();
        CertificateUpdate certificateUpdate = new CertificateUpdate();
        certificateUpdate.setISIN(isinString);
        certificateUpdate.ISINCheckDigit(isinString);
        certificateUpdate.updateISINWithCheckDigit();
        certificateUpdate.setBidPrice(random.nextDouble(100.0, 200.0));
        certificateUpdate.setBidSize(random.nextInt(1000, 5000));
        certificateUpdate.setAskPrice(random.nextDouble(100.0, 200.0));
        certificateUpdate.setAskPrice(random.nextInt(1000, 100000));
        certificateUpdate.setMaturityDate(currentDate);

        CertificateGeneratorCallable certificateGeneratorCallable = new CertificateGeneratorCallable(certificateUpdate);
        return  certificateGeneratorCallable;
    }

    private String getIisinGeneratorString() {
        ISINGenerator isinGenerator = new ISINGenerator();
        isinGenerator.generateISINString();

        return isinGenerator.getISIN();
    }
}
