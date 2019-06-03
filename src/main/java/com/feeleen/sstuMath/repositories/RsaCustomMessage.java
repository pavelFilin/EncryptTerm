package com.feeleen.sstuMath.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class RsaCustomMessage {
    private int p;
    private int q;
    private int n;
    private int d;
    private int e;

    private String text;
    private String encryptText;


    public RsaCustomMessage(int p, int q, int n, int d, int e, String text, String encryptText) {
        this.p = p;
        this.q = q;
        this.n = n;
        this.d = d;
        this.e = e;
        this.text = text;
        this.encryptText = encryptText;
    }

    public RsaCustomMessage() {
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getEncryptText() {
        return encryptText;
    }

    public void setEncryptText(String encryptText) {
        this.encryptText = encryptText;
    }
}
