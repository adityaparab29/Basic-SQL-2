package com.uta.db.BankManagement.controller;

import com.uta.db.BankManagement.entity.AccountDto;
import com.uta.db.BankManagement.entity.BankBranch;

import com.uta.db.BankManagement.entity.Customer;
import com.uta.db.BankManagement.entity.Employee;
import com.uta.db.BankManagement.services.BankManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping(path = "/bankManagement")
public class BankBranchController {
    @Autowired
    private BankManagementService bankManagementService;

    @GetMapping(path = "/allBranches")
    public @ResponseBody List<BankBranch> getAllUsers() {
        return bankManagementService.fetchAllBankBranches();
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        List<BankBranch> listBranch = bankManagementService.fetchAllBankBranches();
        model.addAttribute("listBranch", listBranch);
        return "index";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String employee(Model model) {
        model.addAttribute("listEmployee", bankManagementService.fetchAllEmployee());
        return "employee";
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String customer(Model model) {
        model.addAttribute("listCustomer", bankManagementService.fetchAllCustomer());
        return "customer";
    }

    @RequestMapping(value = "/addNewCustomer", method = RequestMethod.GET)
    public String addNewCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "addNewCustomer";
    }

    @RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        bankManagementService.addNewCustomer(customer);
        return "redirect:/customer";
    }

    @RequestMapping(value = "/addNewEmployee", method = RequestMethod.GET)
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "addNewEmployee";
    }

    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        bankManagementService.addNewEmployee(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/addNewBranch", method = RequestMethod.GET)
    public String addNewBranch(Model model) {
        BankBranch bankBranch = new BankBranch();
        model.addAttribute("bankBranch", bankBranch);
        return "addNewBranch";
    }

    @RequestMapping(value = "/saveBranch", method = RequestMethod.POST)
    public String saveBranch(@ModelAttribute("bankBranch") BankBranch bankBranch) {
        bankManagementService.addNewBankBranch(bankBranch);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/viewCustomerAccounts/{customerId}", method = RequestMethod.GET)
    public ModelAndView customerAccounts(@PathVariable(name = "customerId") String customerId) {
        ModelAndView mav = new ModelAndView("customerAccount");
        Map<String, Object> objectMap = bankManagementService.fetchCustomerAccount(customerId);

        mav.addObject("customer", objectMap.get("customer"));
        mav.addObject("listAccount", objectMap.get("listAccount"));
        return mav;
    }

    @RequestMapping(value = "/viewCustomerLoans/{customerId}", method = RequestMethod.GET)
    public String customerLoans(@PathVariable(name = "customerId") String customerId, Model model) {
        Map<String, Object> objectMap = bankManagementService.fetchCustomerLoan(customerId);
        model.addAttribute("customer", objectMap.get("customer"));
        model.addAttribute("loanDtoList", objectMap.get("loanDtoList"));
        return "customerLoan";
    }

    @RequestMapping(value = "/addNewAccount/{customerId}", method = RequestMethod.GET)
    public String addNewAccount(@PathVariable(name = "customerId") String customerId, Model model) {
        AccountDto accountDto = new AccountDto();
        accountDto.setCustomerSSN(customerId);
        List<BankBranch> listBranch = bankManagementService.fetchAllBankBranches();
        model.addAttribute("accountDto", accountDto);
        model.addAttribute("listBranch", listBranch);
        return "addNewAccount";
    }

    @RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
    public String saveAccount(@ModelAttribute("accountDto") AccountDto accountDto, Model model) {
        bankManagementService.addNewAccount(accountDto);
        return "redirect:/viewCustomerAccounts/" + accountDto.getCustomerSSN();
    }


}
