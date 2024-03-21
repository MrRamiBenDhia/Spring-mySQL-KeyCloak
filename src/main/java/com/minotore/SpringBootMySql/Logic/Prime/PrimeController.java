package com.minotore.SpringBootMySql.Logic.Prime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

@RestController
@RequestMapping("/prime")
public class PrimeController {

    @GetMapping("/{n}")
    public ResponseEntity<?> getNthPrimeNumbers(@PathVariable int n) {
        if (n > 1000000) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Cannot exceed the limit of 1 million");
        } else if (n < 0) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Cannot enter a negative number");
        } else {
            return ResponseEntity.ok(listNthPrimeNumbers(n));
        }
    }

    List<Long> listNthPrimeNumbers(int n) {
        List<Long> result = new ArrayList<>();

        long pointer = 2L;
        while (result.size() < n) {
            if (isPrimeOptimized(pointer)) {
                result.add(pointer);
            }
            pointer++;
        }
        return result;
    }

    boolean isPrimeOptimized(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;

        for (long i = 2; i <= sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
