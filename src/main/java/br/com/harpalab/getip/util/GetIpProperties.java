package br.com.harpalab.getip.util;

public final class GetIpProperties {

    private static final String SERVICE_GET_CODE_URI_PROPERTY = "getcode.rest.api.uri";
    private static final String SERVICE_GET_CODE_URI_DEFAULT_VALUE = "http://localhost:8080/service-get-ip/api/rs/get-code/";

    public static String getServiceGetCodeUri() {
        String serviceGetCodeUri = getSystemProperty(SERVICE_GET_CODE_URI_PROPERTY);
        if (serviceGetCodeUri == null) {
            serviceGetCodeUri = SERVICE_GET_CODE_URI_DEFAULT_VALUE;
        }
        return serviceGetCodeUri;
    }

    private static String getSystemProperty(String property) {
        return System.getProperty(property);
    }

}