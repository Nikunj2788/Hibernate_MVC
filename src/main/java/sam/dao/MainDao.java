package sam.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sam.bean.MainBean;
import sam.util.HibernateUtil;

public class MainDao {

    public String doRegister(MainBean mainBean) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        String msg;

        try {
            transaction = session.beginTransaction();
            session.save(mainBean);
            transaction.commit();
            msg = "Data registered successfully";
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            msg = "Something went wrong";
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return msg;
    }
}
