
package fi.csc.virta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for AikajaksoTyyppi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AikajaksoTyyppi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AlkuPvm" type="{urn:mace:funet.fi:virta/2015/09/01}PvmTyyppi"/>
 *         &lt;element name="LoppuPvm" type="{urn:mace:funet.fi:virta/2015/09/01}PvmTyyppi" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AikajaksoTyyppi", propOrder = {
    "alkuPvm",
    "loppuPvm"
})
@XmlSeeAlso({
    fi.csc.virta.OpiskeluoikeusTyyppi.Tila.class,
    fi.csc.virta.OpiskeluoikeusTyyppi.Jakso.class
})
public class AikajaksoTyyppi {

    @XmlElement(name = "AlkuPvm", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar alkuPvm;
    @XmlElement(name = "LoppuPvm")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar loppuPvm;

    /**
     * Gets the value of the alkuPvm property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAlkuPvm() {
        return alkuPvm;
    }

    /**
     * Sets the value of the alkuPvm property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAlkuPvm(XMLGregorianCalendar value) {
        this.alkuPvm = value;
    }

    /**
     * Gets the value of the loppuPvm property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLoppuPvm() {
        return loppuPvm;
    }

    /**
     * Sets the value of the loppuPvm property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLoppuPvm(XMLGregorianCalendar value) {
        this.loppuPvm = value;
    }

}
