package sg.edu.nus.iss.D17.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.D17.services.DiceService;

@Controller
@RequestMapping(path = "/roll")
public class DiceController {
    
    @Autowired
    private DiceService diceSvc;

    @PostMapping
    public String postRoll(@RequestBody MultiValueMap<String,String> form, Model model) {
        String strCount = form.getFirst("count");
        int count = Integer.parseInt(strCount);
        List<Integer> rolls = diceSvc.roll(count);
        model.addAttribute("rolls", rolls);
        return "dice";
    }

    @GetMapping
    public String getRoll(Model model) {
        return "dice";
    }
}
