package br.com.harpalab.getip.domain;

public class VerificationResult {

    private String status;
    private String message;

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Verification Result: [ status: " + status + ", message: " + message + "]";
    }

}