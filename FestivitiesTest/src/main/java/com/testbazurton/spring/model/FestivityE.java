/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testbazurton.spring.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity  bean to represent Festivity object, hanldes JPA annotations.
 * @author Nychol Bazurto
 */
@Entity(name = "Festivities")
@Table(name = "Festivities")
public class FestivityE {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Name of the festivity.
     */
    private String name;

    /**
     * Date which festivity starts.
     */
    private Date startDate;

    /**
     * Date which festivity ends.
     */
    private Date endDate;

    /**
     * Place of the festivity.
     */
    private String place;

    /**
     * Return festivity's id.
     *
     * @return Festivity's ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Modify festivity's id.
     *
     * @param id Festivity's ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return festivity's name.
     *
     * @return Festivity's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Modify festivity's name.
     *
     * @param pName Festivity's name.
     */
    public void setName(String pName) {
        this.name = pName;
    }

    /**
     * Return the date the festivity stars.
     *
     * @return Festivity's start date.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Modify the date the festivity stars.
     *
     * @param pStartDate Festivity's start date.
     */
    public void setStartDate(Date pStartDate) {
        this.startDate = pStartDate;
    }

    /**
     * Return the date the festivity ends.
     *
     * @return Festivity's end date.
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Modify the date the festivity ends.
     *
     * @param pEndDate Festivity's end date.
     */
    public void setEndDate(Date pEndDate) {
        this.endDate = pEndDate;
    }

    /**
     * Return festivity's place.
     *
     * @return Festivity's place.
     */
    public String getPlace() {
        return place;
    }

    /**
     * Modify festivity's place.
     *
     * @param pPlace Festivity's place.
     */
    public void setPlace(String pPlace) {
        this.place = pPlace;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", country=" + place;
    }
}
