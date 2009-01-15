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
import org.light.portal.portlet.definition.types.TransportGuaranteeType;
import org.xml.sax.ContentHandler;

/**
 * The user-data-constraintType is used to indicate how
 *  data communicated between the client and portlet should be
 *  protected.
 *  Used in: security-constraint
 *  
 * 
 * @version $Revision$ $Date$
 */
public class UserDataConstraintType implements java.io.Serializable {


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
     * Field _transportGuarantee
     */
    private org.light.portal.portlet.definition.types.TransportGuaranteeType _transportGuarantee;


      //----------------/
     //- Constructors -/
    //----------------/

    public UserDataConstraintType() 
     {
        super();
        _descriptionList = new Vector();
    } //-- org.light.portlet.definition.UserDataConstraintType()


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
     * Returns the value of field 'transportGuarantee'.
     * 
     * @return TransportGuaranteeType
     * @return the value of field 'transportGuarantee'.
     */
    public org.light.portal.portlet.definition.types.TransportGuaranteeType getTransportGuarantee()
    {
        return this._transportGuarantee;
    } //-- org.light.portlet.definition.types.TransportGuaranteeType getTransportGuarantee() 

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
     * Sets the value of field 'transportGuarantee'.
     * 
     * @param transportGuarantee the value of field
     * 'transportGuarantee'.
     */
    public void setTransportGuarantee(org.light.portal.portlet.definition.types.TransportGuaranteeType transportGuarantee)
    {
        this._transportGuarantee = transportGuarantee;
    } //-- void setTransportGuarantee(org.light.portlet.definition.types.TransportGuaranteeType) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return UserDataConstraintType
     */
    public static org.light.portal.portlet.definition.UserDataConstraintType unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.light.portal.portlet.definition.UserDataConstraintType) Unmarshaller.unmarshal(org.light.portal.portlet.definition.UserDataConstraintType.class, reader);
    } //-- org.light.portlet.definition.UserDataConstraintType unmarshal(java.io.Reader) 

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
