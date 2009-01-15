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
 * Class PortalTab.
 * 
 * @version $Revision$ $Date$
 */
public class PortalTab implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _title
     */
    private java.lang.String _title;

    /**
     * Field _url
     */
    private java.lang.String _url;

    /**
     * Field _defaulted
     */
    private boolean _defaulted;

    /**
     * keeps track of state for field: _defaulted
     */
    private boolean _has_defaulted;

    /**
     * Field _closeable
     */
    private boolean _closeable;

    /**
     * keeps track of state for field: _closeable
     */
    private boolean _has_closeable;

    /**
     * Field _editable
     */
    private boolean _editable;

    /**
     * keeps track of state for field: _editable
     */
    private boolean _has_editable;

    /**
     * Field _moveable
     */
    private boolean _moveable;

    /**
     * keeps track of state for field: _moveable
     */
    private boolean _has_moveable;

    /**
     * Field _allowAddContent
     */
    private boolean _allowAddContent;

    /**
     * keeps track of state for field: _allowAddContent
     */
    private boolean _has_allowAddContent;

    /**
     * Field _widths
     */
    private java.lang.String _widths;

    /**
     * Field _between
     */
    private int _between;

    /**
     * keeps track of state for field: _between
     */
    private boolean _has_between;

    /**
     * Field _portletWindow
     */
    private java.lang.String _portletWindow;

    /**
     * Field _color
     */
    private java.lang.String _color;

    /**
     * Field _portlets
     */
    private org.light.portal.layout.config.Portlets _portlets;


      //----------------/
     //- Constructors -/
    //----------------/

    public PortalTab() 
     {
        super();
    } //-- org.light.portal.layout.config.PortalTab()


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
     * Method deleteBetween
     * 
     */
    public void deleteBetween()
    {
        this._has_between= false;
    } //-- void deleteBetween() 

    /**
     * Method deleteCloseable
     * 
     */
    public void deleteCloseable()
    {
        this._has_closeable= false;
    } //-- void deleteCloseable() 

    /**
     * Method deleteDefaulted
     * 
     */
    public void deleteDefaulted()
    {
        this._has_defaulted= false;
    } //-- void deleteDefaulted() 

    /**
     * Method deleteEditable
     * 
     */
    public void deleteEditable()
    {
        this._has_editable= false;
    } //-- void deleteEditable() 

    /**
     * Method deleteMoveable
     * 
     */
    public void deleteMoveable()
    {
        this._has_moveable= false;
    } //-- void deleteMoveable() 

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
     * Returns the value of field 'between'.
     * 
     * @return int
     * @return the value of field 'between'.
     */
    public int getBetween()
    {
        return this._between;
    } //-- int getBetween() 

    /**
     * Returns the value of field 'closeable'.
     * 
     * @return boolean
     * @return the value of field 'closeable'.
     */
    public boolean getCloseable()
    {
        return this._closeable;
    } //-- boolean getCloseable() 

    /**
     * Returns the value of field 'color'.
     * 
     * @return String
     * @return the value of field 'color'.
     */
    public java.lang.String getColor()
    {
        return this._color;
    } //-- java.lang.String getColor() 

    /**
     * Returns the value of field 'defaulted'.
     * 
     * @return boolean
     * @return the value of field 'defaulted'.
     */
    public boolean getDefaulted()
    {
        return this._defaulted;
    } //-- boolean getDefaulted() 

    /**
     * Returns the value of field 'editable'.
     * 
     * @return boolean
     * @return the value of field 'editable'.
     */
    public boolean getEditable()
    {
        return this._editable;
    } //-- boolean getEditable() 

    /**
     * Returns the value of field 'moveable'.
     * 
     * @return boolean
     * @return the value of field 'moveable'.
     */
    public boolean getMoveable()
    {
        return this._moveable;
    } //-- boolean getMoveable() 

    /**
     * Returns the value of field 'portletWindow'.
     * 
     * @return String
     * @return the value of field 'portletWindow'.
     */
    public java.lang.String getPortletWindow()
    {
        return this._portletWindow;
    } //-- java.lang.String getPortletWindow() 

    /**
     * Returns the value of field 'portlets'.
     * 
     * @return Portlets
     * @return the value of field 'portlets'.
     */
    public org.light.portal.layout.config.Portlets getPortlets()
    {
        return this._portlets;
    } //-- org.light.portal.layout.config.Portlets getPortlets() 

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
     * Returns the value of field 'url'.
     * 
     * @return String
     * @return the value of field 'url'.
     */
    public java.lang.String getUrl()
    {
        return this._url;
    } //-- java.lang.String getUrl() 

    /**
     * Returns the value of field 'widths'.
     * 
     * @return String
     * @return the value of field 'widths'.
     */
    public java.lang.String getWidths()
    {
        return this._widths;
    } //-- java.lang.String getWidths() 

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
     * Method hasBetween
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasBetween()
    {
        return this._has_between;
    } //-- boolean hasBetween() 

    /**
     * Method hasCloseable
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasCloseable()
    {
        return this._has_closeable;
    } //-- boolean hasCloseable() 

    /**
     * Method hasDefaulted
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasDefaulted()
    {
        return this._has_defaulted;
    } //-- boolean hasDefaulted() 

    /**
     * Method hasEditable
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasEditable()
    {
        return this._has_editable;
    } //-- boolean hasEditable() 

    /**
     * Method hasMoveable
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasMoveable()
    {
        return this._has_moveable;
    } //-- boolean hasMoveable() 

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
     * Sets the value of field 'between'.
     * 
     * @param between the value of field 'between'.
     */
    public void setBetween(int between)
    {
        this._between = between;
        this._has_between = true;
    } //-- void setBetween(int) 

    /**
     * Sets the value of field 'closeable'.
     * 
     * @param closeable the value of field 'closeable'.
     */
    public void setCloseable(boolean closeable)
    {
        this._closeable = closeable;
        this._has_closeable = true;
    } //-- void setCloseable(boolean) 

    /**
     * Sets the value of field 'color'.
     * 
     * @param color the value of field 'color'.
     */
    public void setColor(java.lang.String color)
    {
        this._color = color;
    } //-- void setColor(java.lang.String) 

    /**
     * Sets the value of field 'defaulted'.
     * 
     * @param defaulted the value of field 'defaulted'.
     */
    public void setDefaulted(boolean defaulted)
    {
        this._defaulted = defaulted;
        this._has_defaulted = true;
    } //-- void setDefaulted(boolean) 

    /**
     * Sets the value of field 'editable'.
     * 
     * @param editable the value of field 'editable'.
     */
    public void setEditable(boolean editable)
    {
        this._editable = editable;
        this._has_editable = true;
    } //-- void setEditable(boolean) 

    /**
     * Sets the value of field 'moveable'.
     * 
     * @param moveable the value of field 'moveable'.
     */
    public void setMoveable(boolean moveable)
    {
        this._moveable = moveable;
        this._has_moveable = true;
    } //-- void setMoveable(boolean) 

    /**
     * Sets the value of field 'portletWindow'.
     * 
     * @param portletWindow the value of field 'portletWindow'.
     */
    public void setPortletWindow(java.lang.String portletWindow)
    {
        this._portletWindow = portletWindow;
    } //-- void setPortletWindow(java.lang.String) 

    /**
     * Sets the value of field 'portlets'.
     * 
     * @param portlets the value of field 'portlets'.
     */
    public void setPortlets(org.light.portal.layout.config.Portlets portlets)
    {
        this._portlets = portlets;
    } //-- void setPortlets(org.light.portal.layout.config.Portlets) 

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
     * Sets the value of field 'url'.
     * 
     * @param url the value of field 'url'.
     */
    public void setUrl(java.lang.String url)
    {
        this._url = url;
    } //-- void setUrl(java.lang.String) 

    /**
     * Sets the value of field 'widths'.
     * 
     * @param widths the value of field 'widths'.
     */
    public void setWidths(java.lang.String widths)
    {
        this._widths = widths;
    } //-- void setWidths(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return PortalTab
     */
    public static org.light.portal.layout.config.PortalTab unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.light.portal.layout.config.PortalTab) Unmarshaller.unmarshal(org.light.portal.layout.config.PortalTab.class, reader);
    } //-- org.light.portal.layout.config.PortalTab unmarshal(java.io.Reader) 

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
