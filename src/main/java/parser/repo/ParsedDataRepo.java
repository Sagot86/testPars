package parser.repo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import parser.model.ParsedData;
import parser.utils.HibernateSessionFactoryUtil;

import java.util.List;
import java.util.Map;

public class ParsedDataRepo {

    private org.hibernate.SessionFactory sessionFactory = HibernateSessionFactoryUtil.sessionFactory;

    public ParsedDataRepo() {
    }

    /**
     * Вставка результа парсинга
     */
    public void save(List<ParsedData> data) {
        try (Session currentSession = sessionFactory.openSession()) {
            Transaction transaction = currentSession.beginTransaction();

            for (int i = 0; i < data.size(); i++) {
                currentSession.save(data.get(i));

                if (i % 20 == 0) {
                    currentSession.flush();
                    currentSession.clear();
                }
            }
            currentSession.flush();
            currentSession.clear();
            transaction.commit();
        }
    }

    /**
     * Вывести список пользователей и используемых ими форм за последний час
     * <p>
     * (К сожалению, HQL не умеет в INTERVAL, а SQL я не хочу:
     */
    @SuppressWarnings("unchecked")
    public List<Map<String, String>> getFirst() {
        String select = "SELECT new Map(ssoid as UserID,formid as FormName) from ParsedData where " +
                "not ssoid = '' and " +
                "not formid = '' and " +
                "date_part('hour', ymdh) between (date_part('hour', current_timestamp) - 1) and date_part('hour', current_timestamp) " +
                "ORDER BY ssoid";
        try (Session currentSession = sessionFactory.openSession()) {
            return currentSession
                    .createQuery(select)
                    .list();
        }
    }

    /**
     * Вывести список пользователей, которые начали активность на форме и не дошли до конца.
     * Например, для услуг grp dszn_* начальное состояние start, конечное состояние send. Вывести на каком шаге остановился.
     */
    @SuppressWarnings("unchecked")
    public List<Map<String, String>> getSecond() {
        String select = "SELECT DISTINCT new Map(ssoid as UserID,subtype as Step) FROM ParsedData WHERE ssoid NOT IN" +
                "(SELECT ssoid FROM ParsedData WHERE data_subtype = 'send' or data_subtype = 'success' or data_subtype = 'after' or data_subtype = 'sent' or data_subtype = 'done' or data_subtype = '' )" +
                "AND NOT data_subtype = 'start' AND NOT data_subtype = 'before' " +
                "ORDER BY ssoid";
        try (Session currentSession = sessionFactory.openSession()) {
            return currentSession
                    .createQuery(select)
                    .list();
        }
    }


    /**
     * Составить ТОП – 5 самых используемых форм.
     */
    @SuppressWarnings("unchecked")
    public List<Map<Object, Object>> getThird() {
        String select = "SELECT new Map(formid as Form, count(formid) as UseCount) from ParsedData " +
                "where not formid = '' " +
                "group by formid " +
                "order by count(formid) desc";
        try (Session currentSession = sessionFactory.openSession()) {
            return currentSession
                    .createQuery(select)
                    .setMaxResults(5)
                    .list();
        }
    }
}
