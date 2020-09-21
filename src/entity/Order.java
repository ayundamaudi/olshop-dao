package entity;

import java.sql.Timestamp;
import java.util.List;

public class Order {
    private int idOrder;
    private Admin admin;
    private Customer customer;
    private Address address;
    private OrderMethod orderMethod;
    private double shippingFee;
    private double subtotal;
    private String status;
    private java.sql.Timestamp createdOrder;
    private java.sql.Timestamp createdProses;
    private List<OrderDetail> listOfOrderDetail;

    public Order() {

    }

    public Order(int idOrder, Admin admin, Customer customer, Address address, OrderMethod orderMethod,
            double shippingFee, double subtotal, String status, Timestamp createdOrder, Timestamp createdProses,
            List<OrderDetail> listOfOrderDetail) {
        this.idOrder = idOrder;
        this.admin = admin;
        this.customer = customer;
        this.address = address;
        this.orderMethod = orderMethod;
        this.shippingFee = shippingFee;
        this.subtotal = subtotal;
        this.status = status;
        this.createdOrder = createdOrder;
        this.createdProses = createdProses;
        this.listOfOrderDetail = listOfOrderDetail;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public OrderMethod getOrderMethod() {
        return orderMethod;
    }

    public void setOrderMethod(OrderMethod orderMethod) {
        this.orderMethod = orderMethod;
    }

    public double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(double shippingFee) {
        this.shippingFee = shippingFee;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public java.sql.Timestamp getCreatedOrder() {
        return createdOrder;
    }

    public void setCreatedOrder(java.sql.Timestamp createdOrder) {
        this.createdOrder = createdOrder;
    }

    public java.sql.Timestamp getCreatedProses() {
        return createdProses;
    }

    public void setCreatedProses(java.sql.Timestamp createdProses) {
        this.createdProses = createdProses;
    }

    public List<OrderDetail> getListOfOrderDetail() {
        return listOfOrderDetail;
    }

    public void setListOfOrderDetail(List<OrderDetail> listOfOrderDetail) {
        this.listOfOrderDetail = listOfOrderDetail;
    }

}

