package com.example.jacketwholesaler.models.entities;

import com.example.jacketwholesaler.models.enums.DocumentType;
import com.example.jacketwholesaler.models.enums.OrderStatus;
import com.example.jacketwholesaler.models.enums.PaymentMethod;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "order_table")
public class Order extends EntityBase {

    @Column
    private LocalDateTime orderDate;

    @Column
    private PaymentMethod paymentMethod;

    @Column
    private DocumentType documentType;

    @Column
    private OrderStatus status = OrderStatus.CREATING;

    @Column
    private LocalDateTime opinionSendDate;

    @Column
    @Min(1)
    @Max(5)
    private int opinionRate;

    @Column
    private String description;

    @Column
    private String streetName;

    @Column
    private int streetNumber;

    @Column
    private Integer apartmentNumber;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<Discount> discounts = new ArrayList<>();

    @ManyToOne
    private CustomerServiceEmployee employee;

    public Order() {
    }

    public Order(LocalDateTime orderDate, PaymentMethod paymentMethod, DocumentType documentType, OrderStatus status, String description, String streetName, int streetNumber) {
        this.orderDate = orderDate;
        this.paymentMethod = paymentMethod;
        this.documentType = documentType;
        this.status = status;
        this.description = description;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }

    public Order(LocalDateTime orderDate, PaymentMethod paymentMethod, DocumentType documentType, OrderStatus status, String streetName, int streetNumber, Integer apartmentNumber) {
        this.orderDate = orderDate;
        this.paymentMethod = paymentMethod;
        this.documentType = documentType;
        this.status = status;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getOpinionSendDate() {
        return opinionSendDate;
    }

    public void setOpinionSendDate(LocalDateTime opinionSendDate) {
        this.opinionSendDate = opinionSendDate;
    }

    public int getOpinionRate() {
        return opinionRate;
    }

    public void setOpinionRate(int opinionRate) {
        this.opinionRate = opinionRate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Integer getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(Integer apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public CustomerServiceEmployee getEmployee() {
        return employee;
    }

    public void setEmployee(CustomerServiceEmployee employee) {
        this.employee = employee;
    }
}
