/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0</a>, using an XML
 * Schema.
 * $Id$
 */

package org.light.portal.layout.config;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class PortalUser.
 * 
 * @version $Revision$ $Date$
 */
public class PortalUser implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _user
     */
    private java.lang.String _user;

    /**
     * Field _role
     */
    private java.lang.String _role;

    /**
     * Field _portalTabList
     */
    private java.util.Vector _portalTabList;


      //----------------/
     //- Constructors -/
    //----------------/

    public PortalUser() 
     {
        super();
        _portalTabList = new Vector();
    } //-- org.light.portal.layout.config.PortalUser()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addPortalTab
     * 
     * 
     * 
     * @param vPortalTab
     */
    public void addPortalTab(org.light.portal.layout.config.PortalTab vPortalTab)
        throws java.lang.IndexOutOfBoundsException
    {
        _portalTabList.addElement(vPortalTab);
    } //-- void addPortalTab(org.light.portal.layout.config.PortalTab) 

    /**
     * Method addPortalTab
     * 
     * 
     * 
     * @param index
     * @param vPortalTab
     */
    public void addPortalTab(int index, org.light.portal.layout.config.PortalTab vPortalTab)
        throws java.lang.IndexOutOfBoundsException
    {
        _portalTabList.insertElementAt(vPortalTab, index);
    } //-- void addPortalTab(int, org.light.portal.layout.config.PortalTab) 

    /**
     * Method enumeratePortalTab
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumeratePortalTab()
    {
        return _portalTabList.elements();
    } //-- java.util.Enumeration enumeratePortalTab() 

    /**
     * Method getPortalTab
     * 
     * 
     * 
     * @param index
     * @return PortalTab
     */
    public org.light.portal.layout.config.PortalTab getPortalTab(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _portalTabList.size())) {
            throw new IndexOutOfBoundsException("getPortalTab: Index value '"+index+"' not in range [0.."+(_portalTabList.size() - 1) + "]");
        }
        
        return (org.light.portal.layout.config.PortalTab) _portalTabList.elementAt(index);
    } //-- org.light.portal.layout.config.PortalTab getPortalTab(int) 

    /**
     * Method getPortalTab
     * 
     * 
     * 
     * @return PortalTab
     */
    public org.light.portal.layout.config.PortalTab[] getPortalTab()
    {
        int size = _portalTabList.size();
        org.light.portal.layout.config.PortalTab[] mArray = new org.light.portal.layout.config.PortalTab[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (org.light.portal.layout.config.PortalTab) _portalTabList.elementAt(index);
        }
        return mArray;
    } //-- org.light.portal.layout.config.PortalTab[] getPortalTab() 

    /**
     * Method getPortalTabCount
     * 
     * 
     * 
     * @return int
     */
    public int getPortalTabCount()
    {
        return _portalTabList.size();
    } //-- int getPortalTabCount() 

    /**
     * Returns the value of field 'role'.
     * 
     * @return String
     * @return the value of field 'role'.
     */
    public java.lang.String getRole()
    {
        return this._role;
    } //-- java.lang.String getRole() 

    /**
     * Returns the value of field 'user'.
     * 
     * @return String
     * @return the value of field 'user'.
     */
    public java.lang.String getUser()
    {
        return this._user;
    } //-- java.lang.String getUser() 

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
     * Method removeAllPortalTab
     * 
     */
    public void removeAllPortalTab()
    {
        _portalTabList.removeAllElements();
    } //-- void removeAllPortalTab() 

    /**
     * Method removePortalTab
     * 
     * 
     * 
     * @param index
     * @return PortalTab
     */
    public org.light.portal.layout.config.PortalTab removePortalTab(int index)
    {
        java.lang.Object obj = _portalTabList.elementAt(index);
        _portalTabList.removeElementAt(index);
        return (org.light.portal.layout.config.PortalTab) obj;
    } //-- org.light.portal.layout.config.PortalTab removePortalTab(int) 

    /**
     * Method setPortalTab
     * 
     * 
     * 
     * @param index
     * @param vPortalTab
     */
    public void setPortalTab(int index, org.light.portal.layout.config.PortalTab vPortalTab)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _portalTabList.size())) {
            throw new IndexOutOfBoundsException("setPortalTab: Index value '"+index+"' not in range [0.." + (_portalTabList.size() - 1) + "]");
        }
        _portalTabList.setElementAt(vPortalTab, index);
    } //-- void setPortalTab(int, org.light.portal.layout.config.PortalTab) 

    /**
     * Method setPortalTab
     * 
     * 
     * 
     * @param portalTabArray
     */
    public void setPortalTab(org.light.portal.layout.config.PortalTab[] portalTabArray)
    {
        //-- copy array
        _portalTabList.removeAllElements();
        for (int i = 0; i < portalTabArray.length; i++) {
            _portalTabList.addElement(portalTabArray[i]);
        }
    } //-- void setPortalTab(org.light.portal.layout.config.PortalTab) 

    /**
     * Sets the value of field 'role'.
     * 
     * @param role the value of field 'role'.
     */
    public void setRole(java.lang.String role)
    {
        this._role = role;
    } //-- void setRole(java.lang.String) 

    /**
     * Sets the value of field 'user'.
     * 
     * @param user the value of field 'user'.
     */
    public void setUser(java.lang.String user)
    {
        this._user = user;
    } //-- void setUser(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return PortalUser
     */
    public static org.light.portal.layout.config.PortalUser unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.light.portal.layout.config.PortalUser) Unmarshaller.unmarshal(org.light.portal.layout.config.PortalUser.class, reader);
    } //-- org.light.portal.layout.config.PortalUser unmarshal(java.io.Reader) 

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
