package ai.codemaker.demo.domain;

import java.time.Instant;
import java.util.Collection;

public class Order {

    private String id;

    private String customerId;

    private String addressId;

    private Collection<String> productsIds;

    private Instant createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public Collection<String> getProductsIds() {
        return productsIds;
    }

    public void setProductsIds(Collection<String> productsIds) {
        this.productsIds = productsIds;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }
}
