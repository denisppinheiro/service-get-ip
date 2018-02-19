package br.com.harpalab.getip.domain;

public class VerificationCode {

    private String code;
    private String version;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return this.version;
    }

    @Override
    public String toString() {
        return "Verification Code: [ code: " + code + ", version: " + version + "]";
    }

}