package com.feeleen.sstuMath.controllers;

import com.feeleen.sstuMath.repositories.RsaCustomMessage;
import org.junit.Test;

import static org.junit.Assert.*;

public class RsaCustomEncryptionTest {

    @Test
    public void encrypt() throws Exception {
        String s = "abf";
        RsaCustomEncryption rsaCustomEncryption = new RsaCustomEncryption();
        RsaCustomMessage encrypt = rsaCustomEncryption.encrypt(s);
        System.out.println(encrypt.getEncryptText());
    }

    @Test
    public void decrypt() throws Exception {
        String s = "abf";
        RsaCustomEncryption rsaCustomEncryption = new RsaCustomEncryption();
        RsaCustomMessage encryptText = rsaCustomEncryption.encrypt(s);
        System.out.println(encryptText.getEncryptText());

        String decryptText = rsaCustomEncryption.decrypt(encryptText.getE(), encryptText.getN(), encryptText.getEncryptText());
        System.out.println(decryptText);
        assertEquals(s, decryptText);
    }
}