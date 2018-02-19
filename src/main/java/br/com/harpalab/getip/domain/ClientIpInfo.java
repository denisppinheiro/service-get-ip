package br.com.harpalab.getip.domain;

import java.util.Map;

public class ClientIpInfo {

    private String ip;
    private Map<String, String> info;
    private VerificationCode verify;

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(Map<String, String> info) {
        this.info = info;
    }

    /**
     * @return the info
     */
    public Map<String, String> getInfo() {
        return info;
    }

    /**
     * @param verify the verify to set
     */
    public void setVerify(VerificationCode verify) {
        this.verify = verify;
    }

    /**
     * @return the verify
     */
    public VerificationCode getVerify() {
        return verify;
    }

    @Override
    public String toString() {
        return "ClientIpInfo: [ ip: " + ip + ", info: " + info + ", verify: " + verify + "]";
    }
}