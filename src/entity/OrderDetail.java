package entity;

import java.util.List;

public class OrderDetail {
    private int idOrderDetail;
    private Order order;
    private Product product;
    private int qtyProduct;
    private List<Product> lisProducts;

    public OrderDetail(){

    }

    public OrderDetail(int idOrderDetail, Order order, Product product, int qtyProduct, List<Product> lisProducts) {
        this.idOrderDetail = idOrderDetail;
        this.order = order;
        this.product = product;
        this.qtyProduct = qtyProduct;
        this.lisProducts = lisProducts;
    }

    public int getIdOrderDetail() {
        return idOrderDetail;
    }

    public void setIdOrderDetail(int idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQtyProduct() {
        return qtyProduct;
    }

    public void setQtyProduct(int qtyProduct) {
        this.qtyProduct = qtyProduct;
    }

    public List<Product> getLisProducts() {
        return lisProducts;
    }

    public void setLisProducts(List<Product> lisProducts) {
        this.lisProducts = lisProducts;
    }


}
