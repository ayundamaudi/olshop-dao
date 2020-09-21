package entity;

public class OrderMethod {
    private int idMethod;
    private String method;

    public OrderMethod(){

    }

    public OrderMethod(int idMethod, String method) {
        this.idMethod = idMethod;
        this.method = method;
    }

    public int getIdMethod() {
        return idMethod;
    }

    public void setIdMethod(int idMethod) {
        this.idMethod = idMethod;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    // public void addOrderMethod(OrderMethod orderMethod) {
    //     this.listOrderMethod.add(orderMethod);
    // }
}
