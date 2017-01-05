package com.testbazurton.spring.service;

import com.testbazurton.spring.dao.FestivityDAO;
import com.testbazurton.spring.model.FestivityE;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class to handle DAO operations.
 *
 * @author Nyny
 */
@Service
public class FestivityServiceImpl implements FestivityService {

    /**
     * DAO object.
     */
    private FestivityDAO festivityDAO;

    public void setFestivityDAO(FestivityDAO pFestivityDAO) {
        this.festivityDAO = pFestivityDAO;
    }

    /**
     * Add a new festivity.
     *
     * @param f Festivity to add by DAO object.
     */
    @Override
    @Transactional
    public void addFestivity(FestivityE f) {
        this.festivityDAO.addFestivity(f);
    }

    /**
     * Modify a new festivity.
     *
     * @param f Festivity to modify by DAO object.
     */
    @Override
    @Transactional
    public void updateFestivity(FestivityE p) {
        this.festivityDAO.updateFestivity(p);
    }

    /**
     * Return a festivities list.
     *
     * @return Festivities list.
     */
    @Override
    @Transactional
    public List<FestivityE> listFestivities() {
        return this.festivityDAO.listFestivities();
    }

    /**
     * Return the festivity with the id given by parameter.
     *
     * @return Festivity with the id given.
     */
    @Override
    @Transactional
    public FestivityE getFestivityById(int id) {
        return this.festivityDAO.getFestivityById(id);
    }

    /**
     * Remove the festivity with the id given by parameter.
     *
     * @param id Festivity's id.
     */
    @Override
    @Transactional
    public void removeFestivity(int id) {
        this.festivityDAO.removeFestivity(id);
    }

    /**
     * Return a list with the festivity with the name given by parameter.
     *
     * @param name Festivity's name.
     * @return Festivities list.
     */
    @Override
    @Transactional
    public List<FestivityE> getFestivityByName(String name) {
        return this.festivityDAO.getFestivityByName(name);
    }

    /**
     * Return a list with the festivity with the star date given by parameter.
     *
     * @param date Festivity's date.
     * @return Festivities list.
     */
    @Override
    @Transactional
    public List<FestivityE> getFestivityByStartDate(String date) {
        return this.festivityDAO.getFestivityByStartDate(date);
    }

    /**
     * Return a list with the festivity with the place given by parameter.
     *
     * @param date Festivity's place.
     * @return Festivities list.
     */
    @Override
    @Transactional
    public List<FestivityE> getFestivityByPlace(String place) {
        return this.festivityDAO.getFestivityByPlace(place);
    }

    /**
     * Return a list with the festivity with the range given by parameter.
     *
     * @param start Festivity's start date.
     * @param end Festivity's end date.
     * @return Festivities list.
     */
    @Override
    @Transactional
    public List<FestivityE> getFestivityByRangeDate(String start, String end) {
        return this.festivityDAO.getFestivityByRangeDate(start, end);
    }
}
