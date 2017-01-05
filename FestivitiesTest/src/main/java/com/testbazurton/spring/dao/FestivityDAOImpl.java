package com.testbazurton.spring.dao;

import com.testbazurton.spring.model.FestivityE;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * DAO implementation with hibernate
 *
 * @author Nychol Bazuto
 */
@Repository
public class FestivityDAOImpl implements FestivityDAO {

    /**
     * Logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(FestivityDAOImpl.class);

    /**
     * Object to map with hibernate.
     */
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    /**
     * Add a new festivity to the database.
     *
     * @param f Festivity to add.
     * @return String with the view.
     */
    @Override
    public void addFestivity(FestivityE f) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(f);
        logger.info("Festivity saved successfully, Festivity details=" + f);
    }

    /**
     * Add a new festivity to the database.
     *
     * @param f Festivity to add.
     * @return String with the view.
     */
    @Override
    public void updateFestivity(FestivityE f) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(f);
        logger.info("Person updated successfully, Person Details=" + f);
    }

    /**
     * Add a new festivity to the database.
     *
     * @param f Festivity to add.
     * @return String with the view.
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<FestivityE> listFestivities() {
        Session session = this.sessionFactory.getCurrentSession();
        List<FestivityE> festivitiesList = session.createQuery("from Festivities").list();
        for (FestivityE f : festivitiesList) {
            logger.info("Festivities List::" + f);
        }
        return festivitiesList;
    }

    /**
     * Add a new festivity to the database.
     *
     * @param f Festivity to add.
     * @return String with the view.
     */
    @Override
    public FestivityE getFestivityById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        FestivityE f = (FestivityE) session.load(FestivityE.class, new Integer(id));
        logger.info("Festivity loaded successfully, Festivity details=" + f);
        return f;
    }

    /**
     * Add a new festivity to the database.
     *
     * @param f Festivity to add.
     * @return String with the view.
     */
    @Override
    public void removeFestivity(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        FestivityE p = (FestivityE) session.load(FestivityE.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
        logger.info("Festivity deleted successfully, Festivity details=" + p);
    }

    @Override
    public List<FestivityE> getFestivityByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        List<FestivityE> festivitiesList = session.createQuery("from Festivities where name = :pName ").setParameter("pName", name).list();
        System.out.println(festivitiesList);
        for (FestivityE f : festivitiesList) {
            logger.info("Festivities List::" + f);
        }
        return festivitiesList;

    }

    /**
     * Add a new festivity to the database.
     *
     * @param f Festivity to add.
     * @return String with the view.
     */
    @Override
    public List<FestivityE> getFestivityByStartDate(String date) {
        Session session = this.sessionFactory.getCurrentSession();
        List<FestivityE> festivitiesList = session.createQuery("from Festivities where startdate = :pSDate ").setParameter("pSDate", date).list();
        for (FestivityE f : festivitiesList) {
            logger.info("Festivities List::" + f);
        }
        return festivitiesList;
    }

    /**
     * Add a new festivity to the database.
     *
     * @param f Festivity to add.
     * @return String with the view.
     */
    @Override
    public List<FestivityE> getFestivityByRangeDate(String startDate, String endDate) {
        Session session = this.sessionFactory.getCurrentSession();
        List<FestivityE> festivitiesList = session.createQuery("from Festivities where startdate  between  :pSDate and :pEDate ").setParameter("pSDate", startDate).setParameter("pEDate", endDate).list();
        for (FestivityE f : festivitiesList) {
            logger.info("Festivities List::" + f);
        }
        return festivitiesList;
    }

    /**
     * Add a new festivity to the database.
     *
     * @param f Festivity to add.
     * @return String with the view.
     */
    @Override
    public List<FestivityE> getFestivityByPlace(String place) {
        Session session = this.sessionFactory.getCurrentSession();
        List<FestivityE> festivitiesList = session.createQuery("from Festivities where place = :pPlace ").setParameter("pPlace", place).list();
        for (FestivityE f : festivitiesList) {
            logger.info("Festivities List::" + f);
        }
        return festivitiesList;
    }

}
