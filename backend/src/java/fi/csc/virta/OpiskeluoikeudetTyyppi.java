
package fi.csc.virta;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 			StudyRights
 * 			* Root element for several study rights
 * 		
 * 
 * <p>Java class for OpiskeluoikeudetTyyppi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OpiskeluoikeudetTyyppi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Opiskeluoikeus" type="{urn:mace:funet.fi:virta/2015/09/01}OpiskeluoikeusTyyppi" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OpiskeluoikeudetTyyppi", propOrder = {
    "opiskeluoikeus"
})
public class OpiskeluoikeudetTyyppi {

    @XmlElement(name = "Opiskeluoikeus", required = true)
    protected List<OpiskeluoikeusTyyppi> opiskeluoikeus;

    /**
     * Gets the value of the opiskeluoikeus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the opiskeluoikeus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOpiskeluoikeus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OpiskeluoikeusTyyppi }
     * 
     * 
     */
    public List<OpiskeluoikeusTyyppi> getOpiskeluoikeus() {
        if (opiskeluoikeus == null) {
            opiskeluoikeus = new ArrayList<OpiskeluoikeusTyyppi>();
        }
        return this.opiskeluoikeus;
    }

}
