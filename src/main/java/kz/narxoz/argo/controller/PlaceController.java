package kz.narxoz.argo.controller;

import kz.narxoz.argo.entity.Place;
import kz.narxoz.argo.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlaceController {
    @Autowired
    PlaceService placeService;

    @GetMapping("/place")
    public String viewPlace(Model model){
        model.addAttribute("places", placeService.findAllPlace());
        return "place";
    }

    @GetMapping("/place/new")
    public String addPlaceForm(Model model){
        Place place = new Place();
        model.addAttribute("place", place);
        return "add_place";
    }

    @PostMapping("/place/add")
    public String savePlace(@ModelAttribute("place") Place place){
        placeService.savePlace(place);
        return "redirect:/place";
    }

    @GetMapping("/place/update/{id}")
    public String updatePlaceForm(Model model, @PathVariable("id") Long id){
        Place place = placeService.findPlace(id);
        model.addAttribute("place", place);
        return "update_place";
    }

    @PostMapping("/place/change/{id}")
    public String updatePlace(@PathVariable("id") Long id, @ModelAttribute("place") Place place){
        Place myPlace = placeService.findPlace(id);
        myPlace = place;
        placeService.savePlace(myPlace);
        return "redirect:/place";
    }

    @GetMapping("/place/delete/{id}")
    public String deletePlace(@PathVariable("id") Long id) {
        placeService.deletePlace(id);
        return "redirect:/book";
    }
}
