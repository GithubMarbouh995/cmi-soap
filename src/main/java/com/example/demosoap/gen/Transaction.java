//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v4.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
//


package com.example.demosoap.gen;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour transaction complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>{@code
 * <complexType name="transaction">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         <element name="transactionNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="amount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         <element name="type" type="{http://www.example.com/demosoap/gen}transactionType"/>
 *         <element name="status" type="{http://www.example.com/demosoap/gen}transactionStatus"/>
 *         <element name="sourceAccountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         <element name="destinationAccountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         <element name="createdAt" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transaction", propOrder = {
    "id",
    "transactionNumber",
    "amount",
    "type",
    "status",
    "sourceAccountId",
    "destinationAccountId",
    "createdAt"
})
public class Transaction {

    protected Long id;
    protected String transactionNumber;
    protected double amount;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TransactionType type;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TransactionStatus status;
    protected Long sourceAccountId;
    protected Long destinationAccountId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdAt;

    /**
     * Obtient la valeur de la propriété id.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété transactionNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionNumber() {
        return transactionNumber;
    }

    /**
     * Définit la valeur de la propriété transactionNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionNumber(String value) {
        this.transactionNumber = value;
    }

    /**
     * Obtient la valeur de la propriété amount.
     * 
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Définit la valeur de la propriété amount.
     * 
     */
    public void setAmount(double value) {
        this.amount = value;
    }

    /**
     * Obtient la valeur de la propriété type.
     * 
     * @return
     *     possible object is
     *     {@link TransactionType }
     *     
     */
    public TransactionType getType() {
        return type;
    }

    /**
     * Définit la valeur de la propriété type.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionType }
     *     
     */
    public void setType(TransactionType value) {
        this.type = value;
    }

    /**
     * Obtient la valeur de la propriété status.
     * 
     * @return
     *     possible object is
     *     {@link TransactionStatus }
     *     
     */
    public TransactionStatus getStatus() {
        return status;
    }

    /**
     * Définit la valeur de la propriété status.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionStatus }
     *     
     */
    public void setStatus(TransactionStatus value) {
        this.status = value;
    }

    /**
     * Obtient la valeur de la propriété sourceAccountId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSourceAccountId() {
        return sourceAccountId;
    }

    /**
     * Définit la valeur de la propriété sourceAccountId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSourceAccountId(Long value) {
        this.sourceAccountId = value;
    }

    /**
     * Obtient la valeur de la propriété destinationAccountId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDestinationAccountId() {
        return destinationAccountId;
    }

    /**
     * Définit la valeur de la propriété destinationAccountId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDestinationAccountId(Long value) {
        this.destinationAccountId = value;
    }

    /**
     * Obtient la valeur de la propriété createdAt.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedAt() {
        return createdAt;
    }

    /**
     * Définit la valeur de la propriété createdAt.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedAt(XMLGregorianCalendar value) {
        this.createdAt = value;
    }

}
