package com.testbazurton.spring.dao;

import com.testbazurton.spring.model.FestivityE;
import java.util.List;

/**
 * DAO interface.
 * @author Nychol Bazuto
 */
public interface FestivityDAO {

	public void addFestivity(FestivityE f);
	public void updateFestivity(FestivityE f);
	public List<FestivityE> listFestivities();
	public FestivityE getFestivityById(int id);
        public List<FestivityE> getFestivityByName(String name);
        public List<FestivityE> getFestivityByStartDate(String date);
        public List<FestivityE> getFestivityByRangeDate(String start, String end);
        public List<FestivityE> getFestivityByPlace(String place);
	public void removeFestivity(int id);
}
