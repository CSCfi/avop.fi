
package fi.csc.virta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 * 			Student
 * 			* Information of a single student
 * 		
 * 
 * <p>Java class for OpiskelijaTyyppi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OpiskelijaTyyppi">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:mace:funet.fi:virta/2015/09/01}HenkiloTyyppi">
 *       &lt;sequence>
 *         &lt;element name="KirjoihintuloPvm" type="{urn:mace:funet.fi:virta/2015/09/01}PvmTyyppi" minOccurs="0"/>
 *         &lt;element name="KansallinenOppijanumero" type="{urn:mace:funet.fi:virta/2015/09/01}KansallinenOppijanumeroTyyppi" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="avain" use="required" type="{urn:mace:funet.fi:virta/2015/09/01}AvainTyyppi" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OpiskelijaTyyppi", propOrder = {
    "kirjoihintuloPvm",
    "kansallinenOppijanumero"
})
@XmlSeeAlso({
    OpiskelijaLaajennettuTyyppi.class
})
public class OpiskelijaTyyppi
    extends HenkiloTyyppi
{

    @XmlElement(name = "KirjoihintuloPvm")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar kirjoihintuloPvm;
    @XmlElement(name = "KansallinenOppijanumero")
    protected String kansallinenOppijanumero;
    @XmlAttribute(name = "avain", required = true)
    protected String avain;

    /**
     * Gets the value of the kirjoihintuloPvm property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getKirjoihintuloPvm() {
        return kirjoihintuloPvm;
    }

    /**
     * Sets the value of the kirjoihintuloPvm property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setKirjoihintuloPvm(XMLGregorianCalendar value) {
        this.kirjoihintuloPvm = value;
    }

    /**
     * Gets the value of the kansallinenOppijanumero property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKansallinenOppijanumero() {
        return kansallinenOppijanumero;
    }

    /**
     * Sets the value of the kansallinenOppijanumero property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKansallinenOppijanumero(String value) {
        this.kansallinenOppijanumero = value;
    }

    /**
     * Gets the value of the avain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvain() {
        return avain;
    }

    /**
     * Sets the value of the avain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvain(String value) {
        this.avain = value;
    }

}
