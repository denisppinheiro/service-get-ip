package br.com.harpalab.getip.service;

import br.com.harpalab.getip.domain.ClientIpInfo;
import br.com.harpalab.getip.domain.VerificationCode;
import br.com.harpalab.getip.util.CodeGenerationUtil;

public class GetCodeService {

    public VerificationCode getCode(ClientIpInfo ipInfo) {
        return generateCodeV1(CodeGenerationUtil.getIpAndInfoCodeGenerationKey(ipInfo));
    }

    private VerificationCode generateCodeV1(String codeGenerationKey) {
        VerificationCode code = new VerificationCode();

        String generatedCodeV1 = CodeGenerationUtil.encodeV1(codeGenerationKey);

        code.setCode(generatedCodeV1);
        code.setVersion(CodeGenerationUtil.VERSION_V1);

        return code;
    }

    public ClientIpInfo decode(String version, String code) {
        String decodedIpInfo = null;
        if (code != null) {
            if (CodeGenerationUtil.VERSION_V1.equals(version)) {
                decodedIpInfo = CodeGenerationUtil.decodeV1(code);
            } else {
                decodedIpInfo = CodeGenerationUtil.decodeV1(code);
            }
        }
        ClientIpInfo clientIpInfo = CodeGenerationUtil.getIpAndInfoFromCode(decodedIpInfo);
        VerificationCode verify = new VerificationCode();
        verify.setCode(code);
        verify.setVersion(version);
        clientIpInfo.setVerify(verify);
        return clientIpInfo;
    }

}