package com.minotore.SpringBootMySql.Tools.Crypto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CryptoController {

    @GetMapping("/crypto/md5/{iterations}")
    @ResponseBody
    public String hashMd5(@PathVariable int iterations) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            CryptoService.hashMd5(CryptoService.SAMPLE_TEXT);
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        return "MD5 hashing completed " + iterations + " times.\nTime taken (ms): " + duration;
    }

    @GetMapping("/crypto/sha256/{iterations}")
    @ResponseBody
    public String hashSha256(@PathVariable int iterations) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            CryptoService.hashSha256(CryptoService.SAMPLE_TEXT);
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        return "SHA-256 hashing completed " + iterations + " times.\nTime taken (ms): " + duration;
    }
}
