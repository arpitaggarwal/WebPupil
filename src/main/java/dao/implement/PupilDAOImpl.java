package dao.implement;

import dao.PupilDAO;
import entities.Pupil;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bohdan on 27.08.15.
 * Data access object
 */
@Repository
public class PupilDAOImpl implements PupilDAO {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static Session getCurrentSession(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session;
    }

    public static void closeCurrentSession(Session session){
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Get all pupils
     * @return all pupils from database
     * */
    public List<Pupil> getAllPupils() {
        Session session = getCurrentSession();
        List<Pupil> pupilList = session.createCriteria(Pupil.class).list();
        closeCurrentSession(session);
        return pupilList;
    }
    /**
     * Return pupil by id
     * @param id number record in database
     * @return pupil model
     * */
    public Pupil getPupilById(Long id) {
        Session session = getCurrentSession();
        Pupil pupil = (Pupil)session.get(Pupil.class, id);
        closeCurrentSession(session);
        return pupil;
    }
    /**
     * Return pupil with level HI
     * @param level value level
     * @return list pupil with level HI
     * */
    public List<Pupil> getPupilByLevel(String level) {
        Session session = getCurrentSession();
        Filter filter = session.enableFilter("levelFilter");
        filter.setParameter("levelParam", level);
        List<Pupil> pupilList = session.createCriteria(Pupil.class).list();
        closeCurrentSession(session);
        return pupilList;
    }
    /**
     * Edit exist pupil
     * @param id number pupil for edit
     * @param pupil new model pupil
     * */
    public void changePupil(Long id, Pupil pupil) {
        Session session = getCurrentSession();
        Pupil changePupil = (Pupil)session.get(Pupil.class, id);
        if(pupil.getName() != null){
            if(!pupil.getName().equals(changePupil.getName())){
                changePupil.setName(pupil.getName());
            }
        }
        if(pupil.getLevel() != null){
            if(!pupil.getLevel().equals(changePupil.getLevel())){
                changePupil.setLevel(pupil.getLevel());
            }
        }
        if(pupil.getLast() != null){
            if(!pupil.getLast().equals(changePupil.getLast())){
                changePupil.setLast(pupil.getLast());
            }
        }
        if(pupil.getGroup() != null){
            if(!pupil.getGroup().equals(changePupil.getGroup())){
                changePupil.setGroup(pupil.getGroup());
            }
        }
        if(pupil.getAddress() != null){
            if(!pupil.getAddress().equals(changePupil.getAddress())){
                changePupil.setAddress(pupil.getAddress());
            }
        }
        session.update(changePupil);
        closeCurrentSession(session);
    }
    /**
     * Delete pupil from database
     * @param id number pupil in database
     * */
    public void deletePupil(Long id) {
        Session session = getCurrentSession();
        Pupil pupil = (Pupil)session.get(Pupil.class, id);
        session.delete(pupil);
        closeCurrentSession(session);
    }
    /**
     * Add pupil in database
     * @param pupil model pupil
     * @return number row in database
     * */
    public Long addPupil(Pupil pupil) {
        Session session = getCurrentSession();
        Long id = (Long)session.save(pupil);
        closeCurrentSession(session);
        return id;
    }
}
