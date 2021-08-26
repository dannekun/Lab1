package se.nackademin.java20.lab1.Presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import se.nackademin.java20.lab1.Application.Serialize;
import se.nackademin.java20.lab1.Domain.PersonRepository;
import se.nackademin.java20.lab1.Domain.Person;

import java.util.Optional;

@RestController
@RequestMapping(path = "/bank/")
public class BankResource {

    @Autowired
    PersonRepository personRepository;
    Person person;



    @GetMapping("/account")
    public @ResponseBody
    ModelAndView openAccount(@RequestParam String id, Model model) {

        long i = Long.valueOf(id);
        Optional<Person> p =  personRepository.findById(i);
        model.addAttribute("userId", id);
        model.addAttribute("accountId", p.get().getName());
        model.addAttribute("balanceId", p.get().getBalance());


        return new ModelAndView("bank/account");
    }


    @PostMapping(path = "/create")
    public @ResponseBody String saveAccount( @RequestParam String name, @RequestParam int balance){

        Serialize serialize = new Serialize();

        serialize.smashOrPass();

       // System.out.println(smash);


        if (!personRepository.findByName(name).isEmpty())
            return "User Already exists";
        else
            person = new Person(name, balance);
        personRepository.save(person);
        return   "User Saved!" ;



    }


    @GetMapping(path = "/deposit")
    public @ResponseBody ModelAndView depositMoney(@RequestParam String id, @RequestParam String deposit, Model model){
        long i = Long.parseLong(id);
        int b = Integer.parseInt(deposit);
        Optional<Person> p =  personRepository.findById(i);
        p.get().deposit(b);
        return getModelAndView(id, model, p);
    }


    @GetMapping(path = "/withdraw")
    public @ResponseBody ModelAndView withdrawMoney(@RequestParam String id, @RequestParam String withdraw, Model model){
        long i = Long.parseLong(id);
        int b = Integer.parseInt(withdraw);
        Optional<Person> p =  personRepository.findById(i);
        p.get().withdraw(b);
        return getModelAndView(id, model, p);
    }


    private ModelAndView getModelAndView(@RequestParam String id, Model model, Optional<Person> p) {
        Person per = p.get();
        personRepository.save(per);
        model.addAttribute("userId", id);
        model.addAttribute("accountId", p.get().getName());
        model.addAttribute("balanceId", p.get().getBalance());
        return new ModelAndView("bank/account");
    }
}
