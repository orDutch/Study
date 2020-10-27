
package my.experiments.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for feelResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="feelResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Kitty" type="{http://services.experiments.my/}liveMetrics" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "feelResponse", propOrder = {
    "kitty"
})
public class FeelResponse {

    @XmlElement(name = "Kitty")
    protected LiveMetrics kitty;

    /**
     * Gets the value of the kitty property.
     * 
     * @return
     *     possible object is
     *     {@link LiveMetrics }
     *     
     */
    public LiveMetrics getKitty() {
        return kitty;
    }

    /**
     * Sets the value of the kitty property.
     * 
     * @param value
     *     allowed object is
     *     {@link LiveMetrics }
     *     
     */
    public void setKitty(LiveMetrics value) {
        this.kitty = value;
    }

}
