package com.testbazurton.spring;

import com.testbazurton.spring.model.FestivityE;
import com.testbazurton.spring.service.FestivityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.http.HttpStatus;

/**
 * Controller which receives request and sent view.
 */
@Controller
public class FestivityController {

    private FestivityService festivityService;

    @Autowired(required = true)
    @Qualifier(value = "festivityService")
    public void setFestivityService(FestivityService fs) {
        this.festivityService = fs;
    }

    /**
     * Return a list with all festivities.
     *
     * @return String with the view.
     */
    @RequestMapping(value = "/festivities", method = RequestMethod.GET)
    public String listFestivities(Model model) {
        List<FestivityE> festivities = this.festivityService.listFestivities();
        model.addAttribute("festivity", new FestivityE());
        model.addAttribute("listFestivities", festivities);
        model.addAttribute("status", "200");
        model.addAttribute("message", getMessageStatus(200));

        return "festivity";
    }

    /**
     * Add a new festivity.
     *
     * @param p Festivity to add.
     * @return String with the view.
     */
    //For add and update festivity both
    @RequestMapping(value = "/festivity/add", method = RequestMethod.POST)
    public String addFestivity(@ModelAttribute("festivity") FestivityE p, Model model)  {
        if (p.getEndDate().after(p.getStartDate())) {
            if (p.getId() == 0) {
                //new festivity, add it
                this.festivityService.addFestivity(p);
            } else {
                //existing festivity, call update
                this.festivityService.updateFestivity(p);

            }
        } else {
            model.addAttribute("status", "400");
            model.addAttribute("message", getMessageStatus(400)+ " Start date must to be before the end date.");
            return "festivity";
            //throw new Exception("400 Start date must to be before the end date.");
        }

        return "redirect:/festivities";

    }

    /**
     * Remove a festivity.
     *
     * @param id Festivity's ID to delete.
     * @return String with the view.
     */
    @RequestMapping("/remove/{id}")
    public String removeFestivity(@PathVariable("id") int id
    ) {

        this.festivityService.removeFestivity(id);
        return "redirect:/festivities";
    }

    /**
     * Edit a festivity.
     *
     * @param id Festivity's ID to edit.
     * @return String with the view.
     */
    @RequestMapping("/edit/{id}")
    public String editFestivity(@PathVariable("id") int id, Model model,
             FestivityE p
    ) {
        model.addAttribute("festivity", this.festivityService.getFestivityById(id));
        model.addAttribute("listFestivities", this.festivityService.listFestivities());
        model.addAttribute("status", "200");
        return "festivity";
    }

    /**
     * Return a list with the festivities which have the same name.
     *
     * @param name Festivies's name.
     * @return String with the view.
     */
    @RequestMapping(value = "/festivities/getByName/{name}", method = RequestMethod.GET)
    public String listFestivityByName(@PathVariable("name") String name, Model model
    ) {
        List<FestivityE> festivities = this.festivityService.getFestivityByName(name);
        model.addAttribute("festivity", new FestivityE());
        model.addAttribute("listFestivities", festivities);
        if (festivities.isEmpty()) {
            model.addAttribute("status", "404");
            model.addAttribute("message", getMessageStatus(404) + " There aren't results for this search.");
        } else {
            model.addAttribute("status", "200");
            model.addAttribute("message", getMessageStatus(200));
        }
        return "festivity";
    }

    /**
     * Return a list with the festivities which start in the same date.
     *
     * @param date Start date.
     * @return String with the view.
     */
    @RequestMapping(value = "/festivities/getByStartDate/{date}", method = RequestMethod.GET)
    public String listFestivityByStartDate(@PathVariable("date") String date, Model model
    ) {
        List<FestivityE> festivities = this.festivityService.getFestivityByStartDate(date);
        model.addAttribute("festivity", new FestivityE());
        model.addAttribute("listFestivities", festivities);
        if (festivities.isEmpty()) {
            model.addAttribute("status", "404");
            model.addAttribute("message", getMessageStatus(404) + " There aren't results for this search.");
        } else {
            model.addAttribute("status", "200");
            model.addAttribute("message", getMessageStatus(200));
        }
        return "festivity";
    }

    /**
     * Return a list with the festivities which are between the range.
     *
     * @param date Start date of the range.
     * @param enddDate End date of the range.
     * @return String with the view.
     */
    @RequestMapping(value = "/festivities/getByRangeDate/{stardate}/{enddate}", method = RequestMethod.GET)
    public String listFestivityByRangeDate(@PathVariable("stardate") String date,
            @PathVariable("enddate") String endDate, Model model
    ) {
        List<FestivityE> festivities = this.festivityService.getFestivityByRangeDate(date, endDate);
        model.addAttribute("festivity", new FestivityE());
        model.addAttribute("listFestivities", festivities);
        if (festivities.isEmpty()) {
            model.addAttribute("status", "404");
            model.addAttribute("message", getMessageStatus(404) + " There aren't results for this search.");
        } else {
            model.addAttribute("status", "200");
            model.addAttribute("message", getMessageStatus(200));
        }
        return "festivity";
    }

    /**
     * Return a list with the festivities which belong to the place given by
     * parameter.
     *
     * @param place Place about want to know the festivities.
     * @return String with the view.
     */
    @RequestMapping(value = "/festivities/getByPlace/{place}", method = RequestMethod.GET)
    public String listFestivityByPlace(@PathVariable("place") String place, Model model
    ) {
        List<FestivityE> festivities = this.festivityService.getFestivityByPlace(place);
        model.addAttribute("festivity", new FestivityE());
        model.addAttribute("listFestivities", festivities);
        if (festivities.isEmpty()) {
            model.addAttribute("status", "404");
            model.addAttribute("message", getMessageStatus(404) + " There aren't results for this search.");
        } else {
            model.addAttribute("status", "200");
            model.addAttribute("message", getMessageStatus(200));
        }
        return "festivity";
    }

    /**
     * Provide the status to send to view.
     *
     * @param pCode Standar code error.
     * @return Status http which represents the result to the operation.
     */
    public HttpStatus getMessageStatus(int pCode) {
        //200 For successful searches
        if (pCode == 200) {
            return HttpStatus.OK;
        }
        //400 To report missing data when trying to create a new festivity
        if (pCode == 400) {
            return HttpStatus.BAD_REQUEST;
        }
        //404 For searches that return no results
        if (pCode == 404) {
            return HttpStatus.NOT_FOUND;
        }
        //500 For any errors that happen in a layer below the REST API layer
        if (pCode == 500) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return null;
    }

}
