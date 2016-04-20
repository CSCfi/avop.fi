
package fi.csc.virta;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 			Arvosana-asteikko muu.
 * 			Arvosanoja varten, jotka kuuluvat muihin arvosana-asteikoihin kuin tässä
 * 			XML-skeemassa erikseen kuvattuihin.
 * 		
 * 
 * <p>Java class for ArvosanaAsteikkoMuuTyyppi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArvosanaAsteikkoMuuTyyppi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Asteikko">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Nimi" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="200"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="AsteikkoArvosana" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Koodi">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="20"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Nimi" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="200"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="LaskennallinenArvo" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                   &lt;totalDigits value="24"/>
 *                                   &lt;fractionDigits value="6"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="avain" use="required" type="{urn:mace:funet.fi:virta/2015/09/01}AvainTyyppi" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="avain" use="required" type="{urn:mace:funet.fi:virta/2015/09/01}AvainTyyppi" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Koodi">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArvosanaAsteikkoMuuTyyppi", propOrder = {
    "asteikko",
    "koodi"
})
public class ArvosanaAsteikkoMuuTyyppi {

    @XmlElement(name = "Asteikko", required = true)
    protected ArvosanaAsteikkoMuuTyyppi.Asteikko asteikko;
    @XmlElement(name = "Koodi", required = true)
    protected String koodi;

    /**
     * Gets the value of the asteikko property.
     * 
     * @return
     *     possible object is
     *     {@link ArvosanaAsteikkoMuuTyyppi.Asteikko }
     *     
     */
    public ArvosanaAsteikkoMuuTyyppi.Asteikko getAsteikko() {
        return asteikko;
    }

    /**
     * Sets the value of the asteikko property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArvosanaAsteikkoMuuTyyppi.Asteikko }
     *     
     */
    public void setAsteikko(ArvosanaAsteikkoMuuTyyppi.Asteikko value) {
        this.asteikko = value;
    }

    /**
     * Gets the value of the koodi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKoodi() {
        return koodi;
    }

    /**
     * Sets the value of the koodi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKoodi(String value) {
        this.koodi = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Nimi" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="200"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="AsteikkoArvosana" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Koodi">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="20"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="Nimi" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="200"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="LaskennallinenArvo" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                         &lt;totalDigits value="24"/>
     *                         &lt;fractionDigits value="6"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="avain" use="required" type="{urn:mace:funet.fi:virta/2015/09/01}AvainTyyppi" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="avain" use="required" type="{urn:mace:funet.fi:virta/2015/09/01}AvainTyyppi" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "nimi",
        "asteikkoArvosana"
    })
    public static class Asteikko {

        @XmlElement(name = "Nimi")
        protected String nimi;
        @XmlElement(name = "AsteikkoArvosana")
        protected List<ArvosanaAsteikkoMuuTyyppi.Asteikko.AsteikkoArvosana> asteikkoArvosana;
        @XmlAttribute(name = "avain", required = true)
        protected String avain;

        /**
         * Gets the value of the nimi property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNimi() {
            return nimi;
        }

        /**
         * Sets the value of the nimi property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNimi(String value) {
            this.nimi = value;
        }

        /**
         * Gets the value of the asteikkoArvosana property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the asteikkoArvosana property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAsteikkoArvosana().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ArvosanaAsteikkoMuuTyyppi.Asteikko.AsteikkoArvosana }
         * 
         * 
         */
        public List<ArvosanaAsteikkoMuuTyyppi.Asteikko.AsteikkoArvosana> getAsteikkoArvosana() {
            if (asteikkoArvosana == null) {
                asteikkoArvosana = new ArrayList<ArvosanaAsteikkoMuuTyyppi.Asteikko.AsteikkoArvosana>();
            }
            return this.asteikkoArvosana;
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


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Koodi">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="20"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Nimi" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="200"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="LaskennallinenArvo" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *               &lt;totalDigits value="24"/>
         *               &lt;fractionDigits value="6"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="avain" use="required" type="{urn:mace:funet.fi:virta/2015/09/01}AvainTyyppi" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "koodi",
            "nimi",
            "laskennallinenArvo"
        })
        public static class AsteikkoArvosana {

            @XmlElement(name = "Koodi", required = true)
            protected String koodi;
            @XmlElement(name = "Nimi")
            protected String nimi;
            @XmlElement(name = "LaskennallinenArvo")
            protected BigDecimal laskennallinenArvo;
            @XmlAttribute(name = "avain", required = true)
            protected String avain;

            /**
             * Gets the value of the koodi property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKoodi() {
                return koodi;
            }

            /**
             * Sets the value of the koodi property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKoodi(String value) {
                this.koodi = value;
            }

            /**
             * Gets the value of the nimi property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNimi() {
                return nimi;
            }

            /**
             * Sets the value of the nimi property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNimi(String value) {
                this.nimi = value;
            }

            /**
             * Gets the value of the laskennallinenArvo property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getLaskennallinenArvo() {
                return laskennallinenArvo;
            }

            /**
             * Sets the value of the laskennallinenArvo property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setLaskennallinenArvo(BigDecimal value) {
                this.laskennallinenArvo = value;
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

    }

}
