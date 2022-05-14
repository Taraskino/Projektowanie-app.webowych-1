package pl.wszib.pizzamarket.services;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wszib.pizzamarket.data.entities.OrderAddressEntity;
import pl.wszib.pizzamarket.data.entities.OrderEntity;
import pl.wszib.pizzamarket.data.entities.PizzaEntity;
import pl.wszib.pizzamarket.data.repositories.OrderRepository;
import pl.wszib.pizzamarket.data.repositories.PizzaRepository;
import pl.wszib.pizzamarket.web.mappers.OrderAddressMapper;
import pl.wszib.pizzamarket.web.models.OrderAddressModel;
import javax.persistence.EntityNotFoundException;
@Service
public class OrderService {

    private final PizzaRepository pizzaRepository;
    private final OrderRepository orderRepository;
    public OrderService(PizzaRepository pizzaRepository, OrderRepository orderRepository) {
        this.pizzaRepository = pizzaRepository;
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void saveOrder(long pizzaId, OrderAddressModel orderAddressModel){
        PizzaEntity pizzaEntity = pizzaRepository.findById(pizzaId).orElseThrow(EntityNotFoundException::new);
        OrderAddressEntity orderAddressEntity = OrderAddressMapper.toEntity(orderAddressModel);
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setPizzaName(pizzaEntity.getName());
        orderEntity.setOrderAddress(orderAddressEntity);
        orderRepository.save(orderEntity);
    }
}