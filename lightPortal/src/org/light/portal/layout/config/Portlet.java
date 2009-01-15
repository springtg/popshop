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
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class Portlet.
 * 
 * @version $Revision$ $Date$
 */
public class Portlet implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * Field _column
     */
    private int _column;

    /**
     * keeps track of state for field: _column
     */
    private boolean _has_column;

    /**
     * Field _row
     */
    private int _row;

    /**
     * keeps track of state for field: _row
     */
    private boolean _has_row;

    /**
     * Field _notCloseable
     */
    private boolean _notCloseable;

    /**
     * keeps track of state for field: _notCloseable
     */
    private boolean _has_notCloseable;

    /**
     * Field _noEditMode
     */
    private boolean _noEditMode;

    /**
     * keeps track of state for field: _noEditMode
     */
    private boolean _has_noEditMode;

    /**
     * Field _noConfigMode
     */
    private boolean _noConfigMode;

    /**
     * keeps track of state for field: _noConfigMode
     */
    private boolean _has_noConfigMode;

    /**
     * Field _barBgColor
     */
    private java.lang.String _barBgColor;

    /**
     * Field _barFontColor
     */
    private java.lang.String _barFontColor;

    /**
     * Field _contentBgColor
     */
    private java.lang.String _contentBgColor;


      //----------------/
     //- Constructors -/
    //----------------/

    public Portlet() 
     {
        super();
    } //-- org.light.portal.layout.config.Portlet()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method deleteColumn
     * 
     */
    public void deleteColumn()
    {
        this._has_column= false;
    } //-- void deleteColumn() 

    /**
     * Method deleteNoConfigMode
     * 
     */
    public void deleteNoConfigMode()
    {
        this._has_noConfigMode= false;
    } //-- void deleteNoConfigMode() 

    /**
     * Method deleteNoEditMode
     * 
     */
    public void deleteNoEditMode()
    {
        this._has_noEditMode= false;
    } //-- void deleteNoEditMode() 

    /**
     * Method deleteNotCloseable
     * 
     */
    public void deleteNotCloseable()
    {
        this._has_notCloseable= false;
    } //-- void deleteNotCloseable() 

    /**
     * Method deleteRow
     * 
     */
    public void deleteRow()
    {
        this._has_row= false;
    } //-- void deleteRow() 

    /**
     * Returns the value of field 'barBgColor'.
     * 
     * @return String
     * @return the value of field 'barBgColor'.
     */
    public java.lang.String getBarBgColor()
    {
        return this._barBgColor;
    } //-- java.lang.String getBarBgColor() 

    /**
     * Returns the value of field 'barFontColor'.
     * 
     * @return String
     * @return the value of field 'barFontColor'.
     */
    public java.lang.String getBarFontColor()
    {
        return this._barFontColor;
    } //-- java.lang.String getBarFontColor() 

    /**
     * Returns the value of field 'column'.
     * 
     * @return int
     * @return the value of field 'column'.
     */
    public int getColumn()
    {
        return this._column;
    } //-- int getColumn() 

    /**
     * Returns the value of field 'contentBgColor'.
     * 
     * @return String
     * @return the value of field 'contentBgColor'.
     */
    public java.lang.String getContentBgColor()
    {
        return this._contentBgColor;
    } //-- java.lang.String getContentBgColor() 

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
     * Returns the value of field 'noConfigMode'.
     * 
     * @return boolean
     * @return the value of field 'noConfigMode'.
     */
    public boolean getNoConfigMode()
    {
        return this._noConfigMode;
    } //-- boolean getNoConfigMode() 

    /**
     * Returns the value of field 'noEditMode'.
     * 
     * @return boolean
     * @return the value of field 'noEditMode'.
     */
    public boolean getNoEditMode()
    {
        return this._noEditMode;
    } //-- boolean getNoEditMode() 

    /**
     * Returns the value of field 'notCloseable'.
     * 
     * @return boolean
     * @return the value of field 'notCloseable'.
     */
    public boolean getNotCloseable()
    {
        return this._notCloseable;
    } //-- boolean getNotCloseable() 

    /**
     * Returns the value of field 'row'.
     * 
     * @return int
     * @return the value of field 'row'.
     */
    public int getRow()
    {
        return this._row;
    } //-- int getRow() 

    /**
     * Method hasColumn
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasColumn()
    {
        return this._has_column;
    } //-- boolean hasColumn() 

    /**
     * Method hasNoConfigMode
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasNoConfigMode()
    {
        return this._has_noConfigMode;
    } //-- boolean hasNoConfigMode() 

    /**
     * Method hasNoEditMode
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasNoEditMode()
    {
        return this._has_noEditMode;
    } //-- boolean hasNoEditMode() 

    /**
     * Method hasNotCloseable
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasNotCloseable()
    {
        return this._has_notCloseable;
    } //-- boolean hasNotCloseable() 

    /**
     * Method hasRow
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasRow()
    {
        return this._has_row;
    } //-- boolean hasRow() 

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
     * Sets the value of field 'barBgColor'.
     * 
     * @param barBgColor the value of field 'barBgColor'.
     */
    public void setBarBgColor(java.lang.String barBgColor)
    {
        this._barBgColor = barBgColor;
    } //-- void setBarBgColor(java.lang.String) 

    /**
     * Sets the value of field 'barFontColor'.
     * 
     * @param barFontColor the value of field 'barFontColor'.
     */
    public void setBarFontColor(java.lang.String barFontColor)
    {
        this._barFontColor = barFontColor;
    } //-- void setBarFontColor(java.lang.String) 

    /**
     * Sets the value of field 'column'.
     * 
     * @param column the value of field 'column'.
     */
    public void setColumn(int column)
    {
        this._column = column;
        this._has_column = true;
    } //-- void setColumn(int) 

    /**
     * Sets the value of field 'contentBgColor'.
     * 
     * @param contentBgColor the value of field 'contentBgColor'.
     */
    public void setContentBgColor(java.lang.String contentBgColor)
    {
        this._contentBgColor = contentBgColor;
    } //-- void setContentBgColor(java.lang.String) 

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
     * Sets the value of field 'noConfigMode'.
     * 
     * @param noConfigMode the value of field 'noConfigMode'.
     */
    public void setNoConfigMode(boolean noConfigMode)
    {
        this._noConfigMode = noConfigMode;
        this._has_noConfigMode = true;
    } //-- void setNoConfigMode(boolean) 

    /**
     * Sets the value of field 'noEditMode'.
     * 
     * @param noEditMode the value of field 'noEditMode'.
     */
    public void setNoEditMode(boolean noEditMode)
    {
        this._noEditMode = noEditMode;
        this._has_noEditMode = true;
    } //-- void setNoEditMode(boolean) 

    /**
     * Sets the value of field 'notCloseable'.
     * 
     * @param notCloseable the value of field 'notCloseable'.
     */
    public void setNotCloseable(boolean notCloseable)
    {
        this._notCloseable = notCloseable;
        this._has_notCloseable = true;
    } //-- void setNotCloseable(boolean) 

    /**
     * Sets the value of field 'row'.
     * 
     * @param row the value of field 'row'.
     */
    public void setRow(int row)
    {
        this._row = row;
        this._has_row = true;
    } //-- void setRow(int) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Portlet
     */
    public static org.light.portal.layout.config.Portlet unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.light.portal.layout.config.Portlet) Unmarshaller.unmarshal(org.light.portal.layout.config.Portlet.class, reader);
    } //-- org.light.portal.layout.config.Portlet unmarshal(java.io.Reader) 

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
