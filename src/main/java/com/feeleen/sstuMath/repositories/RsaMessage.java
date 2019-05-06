package com.feeleen.sstuMath.repositories;

import java.security.PrivateKey;
import java.security.PublicKey;

public class RsaMessage {

    private String message;

    private PublicKey publicKey;

    private PrivateKey privateKey;

    private String signature;

    public RsaMessage() {
    }

    public RsaMessage(String message, PublicKey publicKey) {
        this.message = message;
        this.publicKey = publicKey;
    }

    public RsaMessage(String message, PublicKey publicKey, PrivateKey privateKey) {
        this.message = message;
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
