
package my.experiments.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for feedResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="feedResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Kitty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "feedResponse", propOrder = {
    "kitty"
})
public class FeedResponse {

    @XmlElement(name = "Kitty")
    protected String kitty;

    /**
     * Gets the value of the kitty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKitty() {
        return kitty;
    }

    /**
     * Sets the value of the kitty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKitty(String value) {
        this.kitty = value;
    }

}
