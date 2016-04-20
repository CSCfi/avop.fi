
package fi.csc.virta;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 			Lukukausi-ilmoittautumiset
 * 			* Juurielementti useille lukukausi-ilmoittautumisille
 * 		
 * 
 * <p>Java class for LukukausiIlmoittautumisetTyyppi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LukukausiIlmoittautumisetTyyppi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LukukausiIlmoittautuminen" type="{urn:mace:funet.fi:virta/2015/09/01}LukukausiIlmoittautuminenTyyppi" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LukukausiIlmoittautumisetTyyppi", propOrder = {
    "lukukausiIlmoittautuminen"
})
public class LukukausiIlmoittautumisetTyyppi {

    @XmlElement(name = "LukukausiIlmoittautuminen", required = true)
    protected List<LukukausiIlmoittautuminenTyyppi> lukukausiIlmoittautuminen;

    /**
     * Gets the value of the lukukausiIlmoittautuminen property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lukukausiIlmoittautuminen property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLukukausiIlmoittautuminen().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LukukausiIlmoittautuminenTyyppi }
     * 
     * 
     */
    public List<LukukausiIlmoittautuminenTyyppi> getLukukausiIlmoittautuminen() {
        if (lukukausiIlmoittautuminen == null) {
            lukukausiIlmoittautuminen = new ArrayList<LukukausiIlmoittautuminenTyyppi>();
        }
        return this.lukukausiIlmoittautuminen;
    }

}
