//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v4.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
//


package com.example.demosoap.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
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
 *         <element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "accountId"
})
@XmlRootElement(name = "getTransactionsByAccountRequest")
public class GetTransactionsByAccountRequest {

    protected long accountId;

    /**
     * Obtient la valeur de la propriété accountId.
     * 
     */
    public long getAccountId() {
        return accountId;
    }

    /**
     * Définit la valeur de la propriété accountId.
     * 
     */
    public void setAccountId(long value) {
        this.accountId = value;
    }

}
