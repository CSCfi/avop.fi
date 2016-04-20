
package fi.csc.virta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * 
 * 			Koulutusalat yhdistettynä, versio-attribuutilla.
 * 		
 * 
 * <p>Java class for KoulutusalaVersioTyyppi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KoulutusalaVersioTyyppi">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;urn:mace:funet.fi:virta/2015/09/01>KoulutusalaKoodiTyyppi">
 *       &lt;attribute name="versio" use="required" type="{urn:mace:funet.fi:virta/2015/09/01}KoulutusalaVersioKoodiTyyppi" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KoulutusalaVersioTyyppi", propOrder = {
    "value"
})
public class KoulutusalaVersioTyyppi {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "versio", required = true)
    protected KoulutusalaVersioKoodiTyyppi versio;

    /**
     * 
     * 			Opetushallinnon koulutusalat yhdistettynä (koodisto).
     * 			* Koulutusala 2002 (opmala)
     * 			* Opintoala 1995 (opm95opa)
     * 			* OKM:n ohjauksen ala ()
     * 		
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the versio property.
     * 
     * @return
     *     possible object is
     *     {@link KoulutusalaVersioKoodiTyyppi }
     *     
     */
    public KoulutusalaVersioKoodiTyyppi getVersio() {
        return versio;
    }

    /**
     * Sets the value of the versio property.
     * 
     * @param value
     *     allowed object is
     *     {@link KoulutusalaVersioKoodiTyyppi }
     *     
     */
    public void setVersio(KoulutusalaVersioKoodiTyyppi value) {
        this.versio = value;
    }

}
