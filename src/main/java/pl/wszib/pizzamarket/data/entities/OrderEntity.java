package pl.wszib.pizzamarket.data.entities;

import org.springframework.boot.autoconfigure.condition.ConditionalOnCloudPlatform;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "pizza_name")
    private String pizzaName;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "order_address_id")
    private OrderAddressEntity orderAddressId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public OrderAddressEntity getOrderAddressId() {
        return orderAddressId;
    }

    public void setOrderAddressId(OrderAddressEntity orderAddressId) {
        this.orderAddressId = orderAddressId;
    }
}
