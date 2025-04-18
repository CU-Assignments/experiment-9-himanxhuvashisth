
package com.example.service;

import com.example.model.Account;
import com.example.model.TransactionRecord;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.example.util.HibernateUtil.getSessionFactory;

@Service
public class BankService {

    public void transferMoney(int fromId, int toId, double amount) {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Account from = session.get(Account.class, fromId);
            Account to = session.get(Account.class, toId);

            if (from.getBalance() < amount) {
                throw new RuntimeException("Insufficient funds");
            }

            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);

            session.update(from);
            session.update(to);
            session.save(new TransactionRecord(fromId, toId, amount, new Date()));

            tx.commit();
            System.out.println("Transaction successful!");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println("Transaction failed: " + e.getMessage());
        } finally {
            session.close();
        }
    }
}
