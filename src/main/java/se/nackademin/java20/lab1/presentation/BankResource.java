package se.nackademin.java20.lab1.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import se.nackademin.java20.lab1.Persistance.Repository.PersonRepository;
import se.nackademin.java20.lab1.Persistance.model.Person;

import java.util.Optional;

@RestController
@RequestMapping(path = "/bank/")
public class BankResource {

    @Autowired
    PersonRepository personRepository;
    Person person;

    @GetMapping("/account")
    public @ResponseBody
    ModelAndView openAccount(@RequestParam long id, Model model) {

        Optional<Person> p =  personRepository.findById(id);
        model.addAttribute("userId", id);
        model.addAttribute("accountId", p.get().getName());
        model.addAttribute("balanceId", p.get().getBalance());


        return new ModelAndView("bank/account");
    }


    @PostMapping(path = "/add")
    public @ResponseBody String saveAccount(@RequestParam long id, @RequestParam String name, @RequestParam int balance){

        person = new Person(id, name,balance);
        personRepository.save(person);


        return "Användare sparad!";
    }

    @GetMapping("/bank/{userId}/account/")
    public String bankForm(@PathVariable("userId") String userId, @PathVariable("accountId") Long accountId, Model model) {
        model.addAttribute("userId", userId);
        model.addAttribute("accountId", accountId);
        return "bank";
    }

    @PostMapping(path = "/deposit")
    public @ResponseBody ModelAndView depositMoney(@RequestParam String id, @RequestParam String balance, Model model){
        long i = Long.valueOf(id);
        int b = Integer.valueOf(balance);
        Optional<Person> p =  personRepository.findById(i);
        p.get().deposit(b);
        Person per = p.get();
        personRepository.save(per);
        model.addAttribute("userId", id);
        model.addAttribute("accountId", p.get().getName());
        model.addAttribute("balanceId", p.get().getBalance());
        return new ModelAndView("bank/account");
    }

    @PostMapping(path = "/withdraw")
    public @ResponseBody ModelAndView withdrawMoney(@RequestParam String id, @RequestParam String balance, Model model){
        long i = Long.valueOf(id);
        int b = Integer.valueOf(balance);
        Optional<Person> p =  personRepository.findById(i);
        p.get().withdraw(b);
        Person per = p.get();
        personRepository.save(per);
        model.addAttribute("userId", id);
        model.addAttribute("accountId", p.get().getName());
        model.addAttribute("balanceId", p.get().getBalance());
        return new ModelAndView("bank/account");
    }



}
