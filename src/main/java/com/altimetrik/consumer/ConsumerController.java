package com.altimetrik.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/consumers")
public class ConsumerController {

	@Autowired
	private RestTemplate restTemplate;
	
	private String uri = "http://localhost:8090/api/v1/transactions";
	
	@GetMapping
	public String index(@ModelAttribute("transaction") Transaction transaction, Model model) {
		return "index";
	}
	
	@PostMapping
	public String save(@ModelAttribute Transaction transaction, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		System.out.println(transaction);
		
		ResponseEntity<String> response = restTemplate.postForEntity(uri, transaction, String.class);
		
		System.out.println("Save Responses: ");
		System.out.println(response);
		
		return "redirect:/consumers/stats";
	}
	
	@RequestMapping("/stats")
	public String getStats(Model model) {
		TransactionStatDTO stats = restTemplate.getForObject(uri, TransactionStatDTO.class);
		System.out.println(stats);
		System.out.println("Stat Response");
		model.addAttribute("stats", stats);
		

		return "stats";
	}
}
