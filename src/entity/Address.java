package entity;

public class Address {
    private int idAddress;
    private PostalCode postalCode;
    private Customer customer;
    private String address;
    private String noTlp;

    public Address() {

    }

	public Address(int idAddress, PostalCode postalCode, Customer customer, String address, String noTlp) {
		this.idAddress = idAddress;
		this.postalCode = postalCode;
		this.customer = customer;
        this.address = address;
        this.noTlp = noTlp;
	}

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public PostalCode getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(PostalCode postalCode) {
        this.postalCode = postalCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNoTlp() {
        return noTlp;
    }

    public void setNoTlp(String noTlp) {
        this.noTlp = noTlp;
    }

}
