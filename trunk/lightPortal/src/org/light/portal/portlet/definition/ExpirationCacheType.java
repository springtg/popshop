/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0</a>, using an XML
 * Schema.
 * $Id$
 */

package org.light.portal.portlet.definition;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.math.BigDecimal;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Expriation-cache defines expiration-based caching for this
 *  portlet. The parameter indicates
 *  the time in seconds after which the portlet output expires. 
 *  -1 indicates that the output never expires.
 *  Used in: portlet
 *  
 * 
 * @version $Revision$ $Date$
 */
public class ExpirationCacheType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * internal content storage
     */
    private java.math.BigDecimal _content;


      //----------------/
     //- Constructors -/
    //----------------/

    public ExpirationCacheType() 
     {
        super();
    } //-- org.light.portlet.definition.ExpirationCacheType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'content'. The field 'content'
     * has the following description: internal content storage
     * 
     * @return BigDecimal
     * @return the value of field 'content'.
     */
    public java.math.BigDecimal getContent()
    {
        return this._content;
    } //-- java.math.BigDecimal getContent() 

    /**
     * Method isValid
     * 
     * 
     * 
     * @return boolean
     */
    public boolean isValid()
    {
        try {
            validate();
        }
        catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    } //-- boolean isValid() 

    /**
     * Method marshal
     * 
     * 
     * 
     * @param out
     */
    public void marshal(java.io.Writer out)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, out);
    } //-- void marshal(java.io.Writer) 

    /**
     * Method marshal
     * 
     * 
     * 
     * @param handler
     */
    public void marshal(org.xml.sax.ContentHandler handler)
        throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, handler);
    } //-- void marshal(org.xml.sax.ContentHandler) 

    /**
     * Sets the value of field 'content'. The field 'content' has
     * the following description: internal content storage
     * 
     * @param content the value of field 'content'.
     */
    public void setContent(java.math.BigDecimal content)
    {
        this._content = content;
    } //-- void setContent(java.math.BigDecimal) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return ExpirationCacheType
     */
    public static org.light.portal.portlet.definition.ExpirationCacheType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.light.portal.portlet.definition.ExpirationCacheType) Unmarshaller.unmarshal(org.light.portal.portlet.definition.ExpirationCacheType.class, reader);
    } //-- org.light.portlet.definition.ExpirationCacheType unmarshal(java.io.Reader) 

    /**
     * Method validate
     * 
     */
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
