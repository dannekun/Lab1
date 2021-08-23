package se.nackademin.java20.lab1.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BankResource {

    @GetMapping("/bank/{userId}/account")
    public String openAccount(@PathVariable("userId") String userId) {
        return "redirect:/bank/unknown/account/1";
    }

    @GetMapping("/bank/{userId}/account/{accountId}")
    public String bankForm(@PathVariable("userId") String userId, @PathVariable("accountId") Long accountId, Model model) {
        model.addAttribute("userId", userId);
        model.addAttribute("accountId", accountId);
        return "bank";
    }

}
