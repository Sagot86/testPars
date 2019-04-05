package parser.repo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import parser.model.ParsedData;
import parser.utils.HibernateSessionFactoryUtil;

import java.util.Collections;
import java.util.List;

public class ParsedDataRepo {

    private org.hibernate.SessionFactory sessionFactory = HibernateSessionFactoryUtil.sessionFactory;
    private Session currentSession;
    private Transaction currentTransaction;

    public ParsedDataRepo() {
    }

    private Session openCurrentSession() {
        currentSession = sessionFactory.openSession();
        return currentSession;
    }

    private Session openCurrentSessionWithTransaction() {
        currentSession = sessionFactory.openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    private void closeCurrentSession() {
        currentSession.close();
    }

    private void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    /**
     * Вставка массива
     */
    public void save(List<ParsedData> data) {
        try (Session session = openCurrentSession()) {
            Transaction transaction = session.beginTransaction();

            for (int i = 0; i < data.size(); i++) {
                session.save(data.get(i));

                if (i % 40 == 0) {
                    session.flush();
                    session.clear();
                }
            }
            transaction.commit();
        }
    }

    /**
     * Выборка значений по первому запросу
     */
    public List<ParsedData> getFirst() {
        return Collections.emptyList();
    }

    /**
     * Выборка значений по второму запросу
     */
    public List<ParsedData> getSecond() {
        return Collections.emptyList();
    }

    /**
     * Выборка значений по третьему запросу
     */
    public List<ParsedData> getThird() {
        return Collections.emptyList();
    }


}
