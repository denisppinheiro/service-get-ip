package br.com.harpalab.getip.web;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;

import br.com.harpalab.getip.domain.ClientIpInfo;
import br.com.harpalab.getip.domain.VerificationResult;
import br.com.harpalab.getip.service.VerifyCodeService;

@Path("/verify")
public class VerifyCodeRestFacade {

    @Inject
    private VerifyCodeService verifyCodeService;

    @POST
    @Path("/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public VerificationResult verifyCode(ClientIpInfo ipInfo) {
        return verifyCodeService.verifyCode(ipInfo);
    }

}
