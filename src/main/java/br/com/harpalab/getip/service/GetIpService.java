package br.com.harpalab.getip.service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import java.util.Map;
import java.util.HashMap;

import br.com.harpalab.getip.domain.ClientIpInfo;
import br.com.harpalab.getip.remote.GetCodeRemoteService;


public class GetIpService {

    @Inject
    private GetCodeRemoteService getCodeService;

    public ClientIpInfo getIp(HttpServletRequest request) {
        ClientIpInfo ipInfo = new ClientIpInfo();
        ipInfo.setIp(getClientIp(request));
        ipInfo.setInfo(getInfo(request));
        // generate verification code
        ipInfo.setVerify(getCodeService.getCode(ipInfo));
        return ipInfo;
    }

    private String getClientIp(HttpServletRequest request) {

        String remoteAddr = "";
        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }
        return remoteAddr;
    }

    private Map<String, String> getInfo(HttpServletRequest request) {
        Map<String, String> info = new HashMap<String, String>();
        if (request != null) {
            info.put("user", request.getRemoteUser());
            info.put("host", request.getRemoteHost());
        }
        return info;
    }

}