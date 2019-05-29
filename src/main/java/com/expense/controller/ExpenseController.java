package com.expense.controller;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.expense.dto.ExpenseDTO;
import com.expense.entity.Expense;
import com.expense.entity.User;
import com.expense.mapper.ExpenseMapper;
import com.expense.service.ExpenseService;
import com.expense.service.UserService;

@Controller
public class ExpenseController {

	Logger log = Logger.getLogger(ExpenseController.class.getName());

	@Autowired
	ExpenseService expenseService;

	@Autowired
	UserService userService;

	@Autowired
	ExpenseMapper expenseMapper;

	// ---------------------------

	//Open Home page
	@GetMapping("/expense-home")
	public String getHomePage(Model model) {

		log.info(" processing to home page");
		User user = userService.getDefaultUser();
		model.addAttribute("user", user);
		return "home.jsp";
	}

	/*
	 * Serve list of expenses of the user
	 */
	@GetMapping("/expense-list")
	public String getExpenseList(Model model) {

		log.info(" processing");
		User user = userService.getDefaultUser();
		List<Expense> expenseList = expenseService.getExpenseByUserId(user.getId());
		System.out.println("expenseList: " + expenseList.size());
		model.addAttribute("user", user);
		model.addAttribute("expeseList", expenseList);
		log.info("login successful: " + expenseList);
		return "expenseList.jsp";
	}

	// Show newExpense.jsp to create expense
	
	@GetMapping("/new-expense")
	public String addNewExpense(Model model) {
		User user = userService.getDefaultUser();
		ExpenseDTO expenseDTO = new ExpenseDTO();
		expenseDTO.setUserId(user.getId());
		expenseDTO.setCurrency(user.getCurrency());
		log.info("expenseDTO: " + expenseDTO);
		model.addAttribute("user", user);
		model.addAttribute("Expense", expenseDTO);
		
		return "newExpense.jsp";
		
	}

	// edit an expense
	
	@GetMapping("/edit/{id}")
	public String editExpense(@PathVariable("id") Long expenseId, Model model) {

		Expense expense = expenseService.getById(expenseId);
		ExpenseDTO expenseDTO = expenseMapper.modelToDTOMap(expense);
		model.addAttribute("Expense", expenseDTO);
		log.info("in submitForm1: " + expenseDTO);

		User user = userService.getDefaultUser();
		model.addAttribute("user", user);
		return "/newExpense.jsp";
	}

	/*
	 * Save Expense
	 */
	@PostMapping("/submit-form")
	public String submitForm(@ModelAttribute("Expense") ExpenseDTO expenseDTO, Model model) {
		log.info("in submitForm: " + expenseDTO);

		if (expenseDTO.getId() != null) {
			log.info("Modify: " + expenseDTO.getId());
			Expense expense = expenseService.getById(expenseDTO.getId());
			expense = expenseMapper.dtoToModelMap(expenseDTO);
			expenseService.saveExpense(expense);
			model.addAttribute("SuccessText", " Expense List is edited successfully.");
		} else {
			log.info("New");
			User user = userService.getDefaultUser();
			expenseDTO.setUserId(user.getId());
			Expense expense = mapDTOToModel(expenseDTO);
			expenseService.saveExpense(expense);
			model.addAttribute("SuccessText", " Expense List is added successfully.");
		}
		
		log.info("add new expense: " + expenseDTO);
		User user = userService.getDefaultUser();
		model.addAttribute("user", user);
		model.addAttribute("Expense", new ExpenseDTO());
		return "/newExpense.jsp";
		
	}

	/*
	 * get Expense Object for the passed Expense DTO (Data Transfer Object)
	 */

	private Expense mapDTOToModel(ExpenseDTO expenseDTO) {
		Expense expense = new Expense();
		expense = expenseMapper.dtoToModelMap(expenseDTO);
		User user = userService.getById(expenseDTO.getUserId());
		log.info("Got User" + user);
		expense.setUser(user);
		return expense;
	}

	// Delete expense
	
	@GetMapping("/delete/{id}")
	public String deleteExpense(@PathVariable("id") Long expenseId, RedirectAttributes redirectAttributes) {
		log.info("in deleteExpense: "+expenseId);
		log.info("expenseId : " + expenseId);
		if (expenseId != null) {
			expenseService.deleteById(expenseId);

			log.info("count: " + expenseService.getExpenseByUserId(1l).size());
			log.info("deleted id: " + expenseId);

		} else {
			return "Something went wrong !";
		}
		
		redirectAttributes.addFlashAttribute("msg", "Expense List is deleted successfully.");
		return "redirect:/expense-list";
	}

	
}