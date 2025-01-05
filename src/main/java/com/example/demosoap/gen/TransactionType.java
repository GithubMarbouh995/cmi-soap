//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v4.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
//


package com.example.demosoap.gen;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour transactionType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <pre>{@code
 * <simpleType name="transactionType">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="DEPOSIT"/>
 *     <enumeration value="WITHDRAWAL"/>
 *     <enumeration value="TRANSFER"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "transactionType")
@XmlEnum
public enum TransactionType {

    DEPOSIT,
    WITHDRAWAL,
    TRANSFER;

    public String value() {
        return name();
    }

    public static TransactionType fromValue(String v) {
        return valueOf(v);
    }

}
