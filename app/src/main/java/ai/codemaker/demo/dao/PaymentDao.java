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

    public void save(Payment payment) {
        if (payment == null) {
            throw new IllegalArgumentException("Payment must not be null");
        }
        try {
            session.save(payment);
        } catch (HibernateException e) {
            logger.error("Error while saving payment", e);
            throw e;
        }
    }

    public void update(Payment payment) {
        try {
            session.beginTransaction();
            session.update(payment);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.error("Error while updating payment: " + e.getMessage());
            session.getTransaction().rollback();
        }
    }

    public Payment get(String id) {
        Payment payment = null;
        try {
            Session session = this.session;
            Query query = session.createQuery("from Payment where id = :id");
            query.setParameter("id", id);
            payment = (Payment) query.uniqueResult();
        } catch (Exception e) {
            logger.error("Error retrieving payment with id: " + id, e);
        }
        return payment;
    }

    public void delete(Payment payment) {
        try {
            session.beginTransaction();
            session.delete(payment);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.error("Error deleting payment: " + e.getMessage());
            session.getTransaction().rollback();
        }
    }
}
