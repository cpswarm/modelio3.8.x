//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.10.04 at 05:00:25 PM CEST
//
package org.modelio.module.attacktreedesigner.conversion.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * <p>Java class for treeReferenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="treeReferenceType">
 * &lt;complexContent>
 * &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 * &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}string" />
 * &lt;/restriction>
 * &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@objid ("f4361b5e-3b8b-4cb6-80d4-3abaa3aa43c0")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "treeReferenceType")
public class TreeReferenceType {
    @objid ("e2122d2c-bf6a-4c89-b24e-87364194655d")
    @XmlAttribute(name = "ref")
    protected String ref;

    /**
     * Gets the value of the ref property.
     * @return
     * possible object is
     * {@link String }
     */
    @objid ("4049853c-c6e5-4c73-99aa-a8a4999e7299")
    public String getRef() {
        return this.ref;
    }

    /**
     * Sets the value of the ref property.
     * 
     * @param value allowed object is
     * {@link String }
     */
    @objid ("9d7accf3-adca-4d14-98fb-e3e908f41b1f")
    public void setRef(String value) {
        this.ref = value;
    }

}
