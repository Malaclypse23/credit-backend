package de.thom.creditbackend;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class LoanController {

    @Autowired
    private LoanService loanService;

    @RequestMapping("/calculate")
    public Payback calculate(@RequestParam @Min(1000) @Max(300000) @NumberFormat(pattern = "###.###,##") BigDecimal amount, 
    @RequestParam  @Min(1) @Max(25) @NumberFormat(pattern = "###.###,##") BigDecimal interest, 
    @RequestParam @Min(2) @Max(80) @NumberFormat(pattern = "###.###,##") BigDecimal initial, 
    @RequestParam @Min(0) @Max(30) Integer years) {
        return this.loanService.calculateLoan(amount, interest, initial, years);
	}
}