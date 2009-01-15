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
import java.util.Enumeration;
import java.util.Vector;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * The security-role-ref element contains the declaration of a 
 *  security role reference in the code of the web application. The
 * 
 *  declaration consists of an optional description, the security 
 *  role name used in the code, and an optional link to a security 
 *  role. If the security role is not specified, the Deployer must 
 *  choose an appropriate security role.
 *  The value of the role name element must be the String used 
 *  as the parameter to the 
 *  EJBContext.isCallerInRole(String roleName) method
 *  or the HttpServletRequest.isUserInRole(String role) method.
 *  Used in: portlet
 *  
 * 
 * @version $Revision$ $Date$
 */
public class SecurityRoleRefType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _id
     */
    private java.lang.String _id;

    /**
     * Field _descriptionList
     */
    private java.util.Vector _descriptionList;

    /**
     * Field _roleName
     */
    private java.lang.String _roleName;

    /**
     * Field _roleLink
     */
    private org.light.portal.portlet.definition.RoleLink _roleLink;


      //----------------/
     //- Constructors -/
    //----------------/

    public SecurityRoleRefType() 
     {
        super();
        _descriptionList = new Vector();
    } //-- org.light.portlet.definition.SecurityRoleRefType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addDescription
     * 
     * 
     * 
     * @param vDescription
     */
    public void addDescription(org.light.portal.portlet.definition.Description vDescription)
        throws java.lang.IndexOutOfBoundsException
    {
        _descriptionList.addElement(vDescription);
    } //-- void addDescription(org.light.portlet.definition.Description) 

    /**
     * Method addDescription
     * 
     * 
     * 
     * @param index
     * @param vDescription
     */
    public void addDescription(int index, org.light.portal.portlet.definition.Description vDescription)
        throws java.lang.IndexOutOfBoundsException
    {
        _descriptionList.insertElementAt(vDescription, index);
    } //-- void addDescription(int, org.light.portlet.definition.Description) 

    /**
     * Method enumerateDescription
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateDescription()
    {
        return _descriptionList.elements();
    } //-- java.util.Enumeration enumerateDescription() 

    /**
     * Method getDescription
     * 
     * 
     * 
     * @param index
     * @return Description
     */
    public org.light.portal.portlet.definition.Description getDescription(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _descriptionList.size())) {
            throw new IndexOutOfBoundsException("getDescription: Index value '"+index+"' not in range [0.."+(_descriptionList.size() - 1) + "]");
        }
        
        return (org.light.portal.portlet.definition.Description) _descriptionList.elementAt(index);
    } //-- org.light.portlet.definition.Description getDescription(int) 

    /**
     * Method getDescription
     * 
     * 
     * 
     * @return Description
     */
    public org.light.portal.portlet.definition.Description[] getDescription()
    {
        int size = _descriptionList.size();
        org.light.portal.portlet.definition.Description[] mArray = new org.light.portal.portlet.definition.Description[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (org.light.portal.portlet.definition.Description) _descriptionList.elementAt(index);
        }
        return mArray;
    } //-- org.light.portlet.definition.Description[] getDescription() 

    /**
     * Method getDescriptionCount
     * 
     * 
     * 
     * @return int
     */
    public int getDescriptionCount()
    {
        return _descriptionList.size();
    } //-- int getDescriptionCount() 

    /**
     * Returns the value of field 'id'.
     * 
     * @return String
     * @return the value of field 'id'.
     */
    public java.lang.String getId()
    {
        return this._id;
    } //-- java.lang.String getId() 

    /**
     * Returns the value of field 'roleLink'.
     * 
     * @return RoleLink
     * @return the value of field 'roleLink'.
     */
    public org.light.portal.portlet.definition.RoleLink getRoleLink()
    {
        return this._roleLink;
    } //-- org.light.portlet.definition.RoleLink getRoleLink() 

    /**
     * Returns the value of field 'roleName'.
     * 
     * @return String
     * @return the value of field 'roleName'.
     */
    public java.lang.String getRoleName()
    {
        return this._roleName;
    } //-- java.lang.String getRoleName() 

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
     * Method removeAllDescription
     * 
     */
    public void removeAllDescription()
    {
        _descriptionList.removeAllElements();
    } //-- void removeAllDescription() 

    /**
     * Method removeDescription
     * 
     * 
     * 
     * @param index
     * @return Description
     */
    public org.light.portal.portlet.definition.Description removeDescription(int index)
    {
        java.lang.Object obj = _descriptionList.elementAt(index);
        _descriptionList.removeElementAt(index);
        return (org.light.portal.portlet.definition.Description) obj;
    } //-- org.light.portlet.definition.Description removeDescription(int) 

    /**
     * Method setDescription
     * 
     * 
     * 
     * @param index
     * @param vDescription
     */
    public void setDescription(int index, org.light.portal.portlet.definition.Description vDescription)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _descriptionList.size())) {
            throw new IndexOutOfBoundsException("setDescription: Index value '"+index+"' not in range [0.." + (_descriptionList.size() - 1) + "]");
        }
        _descriptionList.setElementAt(vDescription, index);
    } //-- void setDescription(int, org.light.portlet.definition.Description) 

    /**
     * Method setDescription
     * 
     * 
     * 
     * @param descriptionArray
     */
    public void setDescription(org.light.portal.portlet.definition.Description[] descriptionArray)
    {
        //-- copy array
        _descriptionList.removeAllElements();
        for (int i = 0; i < descriptionArray.length; i++) {
            _descriptionList.addElement(descriptionArray[i]);
        }
    } //-- void setDescription(org.light.portlet.definition.Description) 

    /**
     * Sets the value of field 'id'.
     * 
     * @param id the value of field 'id'.
     */
    public void setId(java.lang.String id)
    {
        this._id = id;
    } //-- void setId(java.lang.String) 

    /**
     * Sets the value of field 'roleLink'.
     * 
     * @param roleLink the value of field 'roleLink'.
     */
    public void setRoleLink(org.light.portal.portlet.definition.RoleLink roleLink)
    {
        this._roleLink = roleLink;
    } //-- void setRoleLink(org.light.portlet.definition.RoleLink) 

    /**
     * Sets the value of field 'roleName'.
     * 
     * @param roleName the value of field 'roleName'.
     */
    public void setRoleName(java.lang.String roleName)
    {
        this._roleName = roleName;
    } //-- void setRoleName(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return SecurityRoleRefType
     */
    public static org.light.portal.portlet.definition.SecurityRoleRefType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.light.portal.portlet.definition.SecurityRoleRefType) Unmarshaller.unmarshal(org.light.portal.portlet.definition.SecurityRoleRefType.class, reader);
    } //-- org.light.portlet.definition.SecurityRoleRefType unmarshal(java.io.Reader) 

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