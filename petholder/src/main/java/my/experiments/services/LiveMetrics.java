
package my.experiments.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for liveMetrics complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="liveMetrics"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="face" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="health" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="hunger" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="infection" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="mood" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="thirst" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "liveMetrics", propOrder = {
    "face",
    "health",
    "hunger",
    "infection",
    "mood",
    "thirst"
})
public class LiveMetrics {

    protected String face;
    protected int health;
    protected int hunger;
    protected int infection;
    protected String mood;
    protected int thirst;

    /**
     * Gets the value of the face property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFace() {
        return face;
    }

    /**
     * Sets the value of the face property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFace(String value) {
        this.face = value;
    }

    /**
     * Gets the value of the health property.
     * 
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets the value of the health property.
     * 
     */
    public void setHealth(int value) {
        this.health = value;
    }

    /**
     * Gets the value of the hunger property.
     * 
     */
    public int getHunger() {
        return hunger;
    }

    /**
     * Sets the value of the hunger property.
     * 
     */
    public void setHunger(int value) {
        this.hunger = value;
    }

    /**
     * Gets the value of the infection property.
     * 
     */
    public int getInfection() {
        return infection;
    }

    /**
     * Sets the value of the infection property.
     * 
     */
    public void setInfection(int value) {
        this.infection = value;
    }

    /**
     * Gets the value of the mood property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMood() {
        return mood;
    }

    /**
     * Sets the value of the mood property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMood(String value) {
        this.mood = value;
    }

    /**
     * Gets the value of the thirst property.
     * 
     */
    public int getThirst() {
        return thirst;
    }

    /**
     * Sets the value of the thirst property.
     * 
     */
    public void setThirst(int value) {
        this.thirst = value;
    }

}
