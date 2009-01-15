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
 * Class Users.
 * 
 * @version $Revision$ $Date$
 */
public class Users implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _userList
     */
    private java.util.Vector _userList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Users() 
     {
        super();
        _userList = new Vector();
    } //-- org.light.portal.security.config.Users()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addUser
     * 
     * 
     * 
     * @param vUser
     */
    public void addUser(org.light.portal.security.config.User vUser)
        throws java.lang.IndexOutOfBoundsException
    {
        _userList.addElement(vUser);
    } //-- void addUser(org.light.portal.security.config.User) 

    /**
     * Method addUser
     * 
     * 
     * 
     * @param index
     * @param vUser
     */
    public void addUser(int index, org.light.portal.security.config.User vUser)
        throws java.lang.IndexOutOfBoundsException
    {
        _userList.insertElementAt(vUser, index);
    } //-- void addUser(int, org.light.portal.security.config.User) 

    /**
     * Method enumerateUser
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateUser()
    {
        return _userList.elements();
    } //-- java.util.Enumeration enumerateUser() 

    /**
     * Method getUser
     * 
     * 
     * 
     * @param index
     * @return User
     */
    public org.light.portal.security.config.User getUser(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _userList.size())) {
            throw new IndexOutOfBoundsException("getUser: Index value '"+index+"' not in range [0.."+(_userList.size() - 1) + "]");
        }
        
        return (org.light.portal.security.config.User) _userList.elementAt(index);
    } //-- org.light.portal.security.config.User getUser(int) 

    /**
     * Method getUser
     * 
     * 
     * 
     * @return User
     */
    public org.light.portal.security.config.User[] getUser()
    {
        int size = _userList.size();
        org.light.portal.security.config.User[] mArray = new org.light.portal.security.config.User[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (org.light.portal.security.config.User) _userList.elementAt(index);
        }
        return mArray;
    } //-- org.light.portal.security.config.User[] getUser() 

    /**
     * Method getUserCount
     * 
     * 
     * 
     * @return int
     */
    public int getUserCount()
    {
        return _userList.size();
    } //-- int getUserCount() 

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
     * Method removeAllUser
     * 
     */
    public void removeAllUser()
    {
        _userList.removeAllElements();
    } //-- void removeAllUser() 

    /**
     * Method removeUser
     * 
     * 
     * 
     * @param index
     * @return User
     */
    public org.light.portal.security.config.User removeUser(int index)
    {
        java.lang.Object obj = _userList.elementAt(index);
        _userList.removeElementAt(index);
        return (org.light.portal.security.config.User) obj;
    } //-- org.light.portal.security.config.User removeUser(int) 

    /**
     * Method setUser
     * 
     * 
     * 
     * @param index
     * @param vUser
     */
    public void setUser(int index, org.light.portal.security.config.User vUser)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index >= _userList.size())) {
            throw new IndexOutOfBoundsException("setUser: Index value '"+index+"' not in range [0.." + (_userList.size() - 1) + "]");
        }
        _userList.setElementAt(vUser, index);
    } //-- void setUser(int, org.light.portal.security.config.User) 

    /**
     * Method setUser
     * 
     * 
     * 
     * @param userArray
     */
    public void setUser(org.light.portal.security.config.User[] userArray)
    {
        //-- copy array
        _userList.removeAllElements();
        for (int i = 0; i < userArray.length; i++) {
            _userList.addElement(userArray[i]);
        }
    } //-- void setUser(org.light.portal.security.config.User) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Users
     */
    public static org.light.portal.security.config.Users unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.light.portal.security.config.Users) Unmarshaller.unmarshal(org.light.portal.security.config.Users.class, reader);
    } //-- org.light.portal.security.config.Users unmarshal(java.io.Reader) 

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
