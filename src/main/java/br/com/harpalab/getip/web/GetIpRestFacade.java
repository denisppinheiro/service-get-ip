package br.com.harpalab.getip.web;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import javax.servlet.http.HttpServletRequest;

import br.com.harpalab.getip.domain.ClientIpInfo;
import br.com.harpalab.getip.service.GetIpService;

@Path("/get-ip")
public class GetIpRestFacade {
    @Inject
    private GetIpService getIpService;

    @GET
    @Path("/")
    @Produces({ "application/json" })
    public ClientIpInfo getIp(@Context HttpServletRequest request) {
        return getIpService.getIp(request);
    }


}
