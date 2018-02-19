package br.com.harpalab.getip.web;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;

import br.com.harpalab.getip.domain.ClientIpInfo;
import br.com.harpalab.getip.domain.VerificationCode;
import br.com.harpalab.getip.service.GetCodeService;

@Path("/get-code")
public class GetCodeRestFacade {

    @Inject
    private GetCodeService getCodeService;

    @POST
    @Path("/")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public VerificationCode getCode(ClientIpInfo ipInfo) {
        return getCodeService.getCode(ipInfo);
    }

    @GET
    @Path("/decode/{version}/{code}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public ClientIpInfo decode(@PathParam("version") String version, @PathParam("code") String code) {
        return getCodeService.decode(version, code);
    }
}
