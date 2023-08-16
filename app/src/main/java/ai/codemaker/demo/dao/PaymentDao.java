package ai.codemaker.demo.dao;

import ai.codemaker.demo.domain.Payment;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaymentDao implements CrudDao<Payment> {

    private final Session session;

    private static final Logger logger = LoggerFactory.getLogger(PaymentDao.class);

    public PaymentDao(Session session) {
        this.session = session;
    }

    /**
     * Saves the given {@link Payment} to the database.
     *
     * @param payment The {@link Payment} to save. Must not be null.
     * @throws IllegalArgumentException if payment is null.
     * @throws HibernateException if an error occurs while saving the payment.
     */
    public void save(Payment payment) {

    }

    /**
     * Updates the given {@link Payment} object.
     *
     * @param payment The {@link Payment} object to be updated.
     */
    public void update(Payment payment) {

    }

    /**
     * Retrieves the payment from the database.
     *
     * @return payment the payment or null
     */
    public Payment get(String id) {
        return null;
    }

    /**
     * Deletes the payment from the database.
     *
     * @param payment payment to save
     */
    public void delete(Payment payment) {

    }
}
