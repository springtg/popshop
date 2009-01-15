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
 * Class PortletTypeChoiceSequence.
 * 
 * @version $Revision$ $Date$
 */
public class PortletTypeChoiceSequence implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _resourceBundle
     */
    private org.light.portal.portlet.definition.ResourceBundle _resourceBundle;

    /**
     * Field _portletInfo
     */
    private org.light.portal.portlet.definition.PortletInfo _portletInfo;


      //----------------/
     //- Constructors -/
    //----------------/

    public PortletTypeChoiceSequence() 
     {
        super();
    } //-- org.light.portlet.definition.PortletTypeChoiceSequence()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'portletInfo'.
     * 
     * @return PortletInfo
     * @return the value of field 'portletInfo'.
     */
    public org.light.portal.portlet.definition.PortletInfo getPortletInfo()
    {
        return this._portletInfo;
    } //-- org.light.portlet.definition.PortletInfo getPortletInfo() 

    /**
     * Returns the value of field 'resourceBundle'.
     * 
     * @return ResourceBundle
     * @return the value of field 'resourceBundle'.
     */
    public org.light.portal.portlet.definition.ResourceBundle getResourceBundle()
    {
        return this._resourceBundle;
    } //-- org.light.portlet.definition.ResourceBundle getResourceBundle() 

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
     * Sets the value of field 'portletInfo'.
     * 
     * @param portletInfo the value of field 'portletInfo'.
     */
    public void setPortletInfo(org.light.portal.portlet.definition.PortletInfo portletInfo)
    {
        this._portletInfo = portletInfo;
    } //-- void setPortletInfo(org.light.portlet.definition.PortletInfo) 

    /**
     * Sets the value of field 'resourceBundle'.
     * 
     * @param resourceBundle the value of field 'resourceBundle'.
     */
    public void setResourceBundle(org.light.portal.portlet.definition.ResourceBundle resourceBundle)
    {
        this._resourceBundle = resourceBundle;
    } //-- void setResourceBundle(org.light.portlet.definition.ResourceBundle) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return PortletTypeChoiceSequence
     */
    public static org.light.portal.portlet.definition.PortletTypeChoiceSequence unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.light.portal.portlet.definition.PortletTypeChoiceSequence) Unmarshaller.unmarshal(org.light.portal.portlet.definition.PortletTypeChoiceSequence.class, reader);
    } //-- org.light.portlet.definition.PortletTypeChoiceSequence unmarshal(java.io.Reader) 

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
