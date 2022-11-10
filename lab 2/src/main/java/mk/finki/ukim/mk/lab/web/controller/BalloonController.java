package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.service.BalloonService;
import mk.finki.ukim.mk.lab.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/balloons")
public class BalloonController {

    private final BalloonService balloonService;
    private Boolean asc = true;
    private final ManufacturerService manufacturerService;

    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model, HttpSession session) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);

        }

        List<Balloon> balloons = balloonService.listAll();
        balloons.sort(Comparator.comparing(Balloon::getName));
        String sort = (String) session.getAttribute("sort");
        if(sort==null){
            sort="asc";
            session.setAttribute("sort",sort);
        }
        if (sort != null && sort.equals("desc")) {
            balloons.sort(Comparator.comparing(Balloon::getName).reversed());
        }else{
            balloons.sort(Comparator.comparing(Balloon::getName));
        }
        model.addAttribute("balloonsUpdated", balloons);
        return "listBalloons";
    }

    @PostMapping("/sort")
    public String sortBalloons(Model model, HttpSession session) {
        List<Balloon> balloons = balloonService.listAll();
        String sort = (String) session.getAttribute("sort");
        System.out.println(sort);
        session.setAttribute("sort", "desc");


        if (sort.equals("asc")) {
            session.setAttribute("sort", "desc");
        } else {
            session.setAttribute("sort", "asc");
        }




        model.addAttribute("balloonsUpdated", balloons);
        return "listBalloons";
    }

    @PostMapping("/add")
    public String saveBalloon(@RequestParam String name, @RequestParam String desc, @RequestParam Long manufacturer) {
        if (name != null && !name.isEmpty() && desc != null && !desc.isEmpty() && manufacturer != null) {
            balloonService.addBalloon(name, desc, manufacturer);
            System.out.printf("Balloon with name %s and description %s added successfully", name, desc);
            return "redirect:/balloons";
        }
        return "redirect:/balloons?error=Balloon name and description are required";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBalloon(@PathVariable Long id) {
        balloonService.deleteBalloon(id);
        return "redirect:/balloons";
    }

    @GetMapping("/add-form")
    public String getAddBalloonPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        model.addAttribute("manufacturers", manufacturerService.findAll());

        return "add-balloon";
    }


    @GetMapping("/edit-form/{id}")
    public String getEditBalloonPage(@PathVariable Long id, Model model) {
        balloonService.findByID(id).ifPresent(balloon -> model.addAttribute("balloon", balloon));
        if (!model.containsAttribute("balloon")) {
            return "redirect:/balloons?error=Balloon not found";
        }
        model.addAttribute("manufacturers", manufacturerService.findAll());
        return "add-balloon";
    }


}
