package parser.repo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import parser.model.ParsedData;
import parser.utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
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

                if (i % 20 == 0) {
                    session.flush();
                    session.clear();
                }

            }
            session.flush();
            session.clear();
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
     *
     * SELECT * FROM parsed_data WHERE ssoid NOT IN
     * (SELECT ssoid FROM parsed_data  WHERE data_subtype = 'send' or data_subtype = 'success' or data_subtype = 'after' or data_subtype = 'sent' or data_subtype = 'done')
     * AND NOT data_subtype = 'start' AND NOT data_subtype = 'before' AND NOT data_subtype = ''
     * order by ssoid;
     *
     */
    @SuppressWarnings("unchecked")
    public List<ParsedData> getSecond() {
        String select = "FROM ParsedData WHERE ssoid NOT IN" +
                "(SELECT ssoid FROM ParsedData WHERE data_subtype = 'send' or data_subtype = 'success' or data_subtype = 'after' or data_subtype = 'sent' or data_subtype = 'done')" +
                "AND NOT data_subtype = 'start' AND NOT data_subtype = 'before' AND NOT data_subtype = ''" +
                "ORDER BY ssoid";
        List<ParsedData> parsedData = (ArrayList<ParsedData>)openCurrentSession().createQuery(select).list();
        closeCurrentSession();
        return parsedData;
    }



    /**
     * Выборка значений по третьему запросу
     *
     * SELECT formid,count(formid) as count from parsed_data
     * where not formid = ''
     * group by formid
     * order by count desc;
     *
     */
    @SuppressWarnings("unchecked")
    public List<ParsedData> getThird() {
        return Collections.emptyList();
    }


}
