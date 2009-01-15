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
 * Class Role.
 * 
 * @version $Revision$ $Date$
 */
public class Role implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * Field _allowLookAndFeel
     */
    private boolean _allowLookAndFeel;

    /**
     * keeps track of state for field: _allowLookAndFeel
     */
    private boolean _has_allowLookAndFeel;

    /**
     * Field _allowLayout
     */
    private boolean _allowLayout;

    /**
     * keeps track of state for field: _allowLayout
     */
    private boolean _has_allowLayout;

    /**
     * Field _allowAddTab
     */
    private boolean _allowAddTab;

    /**
     * keeps track of state for field: _allowAddTab
     */
    private boolean _has_allowAddTab;

    /**
     * Field _allowAddContent
     */
    private boolean _allowAddContent;

    /**
     * keeps track of state for field: _allowAddContent
     */
    private boolean _has_allowAddContent;

    /**
     * Field _allowSignIn
     */
    private boolean _allowSignIn;

    /**
     * keeps track of state for field: _allowSignIn
     */
    private boolean _has_allowSignIn;

    /**
     * Field _allowTurnOff
     */
    private boolean _allowTurnOff;

    /**
     * keeps track of state for field: _allowTurnOff
     */
    private boolean _has_allowTurnOff;

    /**
     * Field _title
     */
    private java.lang.String _title;

    /**
     * Field _theme
     */
    private java.lang.String _theme;

    /**
     * Field _users
     */
    private org.light.portal.security.config.Users _users;


      //----------------/
     //- Constructors -/
    //----------------/

    public Role() 
     {
        super();
    } //-- org.light.portal.security.config.Role()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method deleteAllowAddContent
     * 
     */
    public void deleteAllowAddContent()
    {
        this._has_allowAddContent= false;
    } //-- void deleteAllowAddContent() 

    /**
     * Method deleteAllowAddTab
     * 
     */
    public void deleteAllowAddTab()
    {
        this._has_allowAddTab= false;
    } //-- void deleteAllowAddTab() 

    /**
     * Method deleteAllowLayout
     * 
     */
    public void deleteAllowLayout()
    {
        this._has_allowLayout= false;
    } //-- void deleteAllowLayout() 

    /**
     * Method deleteAllowLookAndFeel
     * 
     */
    public void deleteAllowLookAndFeel()
    {
        this._has_allowLookAndFeel= false;
    } //-- void deleteAllowLookAndFeel() 

    /**
     * Method deleteAllowSignIn
     * 
     */
    public void deleteAllowSignIn()
    {
        this._has_allowSignIn= false;
    } //-- void deleteAllowSignIn() 

    /**
     * Method deleteAllowTurnOff
     * 
     */
    public void deleteAllowTurnOff()
    {
        this._has_allowTurnOff= false;
    } //-- void deleteAllowTurnOff() 

    /**
     * Returns the value of field 'allowAddContent'.
     * 
     * @return boolean
     * @return the value of field 'allowAddContent'.
     */
    public boolean getAllowAddContent()
    {
        return this._allowAddContent;
    } //-- boolean getAllowAddContent() 

    /**
     * Returns the value of field 'allowAddTab'.
     * 
     * @return boolean
     * @return the value of field 'allowAddTab'.
     */
    public boolean getAllowAddTab()
    {
        return this._allowAddTab;
    } //-- boolean getAllowAddTab() 

    /**
     * Returns the value of field 'allowLayout'.
     * 
     * @return boolean
     * @return the value of field 'allowLayout'.
     */
    public boolean getAllowLayout()
    {
        return this._allowLayout;
    } //-- boolean getAllowLayout() 

    /**
     * Returns the value of field 'allowLookAndFeel'.
     * 
     * @return boolean
     * @return the value of field 'allowLookAndFeel'.
     */
    public boolean getAllowLookAndFeel()
    {
        return this._allowLookAndFeel;
    } //-- boolean getAllowLookAndFeel() 

    /**
     * Returns the value of field 'allowSignIn'.
     * 
     * @return boolean
     * @return the value of field 'allowSignIn'.
     */
    public boolean getAllowSignIn()
    {
        return this._allowSignIn;
    } //-- boolean getAllowSignIn() 

    /**
     * Returns the value of field 'allowTurnOff'.
     * 
     * @return boolean
     * @return the value of field 'allowTurnOff'.
     */
    public boolean getAllowTurnOff()
    {
        return this._allowTurnOff;
    } //-- boolean getAllowTurnOff() 

    /**
     * Returns the value of field 'name'.
     * 
     * @return String
     * @return the value of field 'name'.
     */
    public java.lang.String getName()
    {
        return this._name;
    } //-- java.lang.String getName() 

    /**
     * Returns the value of field 'theme'.
     * 
     * @return String
     * @return the value of field 'theme'.
     */
    public java.lang.String getTheme()
    {
        return this._theme;
    } //-- java.lang.String getTheme() 

    /**
     * Returns the value of field 'title'.
     * 
     * @return String
     * @return the value of field 'title'.
     */
    public java.lang.String getTitle()
    {
        return this._title;
    } //-- java.lang.String getTitle() 

    /**
     * Returns the value of field 'users'.
     * 
     * @return Users
     * @return the value of field 'users'.
     */
    public org.light.portal.security.config.Users getUsers()
    {
        return this._users;
    } //-- org.light.portal.security.config.Users getUsers() 

    /**
     * Method hasAllowAddContent
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasAllowAddContent()
    {
        return this._has_allowAddContent;
    } //-- boolean hasAllowAddContent() 

    /**
     * Method hasAllowAddTab
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasAllowAddTab()
    {
        return this._has_allowAddTab;
    } //-- boolean hasAllowAddTab() 

    /**
     * Method hasAllowLayout
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasAllowLayout()
    {
        return this._has_allowLayout;
    } //-- boolean hasAllowLayout() 

    /**
     * Method hasAllowLookAndFeel
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasAllowLookAndFeel()
    {
        return this._has_allowLookAndFeel;
    } //-- boolean hasAllowLookAndFeel() 

    /**
     * Method hasAllowSignIn
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasAllowSignIn()
    {
        return this._has_allowSignIn;
    } //-- boolean hasAllowSignIn() 

    /**
     * Method hasAllowTurnOff
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasAllowTurnOff()
    {
        return this._has_allowTurnOff;
    } //-- boolean hasAllowTurnOff() 

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
     * Sets the value of field 'allowAddContent'.
     * 
     * @param allowAddContent the value of field 'allowAddContent'.
     */
    public void setAllowAddContent(boolean allowAddContent)
    {
        this._allowAddContent = allowAddContent;
        this._has_allowAddContent = true;
    } //-- void setAllowAddContent(boolean) 

    /**
     * Sets the value of field 'allowAddTab'.
     * 
     * @param allowAddTab the value of field 'allowAddTab'.
     */
    public void setAllowAddTab(boolean allowAddTab)
    {
        this._allowAddTab = allowAddTab;
        this._has_allowAddTab = true;
    } //-- void setAllowAddTab(boolean) 

    /**
     * Sets the value of field 'allowLayout'.
     * 
     * @param allowLayout the value of field 'allowLayout'.
     */
    public void setAllowLayout(boolean allowLayout)
    {
        this._allowLayout = allowLayout;
        this._has_allowLayout = true;
    } //-- void setAllowLayout(boolean) 

    /**
     * Sets the value of field 'allowLookAndFeel'.
     * 
     * @param allowLookAndFeel the value of field 'allowLookAndFeel'
     */
    public void setAllowLookAndFeel(boolean allowLookAndFeel)
    {
        this._allowLookAndFeel = allowLookAndFeel;
        this._has_allowLookAndFeel = true;
    } //-- void setAllowLookAndFeel(boolean) 

    /**
     * Sets the value of field 'allowSignIn'.
     * 
     * @param allowSignIn the value of field 'allowSignIn'.
     */
    public void setAllowSignIn(boolean allowSignIn)
    {
        this._allowSignIn = allowSignIn;
        this._has_allowSignIn = true;
    } //-- void setAllowSignIn(boolean) 

    /**
     * Sets the value of field 'allowTurnOff'.
     * 
     * @param allowTurnOff the value of field 'allowTurnOff'.
     */
    public void setAllowTurnOff(boolean allowTurnOff)
    {
        this._allowTurnOff = allowTurnOff;
        this._has_allowTurnOff = true;
    } //-- void setAllowTurnOff(boolean) 

    /**
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(java.lang.String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String) 

    /**
     * Sets the value of field 'theme'.
     * 
     * @param theme the value of field 'theme'.
     */
    public void setTheme(java.lang.String theme)
    {
        this._theme = theme;
    } //-- void setTheme(java.lang.String) 

    /**
     * Sets the value of field 'title'.
     * 
     * @param title the value of field 'title'.
     */
    public void setTitle(java.lang.String title)
    {
        this._title = title;
    } //-- void setTitle(java.lang.String) 

    /**
     * Sets the value of field 'users'.
     * 
     * @param users the value of field 'users'.
     */
    public void setUsers(org.light.portal.security.config.Users users)
    {
        this._users = users;
    } //-- void setUsers(org.light.portal.security.config.Users) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Role
     */
    public static org.light.portal.security.config.Role unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.light.portal.security.config.Role) Unmarshaller.unmarshal(org.light.portal.security.config.Role.class, reader);
    } //-- org.light.portal.security.config.Role unmarshal(java.io.Reader) 

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
