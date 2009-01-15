/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.0</a>, using an XML
 * Schema.
 * $Id$
 */

package org.light.portal.portlet.definition.types;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class TransportGuaranteeType.
 * 
 * @version $Revision$ $Date$
 */
public class TransportGuaranteeType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The NONE type
     */
    public static final int NONE_TYPE = 0;

    /**
     * The instance of the NONE type
     */
    public static final TransportGuaranteeType NONE = new TransportGuaranteeType(NONE_TYPE, "NONE");

    /**
     * The INTEGRAL type
     */
    public static final int INTEGRAL_TYPE = 1;

    /**
     * The instance of the INTEGRAL type
     */
    public static final TransportGuaranteeType INTEGRAL = new TransportGuaranteeType(INTEGRAL_TYPE, "INTEGRAL");

    /**
     * The CONFIDENTIAL type
     */
    public static final int CONFIDENTIAL_TYPE = 2;

    /**
     * The instance of the CONFIDENTIAL type
     */
    public static final TransportGuaranteeType CONFIDENTIAL = new TransportGuaranteeType(CONFIDENTIAL_TYPE, "CONFIDENTIAL");

    /**
     * Field _memberTable
     */
    private static java.util.Hashtable _memberTable = init();

    /**
     * Field type
     */
    private int type = -1;

    /**
     * Field stringValue
     */
    private java.lang.String stringValue = null;


      //----------------/
     //- Constructors -/
    //----------------/

    private TransportGuaranteeType(int type, java.lang.String value) 
     {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- org.light.portlet.definition.types.TransportGuaranteeType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate
     * 
     * Returns an enumeration of all possible instances of
     * TransportGuaranteeType
     * 
     * @return Enumeration
     */
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Method getType
     * 
     * Returns the type of this TransportGuaranteeType
     * 
     * @return int
     */
    public int getType()
    {
        return this.type;
    } //-- int getType() 

    /**
     * Method init
     * 
     * 
     * 
     * @return Hashtable
     */
    private static java.util.Hashtable init()
    {
        Hashtable members = new Hashtable();
        members.put("NONE", NONE);
        members.put("INTEGRAL", INTEGRAL);
        members.put("CONFIDENTIAL", CONFIDENTIAL);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Method readResolve
     * 
     *  will be called during deserialization to replace the
     * deserialized object with the correct constant instance.
     * <br/>
     * 
     * @return Object
     */
    private java.lang.Object readResolve()
    {
        return valueOf(this.stringValue);
    } //-- java.lang.Object readResolve() 

    /**
     * Method toString
     * 
     * Returns the String representation of this
     * TransportGuaranteeType
     * 
     * @return String
     */
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOf
     * 
     * Returns a new TransportGuaranteeType based on the given
     * String value.
     * 
     * @param string
     * @return TransportGuaranteeType
     */
    public static org.light.portal.portlet.definition.types.TransportGuaranteeType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid TransportGuaranteeType";
            throw new IllegalArgumentException(err);
        }
        return (TransportGuaranteeType) obj;
    } //-- org.light.portlet.definition.types.TransportGuaranteeType valueOf(java.lang.String) 

}
