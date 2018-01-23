import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtil;

public class Main {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
	}
}
