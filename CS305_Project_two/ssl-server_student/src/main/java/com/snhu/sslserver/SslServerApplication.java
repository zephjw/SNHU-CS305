package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class SslServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SslServerApplication.class, args);
    }

}

@RestController
class SslServerController {

    @RequestMapping("/hash")
    public String myHash (String data) throws NoSuchAlgorithmException {
        data = "Hello world checksum!";
        String name = "John Zephyr";

        String [ ] splitname = name.split(" ");
        String firstName = splitname[0];
        String lastName = splitname[splitname.length - 1];

        if (splitname.length > 1) {

            name = firstName + " " + lastName;
        }

        MessageDigest md = MessageDigest.getInstance ("SHA-256");
        byte[] shavalue = md.digest(name.getBytes ( StandardCharsets.UTF_8 ));

        StringBuilder response = new StringBuilder();
        response.append ("Data: ").append (data).append ("</br></br>");
        response.append ("Name: ").append (name).append ("</br></br>");
        response.append ("Name of algorithm used: SHA-256 Checksum value: ").append (bytesToHex (shavalue));

        return response.toString();
    }

    public static String bytesToHex(byte[] sha256) {
        BigInteger hex =new BigInteger (1, sha256);
        StringBuilder checksum = new StringBuilder (hex.toString (16));

        while (checksum.length () < 32) {

            checksum.insert (0, '0');
        }
        return checksum.toString ();
    }

}
//FIXME: Add route to enable check sum return of static data example:  String data = "Hello World Check Sum!";