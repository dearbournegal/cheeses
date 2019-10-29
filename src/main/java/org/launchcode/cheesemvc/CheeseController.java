package org.launchcode.cheesemvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


@Controller
@RequestMapping("cheese")
public class CheeseController {

//    Moved from index so that way could access in the processCheeseForm; and we
//    will then add cheese in the same processCheeseForm
    static ArrayList<String> cheeses = new ArrayList<>();
    //Request path:/cheese
    @RequestMapping(value="")
    public String index(Model model){

//        ArrayList<String> cheeses = new ArrayList<>();
//        cheeses.add("cheddar");
//        cheeses.add("colby");
//        cheeses.add("munster");

        model.addAttribute("title","The Cheeses");
        model.addAttribute("cheeses", cheeses);
//        model.addAttribute("titles","Heidi's Cheeses");
        return "cheese/index";
    }

//    To display the form
    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title","Add Cheese");
        return "cheese/add";
    }

//    To process the added cheeses by the user
    @RequestMapping(value = "add", method = RequestMethod.POST)

//    We will use the spring version below instead
//    public String processAddCheeseForm(HttpServletRequest request){
//        String cheeseName = request.getParameter("cheeseName");

    public String processAddCheeseForm(@RequestParam String cheeseName){
        cheeses.add(cheeseName);
        //Redirect to cheese bc it's empty so it will return to main
        return "redirect:";

    }
}
