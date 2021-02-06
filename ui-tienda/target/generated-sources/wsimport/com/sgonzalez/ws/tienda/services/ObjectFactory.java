
package com.sgonzalez.ws.tienda.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sgonzalez.ws.tienda.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ObtenerOrdenesResponse_QNAME = new QName("http://services.tienda.ws.sgonzalez.com/", "obtenerOrdenesResponse");
    private final static QName _AgregarOrden_QNAME = new QName("http://services.tienda.ws.sgonzalez.com/", "agregarOrden");
    private final static QName _ObtenerOrdenResponse_QNAME = new QName("http://services.tienda.ws.sgonzalez.com/", "obtenerOrdenResponse");
    private final static QName _EliminarOrdenResponse_QNAME = new QName("http://services.tienda.ws.sgonzalez.com/", "eliminarOrdenResponse");
    private final static QName _AgregarOrdenResponse_QNAME = new QName("http://services.tienda.ws.sgonzalez.com/", "agregarOrdenResponse");
    private final static QName _ObtenerOrdenes_QNAME = new QName("http://services.tienda.ws.sgonzalez.com/", "obtenerOrdenes");
    private final static QName _ObtenerOrden_QNAME = new QName("http://services.tienda.ws.sgonzalez.com/", "obtenerOrden");
    private final static QName _EliminarOrden_QNAME = new QName("http://services.tienda.ws.sgonzalez.com/", "eliminarOrden");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sgonzalez.ws.tienda.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObtenerOrden }
     * 
     */
    public ObtenerOrden createObtenerOrden() {
        return new ObtenerOrden();
    }

    /**
     * Create an instance of {@link EliminarOrden }
     * 
     */
    public EliminarOrden createEliminarOrden() {
        return new EliminarOrden();
    }

    /**
     * Create an instance of {@link ObtenerOrdenes }
     * 
     */
    public ObtenerOrdenes createObtenerOrdenes() {
        return new ObtenerOrdenes();
    }

    /**
     * Create an instance of {@link EliminarOrdenResponse }
     * 
     */
    public EliminarOrdenResponse createEliminarOrdenResponse() {
        return new EliminarOrdenResponse();
    }

    /**
     * Create an instance of {@link AgregarOrdenResponse }
     * 
     */
    public AgregarOrdenResponse createAgregarOrdenResponse() {
        return new AgregarOrdenResponse();
    }

    /**
     * Create an instance of {@link ObtenerOrdenResponse }
     * 
     */
    public ObtenerOrdenResponse createObtenerOrdenResponse() {
        return new ObtenerOrdenResponse();
    }

    /**
     * Create an instance of {@link ObtenerOrdenesResponse }
     * 
     */
    public ObtenerOrdenesResponse createObtenerOrdenesResponse() {
        return new ObtenerOrdenesResponse();
    }

    /**
     * Create an instance of {@link AgregarOrden }
     * 
     */
    public AgregarOrden createAgregarOrden() {
        return new AgregarOrden();
    }

    /**
     * Create an instance of {@link Cliente }
     * 
     */
    public Cliente createCliente() {
        return new Cliente();
    }

    /**
     * Create an instance of {@link Orden }
     * 
     */
    public Orden createOrden() {
        return new Orden();
    }

    /**
     * Create an instance of {@link Producto }
     * 
     */
    public Producto createProducto() {
        return new Producto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerOrdenesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.tienda.ws.sgonzalez.com/", name = "obtenerOrdenesResponse")
    public JAXBElement<ObtenerOrdenesResponse> createObtenerOrdenesResponse(ObtenerOrdenesResponse value) {
        return new JAXBElement<ObtenerOrdenesResponse>(_ObtenerOrdenesResponse_QNAME, ObtenerOrdenesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarOrden }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.tienda.ws.sgonzalez.com/", name = "agregarOrden")
    public JAXBElement<AgregarOrden> createAgregarOrden(AgregarOrden value) {
        return new JAXBElement<AgregarOrden>(_AgregarOrden_QNAME, AgregarOrden.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerOrdenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.tienda.ws.sgonzalez.com/", name = "obtenerOrdenResponse")
    public JAXBElement<ObtenerOrdenResponse> createObtenerOrdenResponse(ObtenerOrdenResponse value) {
        return new JAXBElement<ObtenerOrdenResponse>(_ObtenerOrdenResponse_QNAME, ObtenerOrdenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarOrdenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.tienda.ws.sgonzalez.com/", name = "eliminarOrdenResponse")
    public JAXBElement<EliminarOrdenResponse> createEliminarOrdenResponse(EliminarOrdenResponse value) {
        return new JAXBElement<EliminarOrdenResponse>(_EliminarOrdenResponse_QNAME, EliminarOrdenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarOrdenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.tienda.ws.sgonzalez.com/", name = "agregarOrdenResponse")
    public JAXBElement<AgregarOrdenResponse> createAgregarOrdenResponse(AgregarOrdenResponse value) {
        return new JAXBElement<AgregarOrdenResponse>(_AgregarOrdenResponse_QNAME, AgregarOrdenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerOrdenes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.tienda.ws.sgonzalez.com/", name = "obtenerOrdenes")
    public JAXBElement<ObtenerOrdenes> createObtenerOrdenes(ObtenerOrdenes value) {
        return new JAXBElement<ObtenerOrdenes>(_ObtenerOrdenes_QNAME, ObtenerOrdenes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerOrden }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.tienda.ws.sgonzalez.com/", name = "obtenerOrden")
    public JAXBElement<ObtenerOrden> createObtenerOrden(ObtenerOrden value) {
        return new JAXBElement<ObtenerOrden>(_ObtenerOrden_QNAME, ObtenerOrden.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarOrden }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.tienda.ws.sgonzalez.com/", name = "eliminarOrden")
    public JAXBElement<EliminarOrden> createEliminarOrden(EliminarOrden value) {
        return new JAXBElement<EliminarOrden>(_EliminarOrden_QNAME, EliminarOrden.class, null, value);
    }

}
