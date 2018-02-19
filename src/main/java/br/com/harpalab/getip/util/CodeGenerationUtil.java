package br.com.harpalab.getip.util;

import br.com.harpalab.getip.domain.ClientIpInfo;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

public class CodeGenerationUtil {

    public static final String VERSION_V1 = "v1";

    private CodeGenerationUtil() {}

    public static String getIpAndInfoCodeGenerationKey(ClientIpInfo ipInfo) {
        String ipAndInfoCodeGenerationKey = ipInfo.getIp();
        for (String key : ipInfo.getInfo().keySet()) {
            ipAndInfoCodeGenerationKey += "_" + key + ":" + ipInfo.getInfo().get(key);
        }
        return ipAndInfoCodeGenerationKey;
    }

    public static ClientIpInfo getIpAndInfoFromCode(String code) {
        ClientIpInfo clientIpInfo = new ClientIpInfo();
        if (code != null) {
            String[] ipInfo = code.split("_");
            if (ipInfo.length > 0) {
                String ip = ipInfo[0];
                clientIpInfo.setIp(ip);
                Map<String, String> infoMap = new HashMap<>();
                for (int i=1; i<ipInfo.length; i++) {
                    String info = ipInfo[i];
                    String[] infoKeyValue = info.split(":");
                    String infoKey = infoKeyValue[0];
                    String infoValue = infoKeyValue[1];
                    infoMap.put(infoKey, infoValue);
                }
                clientIpInfo.setInfo(infoMap);
            }
        }
        return clientIpInfo;
    }

    public static String encodeV1(String code) {
        return new String(DatatypeConverter.printBase64Binary(code.getBytes()));
    }

    public static String decodeV1(String code) {
        return new String(DatatypeConverter.parseBase64Binary(code));
    }

}