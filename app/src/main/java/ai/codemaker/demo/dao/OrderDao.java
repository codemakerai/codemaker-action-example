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
     * @param order The {@link Order} to save. Must not be null.
     * @throws IllegalArgumentException if Order is null.
     * @throws HibernateException if an error occurs while saving the Order.
     */
    public void save(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order must not be null");
        }
        try {
            session.save(order);
        } catch (HibernateException e) {
            logger.error("Error while saving Order", e);
            throw e;
        }
    }

    /**
     * Updates the given {@link Order} object.
     *
     * @param order The {@link Order} object to be updated.
     */
    public void update(Order order) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(order);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error while updating order: " + order, e);
        }
    }

    /**
     * Retrieves the Order from the database.
     *
     * @return Order the Order or null
     */
    public Order get(String id) {
        try {
            Transaction transaction = session.beginTransaction();
            Order order = session.get(Order.class, id);
            transaction.commit();
            return order;
        } catch (Exception e) {
            logger.error("Error retrieving order with id: " + id, e);
            return null;
        }
    }

    /**
     * Deletes the Order from the database.
     *
     * @param order Order to save
     */
    public void delete(Order order) {
        try {
            session.beginTransaction();
            session.delete(order);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.error("Error deleting order: " + e.getMessage());
            session.getTransaction().rollback();
        }
    }
}
