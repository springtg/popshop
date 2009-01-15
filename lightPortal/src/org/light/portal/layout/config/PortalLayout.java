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
 * Class PortalLayout.
 * 
 * @version $Revision$ $Date$
 */
public class PortalLayout implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _portalUserList
     */
    private java.util.Vector _portalUserList;


      //----------------/
     //- Constructors -/
    //----------------/

    public PortalLayout() 
     {
        super();
        _portalUserList = new Vector();
    } //-- org.light.portal.layout.config.PortalLayout()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addPortalUser
     * 
     * 
     * 
     * @param vPortalUser
     */
    public void addPortalUser(org.light.portal.layout.config.PortalUser vPortalUser)
        throws java.lang.IndexOutOfBoundsException
    {
        _portalUserList.addElement(vPortalUser);
    } //-- void addPortalUser(org.light.portal.layout.config.PortalUser) 

    /**
     * Method addPortalUser
     * 
     * 
     * 
     * @param index
     * @param vPortalUser
     */
    public void addPortalUser(int index, org.light.portal.layout.config.PortalUser vPortalUser)
        throws java.lang.IndexOutOfBoundsException
    {
        _portalUserList.insertElementAt(vPortalUser, index);
    } //-- void addPortalUser(int, org.light.portal.layout.config.PortalUser) 

    /**
     * Method enumeratePortalUser
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumeratePortalUser()
    {
        return _portalUserList.elements();
    } //-- java.util.Enumeration enumeratePortalUser() 

    /**
     * Method getPortalUser
     * 
     * 
     * 
     * @param index
     * @return PortalUser
     */
    public org.light.portal.layout.config.PortalUser getPortalUser(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _portalUserList.size())) {
            throw new IndexOutOfBoundsException("getPortalUser: Index value '"+index+"' not in range [0.."+(_portalUserList.size() - 1) + "]");
        }
        
        return (org.light.portal.layout.config.PortalUser) _portalUserList.elementAt(index);
    } //-- org.light.portal.layout.config.PortalUser getPortalUser(int) 

    /**
     * Method getPortalUser
     * 
     * 
     * 
     * @return PortalUser
     */
    public org.light.portal.layout.config.PortalUser[] getPortalUser()
    {
        int size = _portalUserList.size();
        org.light.portal.layout.config.PortalUser[] mArray = new org.light.portal.layout.config.PortalUser[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (org.light.portal.layout.config.PortalUser) _portalUserList.elementAt(index);
        }
        return mArray;
    } //-- org.light.portal.layout.config.PortalUser[] getPortalUser() 

    /**
     * Method getPortalUserCount
     * 
     * 
     * 
     * @return int
     */
    public int getPortalUserCount()
    {
        return _portalUserList.size();
    } //-- int getPortalUserCount() 

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
     * Method removeAllPortalUser
     * 
     */
    public void removeAllPortalUser()
    {
        _portalUserList.removeAllElements();
    } //-- void removeAllPortalUser() 

    /**
     * Method removePortalUser
     * 
     * 
     * 
     * @param index
     * @return PortalUser
     */
    public org.light.portal.layout.config.PortalUser removePortalUser(int index)
    {
        java.lang.Object obj = _portalUserList.elementAt(index);
        _portalUserList.removeElementAt(index);
        return (org.light.portal.layout.config.PortalUser) obj;
    } //-- org.light.portal.layout.config.PortalUser removePortalUser(int) 

    /**
     * Method setPortalUser
     * 
     * 
     * 
     * @param index
     * @param vPortalUser
     */
    public void setPortalUser(int index, org.light.portal.layout.config.PortalUser vPortalUser)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _portalUserList.size())) {
            throw new IndexOutOfBoundsException("setPortalUser: Index value '"+index+"' not in range [0.." + (_portalUserList.size() - 1) + "]");
        }
        _portalUserList.setElementAt(vPortalUser, index);
    } //-- void setPortalUser(int, org.light.portal.layout.config.PortalUser) 

    /**
     * Method setPortalUser
     * 
     * 
     * 
     * @param portalUserArray
     */
    public void setPortalUser(org.light.portal.layout.config.PortalUser[] portalUserArray)
    {
        //-- copy array
        _portalUserList.removeAllElements();
        for (int i = 0; i < portalUserArray.length; i++) {
            _portalUserList.addElement(portalUserArray[i]);
        }
    } //-- void setPortalUser(org.light.portal.layout.config.PortalUser) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return PortalLayout
     */
    public static org.light.portal.layout.config.PortalLayout unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.light.portal.layout.config.PortalLayout) Unmarshaller.unmarshal(org.light.portal.layout.config.PortalLayout.class, reader);
    } //-- org.light.portal.layout.config.PortalLayout unmarshal(java.io.Reader) 

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
