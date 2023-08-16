package ai.codemaker.demo.dao;

import ai.codemaker.demo.domain.Order;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderDao implements CrudDao<Order> {

    private final Session session;

    private static final Logger logger = LoggerFactory.getLogger(OrderDao.class);

    public OrderDao(Session session) {
        this.session = session;
    }

    /**
     * Saves the given {@link Order} to the database.
     *
     * @param Order The {@link Order} to save. Must not be null.
     * @throws IllegalArgumentException if Order is null.
     * @throws HibernateException if an error occurs while saving the Order.
     */
    public void save(Order Order) {

    }

    /**
     * Updates the given {@link Order} object.
     *
     * @param Order The {@link Order} object to be updated.
     */
    public void update(Order Order) {

    }

    /**
     * Retrieves the Order from the database.
     *
     * @return Order the Order or null
     */
    public Order get(String id) {
        return null;
    }

    /**
     * Deletes the Order from the database.
     *
     * @param Order Order to save
     */
    public void delete(Order Order) {

    }
}
