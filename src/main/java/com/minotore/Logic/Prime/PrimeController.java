package com.minotore.Logic.Prime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;


@Controller
@RequestMapping("/prime")
@RestController
public class PrimeController {

    @GetMapping("/{n}")
    public ResponseEntity<?> getNthFibonacci(@PathVariable int n) {
        if (n > 1000000) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Cannot exceed the limit of 1 million");
        } else if (n < 0) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Cannot enter a negative number");
        } else {
            return ResponseEntity.ok(listNthPrimeNumbers(n));
        }
    }


    List<Long> listNthPrimeNumbers(int n) {
        List<Long> result = new ArrayList<Long>();

        Long pointer = 2L;

        while (result.size() < n) {
            if (isPrimeOptimized(pointer)) {
                result.add(pointer);
            }
            pointer++;
        }
        return result;
    }

    boolean isPrime(int n) {
        for (int i = 1; i < n; i++) {
            if (n % i != 0) return false;
        }
        return true;
    }

    boolean isPrimeOptimized(Long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) {
            return true;
        }
        for (int i = 1; i <= sqrt(n); i++) {
            if (n % i != 0) return false;
        }

        return true;
    }
}
