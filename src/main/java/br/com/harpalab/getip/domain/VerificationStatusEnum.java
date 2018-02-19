package br.com.harpalab.getip.domain;

public enum VerificationStatusEnum {

    OK("Code provided is correct!"),
    WARN("Code verification not provided or incorrect code version provided."),
    ERROR("Code provided is not correct!");

    private String message;

    VerificationStatusEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public VerificationResult setVerificationResult(VerificationResult result) {
        result.setStatus(this.name());
        result.setMessage(this.getMessage());
        return result;
    }

}