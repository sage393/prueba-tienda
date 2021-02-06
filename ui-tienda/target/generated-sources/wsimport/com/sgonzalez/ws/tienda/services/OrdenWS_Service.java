
package com.sgonzalez.ws.tienda.services;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b14002
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "OrdenWS", targetNamespace = "http://services.tienda.ws.sgonzalez.com/", wsdlLocation = "file:/home/sam/NetBeansProjects/tienda/ui-tienda/src/main/resources/wsdl/OrdenWS.wsdl")
public class OrdenWS_Service
    extends Service
{

    private final static URL ORDENWS_WSDL_LOCATION;
    private final static WebServiceException ORDENWS_EXCEPTION;
    private final static QName ORDENWS_QNAME = new QName("http://services.tienda.ws.sgonzalez.com/", "OrdenWS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/home/sam/NetBeansProjects/tienda/ui-tienda/src/main/resources/wsdl/OrdenWS.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ORDENWS_WSDL_LOCATION = url;
        ORDENWS_EXCEPTION = e;
    }

    public OrdenWS_Service() {
        super(__getWsdlLocation(), ORDENWS_QNAME);
    }

    public OrdenWS_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), ORDENWS_QNAME, features);
    }

    public OrdenWS_Service(URL wsdlLocation) {
        super(wsdlLocation, ORDENWS_QNAME);
    }

    public OrdenWS_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ORDENWS_QNAME, features);
    }

    public OrdenWS_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public OrdenWS_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns OrdenWS
     */
    @WebEndpoint(name = "OrdenWSPort")
    public OrdenWS getOrdenWSPort() {
        return super.getPort(new QName("http://services.tienda.ws.sgonzalez.com/", "OrdenWSPort"), OrdenWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns OrdenWS
     */
    @WebEndpoint(name = "OrdenWSPort")
    public OrdenWS getOrdenWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://services.tienda.ws.sgonzalez.com/", "OrdenWSPort"), OrdenWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ORDENWS_EXCEPTION!= null) {
            throw ORDENWS_EXCEPTION;
        }
        return ORDENWS_WSDL_LOCATION;
    }

}
