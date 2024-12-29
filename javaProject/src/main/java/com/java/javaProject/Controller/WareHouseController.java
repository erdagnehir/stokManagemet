package com.java.javaProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.javaProject.Entity.WareHouse;
import com.java.javaProject.Service.IWareHouseService;

@Controller
@RequestMapping("/wareHouses")
public class WareHouseController {
	@Autowired
	private IWareHouseService wareHouseService;

	@GetMapping
	public String listWareHouses(Model model) {
		List<WareHouse> wareHouses = wareHouseService.getAllWarehouses();
		model.addAttribute("wareHouses", wareHouses);
		return "warehouse/list";
	}

	@GetMapping("/add")
	public String addWareHouseForm(Model model) {

		model.addAttribute("wareHouse", new WareHouse());
		return "warehouse/add";
	}
	
	@GetMapping("/add/{id}")
	public String addWareHouseFormWithId(@PathVariable Long id, Model model) {
		WareHouse wareHouses = wareHouseService.findById(id).orElse(null);
	    model.addAttribute("wareHouse", wareHouses);
	    return "wareHouse/add";
	}
	
	@PostMapping("/add")
	public String saveWareHouse(@ModelAttribute WareHouse wareHouse) {
		wareHouseService.saveWarehouse(wareHouse);
		return "redirect:/wareHouses";
	}

    @PostMapping("/delete/{id}")
    public String deleteWareHouse(@PathVariable Long id, Model model) {
        String result = wareHouseService.deleteWareHouse(id);

        if (result != null) {
    		List<WareHouse> wareHouses = wareHouseService.getAllWarehouses();
    		model.addAttribute("wareHouses", wareHouses);
            model.addAttribute("errorMessage", result);
            return "warehouse/list";
        }

        return "redirect:/wareHouses"; 
    }

}
