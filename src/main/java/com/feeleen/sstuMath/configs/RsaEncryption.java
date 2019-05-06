package com.feeleen.sstuMath.configs;

import org.springframework.context.annotation.Configuration;

import javax.crypto.Cipher;
import java.security.*;

@Configuration
public class RsaEncryption {
    // generate public and private keys
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

    public byte[] encrypt(PrivateKey privateKey, String message) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        return cipher.doFinal(message.getBytes());
    }

    public byte[] decrypt(PublicKey publicKey, byte [] encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);

        return cipher.doFinal(encrypted);
    }

    public PublicKey getPubKey() {
        return pubKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

}
