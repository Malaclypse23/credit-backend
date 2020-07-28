package de.thom.creditbackend;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

@Service
public class LoanService {

	public Payback calculateLoan(BigDecimal amount, BigDecimal interestRate, BigDecimal initial, Integer years) {
        BigDecimal zins0 = amount.multiply(new BigDecimal(interestRate.doubleValue() / 100));
        BigDecimal tilgung0 = amount.multiply(new BigDecimal(initial.doubleValue() / 100));
        BigDecimal annuitaet = zins0.add(tilgung0);
        BigDecimal monthlyPayment = annuitaet.divide(new BigDecimal(12), 2, RoundingMode.HALF_UP);

        Payback payback = new Payback(monthlyPayment);

        if (years == 0) {
            years = amount.divide(annuitaet, 0, RoundingMode.UP).intValue();
        }

        BigDecimal zins, tilgung, rest = amount, totalZins = BigDecimal.ZERO;
        boolean allPaid = false;

        for (int year = 1; year <= years && allPaid == false; year++) {
            if (year == 1) {
                tilgung = tilgung0;
                zins = zins0;
                rest = amount.subtract(tilgung).subtract(zins);
            } else {
                BigDecimal toPay = amount.subtract(new BigDecimal((year - 1) * annuitaet.doubleValue()));
                zins = toPay.multiply(new BigDecimal(interestRate.doubleValue() / 100));
                tilgung = annuitaet.subtract(zins);
                rest = toPay.subtract(tilgung).subtract(zins);
            }
            if (rest.compareTo(BigDecimal.ZERO) < 0) {
                allPaid = true;
                rest = BigDecimal.ZERO;

            }
            totalZins = totalZins.add(zins);
            payback.getRates().add(new Rate(year, zins, tilgung, rest));
        }
        payback.setTotalInterest(totalZins);
        payback.setLoan(amount.add(totalZins).subtract(rest));
        return payback;
    }

}
