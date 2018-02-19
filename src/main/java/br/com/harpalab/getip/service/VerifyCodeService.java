package br.com.harpalab.getip.service;

import br.com.harpalab.getip.domain.ClientIpInfo;
import br.com.harpalab.getip.domain.VerificationResult;
import br.com.harpalab.getip.domain.VerificationStatusEnum;
import br.com.harpalab.getip.util.CodeGenerationUtil;

public class VerifyCodeService {

    public VerificationResult verifyCode(ClientIpInfo ipInfo) {
        VerificationResult result = new VerificationResult();
        if (ipInfo.getVerify() != null && ipInfo.getVerify().getCode() != null && !ipInfo.getVerify().getCode().isEmpty()
            && CodeGenerationUtil.VERSION_V1.equals(ipInfo.getVerify().getVersion())) {
            return verifyCodeV1(result, ipInfo);
        } else {
            return VerificationStatusEnum.WARN.setVerificationResult(result);
        }
    }

    private VerificationResult verifyCodeV1(VerificationResult result, ClientIpInfo ipInfo) {
        String codeGenerationKey = CodeGenerationUtil.getIpAndInfoCodeGenerationKey(ipInfo);
        String decodedVerifyCode = CodeGenerationUtil.decodeV1(ipInfo.getVerify().getCode());
        if (codeGenerationKey.equals(decodedVerifyCode)) {
            return VerificationStatusEnum.OK.setVerificationResult(result);
        } else {
            return VerificationStatusEnum.ERROR.setVerificationResult(result);
        }
    }
}