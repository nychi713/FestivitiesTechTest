package com.testbazurton.spring.service;


import com.testbazurton.spring.model.FestivityE;
import java.util.List;

/**
 * Service interface.
 * @author Nychol Bazuto
 */
public interface FestivityService {

	public void addFestivity(FestivityE f);
	public void updateFestivity(FestivityE f);
	public List<FestivityE> listFestivities();
	public FestivityE getFestivityById(int id);
        public List<FestivityE> getFestivityByName(String name);
        public List<FestivityE> getFestivityByStartDate(String date);
        public List<FestivityE> getFestivityByRangeDate(String date, String end);
        public List<FestivityE> getFestivityByPlace(String place);
	public void removeFestivity(int id);
	
}
