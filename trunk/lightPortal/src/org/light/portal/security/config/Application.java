/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0</a>, using an XML
 * Schema.
 * $Id$
 */

package org.light.portal.security.config;

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
 * Class Application.
 * 
 * @version $Revision$ $Date$
 */
public class Application implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _defaultLocale
     */
    private java.lang.String _defaultLocale;

    /**
     * Field _allowChangeLocale
     */
    private boolean _allowChangeLocale;

    /**
     * keeps track of state for field: _allowChangeLocale
     */
    private boolean _has_allowChangeLocale;

    /**
     * Field _reCreateTable
     */
    private boolean _reCreateTable;

    /**
     * keeps track of state for field: _reCreateTable
     */
    private boolean _has_reCreateTable;


      //----------------/
     //- Constructors -/
    //----------------/

    public Application() 
     {
        super();
    } //-- org.light.portal.security.config.Application()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method deleteAllowChangeLocale
     * 
     */
    public void deleteAllowChangeLocale()
    {
        this._has_allowChangeLocale= false;
    } //-- void deleteAllowChangeLocale() 

    /**
     * Method deleteReCreateTable
     * 
     */
    public void deleteReCreateTable()
    {
        this._has_reCreateTable= false;
    } //-- void deleteReCreateTable() 

    /**
     * Returns the value of field 'allowChangeLocale'.
     * 
     * @return boolean
     * @return the value of field 'allowChangeLocale'.
     */
    public boolean getAllowChangeLocale()
    {
        return this._allowChangeLocale;
    } //-- boolean getAllowChangeLocale() 

    /**
     * Returns the value of field 'defaultLocale'.
     * 
     * @return String
     * @return the value of field 'defaultLocale'.
     */
    public java.lang.String getDefaultLocale()
    {
        return this._defaultLocale;
    } //-- java.lang.String getDefaultLocale() 

    /**
     * Returns the value of field 'reCreateTable'.
     * 
     * @return boolean
     * @return the value of field 'reCreateTable'.
     */
    public boolean getReCreateTable()
    {
        return this._reCreateTable;
    } //-- boolean getReCreateTable() 

    /**
     * Method hasAllowChangeLocale
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasAllowChangeLocale()
    {
        return this._has_allowChangeLocale;
    } //-- boolean hasAllowChangeLocale() 

    /**
     * Method hasReCreateTable
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasReCreateTable()
    {
        return this._has_reCreateTable;
    } //-- boolean hasReCreateTable() 

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
     * Sets the value of field 'allowChangeLocale'.
     * 
     * @param allowChangeLocale the value of field
     * 'allowChangeLocale'.
     */
    public void setAllowChangeLocale(boolean allowChangeLocale)
    {
        this._allowChangeLocale = allowChangeLocale;
        this._has_allowChangeLocale = true;
    } //-- void setAllowChangeLocale(boolean) 

    /**
     * Sets the value of field 'defaultLocale'.
     * 
     * @param defaultLocale the value of field 'defaultLocale'.
     */
    public void setDefaultLocale(java.lang.String defaultLocale)
    {
        this._defaultLocale = defaultLocale;
    } //-- void setDefaultLocale(java.lang.String) 

    /**
     * Sets the value of field 'reCreateTable'.
     * 
     * @param reCreateTable the value of field 'reCreateTable'.
     */
    public void setReCreateTable(boolean reCreateTable)
    {
        this._reCreateTable = reCreateTable;
        this._has_reCreateTable = true;
    } //-- void setReCreateTable(boolean) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Application
     */
    public static org.light.portal.security.config.Application unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.light.portal.security.config.Application) Unmarshaller.unmarshal(org.light.portal.security.config.Application.class, reader);
    } //-- org.light.portal.security.config.Application unmarshal(java.io.Reader) 

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
