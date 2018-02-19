package br.com.harpalab.getip.remote;

import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.harpalab.getip.domain.ClientIpInfo;
import br.com.harpalab.getip.domain.VerificationCode;
import br.com.harpalab.getip.util.GetIpProperties;

public class GetCodeRemoteService {

    public VerificationCode getCode(ClientIpInfo ipInfo) {
        try {
            Gson gson = new Gson();
            String ipInfoJSON = gson.toJson(ipInfo);

            Client client = Client.create();
            WebResource webResource = client.resource(GetIpProperties.getServiceGetCodeUri());
            ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, ipInfoJSON);
            if (response.getStatus() == 200) {
                String codeJSON = response.getEntity(String.class);
                VerificationCode code = gson.fromJson(codeJSON, VerificationCode.class);
                return code;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}