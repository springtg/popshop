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
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * The description element is used to provide text describing the 
 *  parent element. The description element should include any 
 *  information that the portlet application war file producer
 * wants
 *  to provide to the consumer of the portlet application war file 
 *  (i.e., to the Deployer). Typically, the tools used by the 
 *  portlet application war file consumer will display the 
 *  description when processing the parent element that contains
 * the 
 *  description. It has an optional attribute xml:lang to indicate 
 *  which language is used in the description according to 
 *  RFC 1766 (http://www.ietf.org/rfc/rfc1766.txt). The default
 *  value of this attribute is English(“en�?).
 *  Used in: init-param, portlet, portlet-app, security-role
 *  
 * 
 * @version $Revision$ $Date$
 */
public class DescriptionType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * internal content storage
     */
    private java.lang.String _content = "";

    /**
     * Attempting to install the relevant ISO 2- and 3-letter
     *  codes as the enumerated possible values is probably never
     *  going to be a realistic possibility. See
     *  RFC 3066 at http://www.ietf.org/rfc/rfc3066.txt and the
     * IANA registry
     *  at http://www.iana.org/assignments/lang-tag-apps.htm for
     *  further information.
     * 
     *  The union allows for the 'un-declaration' of xml:lang with
     *  the empty string.
     */
    private java.lang.Object _lang;


      //----------------/
     //- Constructors -/
    //----------------/

    public DescriptionType() 
     {
        super();
        setContent("");
    } //-- org.light.portlet.definition.DescriptionType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'content'. The field 'content'
     * has the following description: internal content storage
     * 
     * @return String
     * @return the value of field 'content'.
     */
    public java.lang.String getContent()
    {
        return this._content;
    } //-- java.lang.String getContent() 

    /**
     * Returns the value of field 'lang'. The field 'lang' has the
     * following description: Attempting to install the relevant
     * ISO 2- and 3-letter
     *  codes as the enumerated possible values is probably never
     *  going to be a realistic possibility. See
     *  RFC 3066 at http://www.ietf.org/rfc/rfc3066.txt and the
     * IANA registry
     *  at http://www.iana.org/assignments/lang-tag-apps.htm for
     *  further information.
     * 
     *  The union allows for the 'un-declaration' of xml:lang with
     *  the empty string.
     * 
     * @return Object
     * @return the value of field 'lang'.
     */
    public java.lang.Object getLang()
    {
        return this._lang;
    } //-- java.lang.Object getLang() 

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
    public void setContent(java.lang.String content)
    {
        this._content = content;
    } //-- void setContent(java.lang.String) 

    /**
     * Sets the value of field 'lang'. The field 'lang' has the
     * following description: Attempting to install the relevant
     * ISO 2- and 3-letter
     *  codes as the enumerated possible values is probably never
     *  going to be a realistic possibility. See
     *  RFC 3066 at http://www.ietf.org/rfc/rfc3066.txt and the
     * IANA registry
     *  at http://www.iana.org/assignments/lang-tag-apps.htm for
     *  further information.
     * 
     *  The union allows for the 'un-declaration' of xml:lang with
     *  the empty string.
     * 
     * @param lang the value of field 'lang'.
     */
    public void setLang(java.lang.Object lang)
    {
        this._lang = lang;
    } //-- void setLang(java.lang.Object) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return DescriptionType
     */
    public static org.light.portal.portlet.definition.DescriptionType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.light.portal.portlet.definition.DescriptionType) Unmarshaller.unmarshal(org.light.portal.portlet.definition.DescriptionType.class, reader);
    } //-- org.light.portlet.definition.DescriptionType unmarshal(java.io.Reader) 

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
