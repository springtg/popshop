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
import java.util.Enumeration;
import java.util.Vector;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class PortalSecurity.
 * 
 * @version $Revision$ $Date$
 */
public class PortalSecurity implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _application
     */
    private org.light.portal.security.config.Application _application;

    /**
     * Field _roleList
     */
    private java.util.Vector _roleList;


      //----------------/
     //- Constructors -/
    //----------------/

    public PortalSecurity() 
     {
        super();
        _roleList = new Vector();
    } //-- org.light.portal.security.config.PortalSecurity()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addRole
     * 
     * 
     * 
     * @param vRole
     */
    public void addRole(org.light.portal.security.config.Role vRole)
        throws java.lang.IndexOutOfBoundsException
    {
        _roleList.addElement(vRole);
    } //-- void addRole(org.light.portal.security.config.Role) 

    /**
     * Method addRole
     * 
     * 
     * 
     * @param index
     * @param vRole
     */
    public void addRole(int index, org.light.portal.security.config.Role vRole)
        throws java.lang.IndexOutOfBoundsException
    {
        _roleList.insertElementAt(vRole, index);
    } //-- void addRole(int, org.light.portal.security.config.Role) 

    /**
     * Method enumerateRole
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateRole()
    {
        return _roleList.elements();
    } //-- java.util.Enumeration enumerateRole() 

    /**
     * Returns the value of field 'application'.
     * 
     * @return Application
     * @return the value of field 'application'.
     */
    public org.light.portal.security.config.Application getApplication()
    {
        return this._application;
    } //-- org.light.portal.security.config.Application getApplication() 

    /**
     * Method getRole
     * 
     * 
     * 
     * @param index
     * @return Role
     */
    public org.light.portal.security.config.Role getRole(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _roleList.size())) {
            throw new IndexOutOfBoundsException("getRole: Index value '"+index+"' not in range [0.."+(_roleList.size() - 1) + "]");
        }
        
        return (org.light.portal.security.config.Role) _roleList.elementAt(index);
    } //-- org.light.portal.security.config.Role getRole(int) 

    /**
     * Method getRole
     * 
     * 
     * 
     * @return Role
     */
    public org.light.portal.security.config.Role[] getRole()
    {
        int size = _roleList.size();
        org.light.portal.security.config.Role[] mArray = new org.light.portal.security.config.Role[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (org.light.portal.security.config.Role) _roleList.elementAt(index);
        }
        return mArray;
    } //-- org.light.portal.security.config.Role[] getRole() 

    /**
     * Method getRoleCount
     * 
     * 
     * 
     * @return int
     */
    public int getRoleCount()
    {
        return _roleList.size();
    } //-- int getRoleCount() 

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
     * Method removeAllRole
     * 
     */
    public void removeAllRole()
    {
        _roleList.removeAllElements();
    } //-- void removeAllRole() 

    /**
     * Method removeRole
     * 
     * 
     * 
     * @param index
     * @return Role
     */
    public org.light.portal.security.config.Role removeRole(int index)
    {
        java.lang.Object obj = _roleList.elementAt(index);
        _roleList.removeElementAt(index);
        return (org.light.portal.security.config.Role) obj;
    } //-- org.light.portal.security.config.Role removeRole(int) 

    /**
     * Sets the value of field 'application'.
     * 
     * @param application the value of field 'application'.
     */
    public void setApplication(org.light.portal.security.config.Application application)
    {
        this._application = application;
    } //-- void setApplication(org.light.portal.security.config.Application) 

    /**
     * Method setRole
     * 
     * 
     * 
     * @param index
     * @param vRole
     */
    public void setRole(int index, org.light.portal.security.config.Role vRole)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _roleList.size())) {
            throw new IndexOutOfBoundsException("setRole: Index value '"+index+"' not in range [0.." + (_roleList.size() - 1) + "]");
        }
        _roleList.setElementAt(vRole, index);
    } //-- void setRole(int, org.light.portal.security.config.Role) 

    /**
     * Method setRole
     * 
     * 
     * 
     * @param roleArray
     */
    public void setRole(org.light.portal.security.config.Role[] roleArray)
    {
        //-- copy array
        _roleList.removeAllElements();
        for (int i = 0; i < roleArray.length; i++) {
            _roleList.addElement(roleArray[i]);
        }
    } //-- void setRole(org.light.portal.security.config.Role) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return PortalSecurity
     */
    public static org.light.portal.security.config.PortalSecurity unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.light.portal.security.config.PortalSecurity) Unmarshaller.unmarshal(org.light.portal.security.config.PortalSecurity.class, reader);
    } //-- org.light.portal.security.config.PortalSecurity unmarshal(java.io.Reader) 

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
