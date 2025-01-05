//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v4.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
//


package com.example.demosoap.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="cin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cin"
})
@XmlRootElement(name = "getCustomerByCinRequest")
public class GetCustomerByCinRequest {

    @XmlElement(required = true)
    protected String cin;

    /**
     * Obtient la valeur de la propriété cin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCin() {
        return cin;
    }

    /**
     * Définit la valeur de la propriété cin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCin(String value) {
        this.cin = value;
    }

}
