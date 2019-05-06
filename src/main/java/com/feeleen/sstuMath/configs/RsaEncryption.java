package com.feeleen.sstuMath.configs;

import org.springframework.context.annotation.Configuration;

import javax.crypto.Cipher;
import java.security.*;

@Configuration
public class RsaEncryption {
    // generate public and private keys
    private Long Id;

    private KeyPair keyPair = buildKeyPair();
    private PublicKey pubKey = keyPair.getPublic();
    private PrivateKey privateKey = keyPair.getPrivate();

    public RsaEncryption() throws NoSuchAlgorithmException {
    }

    public KeyPair buildKeyPair() throws NoSuchAlgorithmException {
        final int keySize = 2048;
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(keySize);
        return keyPairGenerator.genKeyPair();
    }

    public PublicKey getPubKey() {
        return pubKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }
}
