
package fi.csc.virta;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 			Students
 * 			* Root element for all students
 * 		
 * 
 * <p>Java class for OpiskelijatTyyppi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OpiskelijatTyyppi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Opiskelija" type="{urn:mace:funet.fi:virta/2015/09/01}OpiskelijaTyyppi" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OpiskelijatTyyppi", propOrder = {
    "opiskelija"
})
public class OpiskelijatTyyppi {

    @XmlElement(name = "Opiskelija", required = true)
    protected List<OpiskelijaTyyppi> opiskelija;

    /**
     * Gets the value of the opiskelija property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the opiskelija property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOpiskelija().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OpiskelijaTyyppi }
     * 
     * 
     */
    public List<OpiskelijaTyyppi> getOpiskelija() {
        if (opiskelija == null) {
            opiskelija = new ArrayList<OpiskelijaTyyppi>();
        }
        return this.opiskelija;
    }

}
