//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v4.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
//


package com.example.demosoap.gen;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour transactionStatus.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <pre>{@code
 * <simpleType name="transactionStatus">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="PENDING"/>
 *     <enumeration value="COMPLETED"/>
 *     <enumeration value="FAILED"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "transactionStatus")
@XmlEnum
public enum TransactionStatus {

    PENDING,
    COMPLETED,
    FAILED;

    public String value() {
        return name();
    }

    public static TransactionStatus fromValue(String v) {
        return valueOf(v);
    }

}
