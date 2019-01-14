package com.projectK5.pabwe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projectK5.pabwe.model.Rekapitulasi;
import com.projectK5.pabwe.services.RekapitulasiService;


@Controller
@RequestMapping("/pages/rekapitulasi")
public class RekapitulasiController {
	
	private RekapitulasiService rekapitulasiService;

	@Autowired
	public void setRekapitulasiService(RekapitulasiService rekapitulasiService) {
		this.rekapitulasiService = rekapitulasiService;
	}
	
	@RequestMapping("")
	public String RekapitulasiList(Model model) {
		model.addAttribute("rekapitulasi", rekapitulasiService.listRekapitulasi());
		return "/pages/rekapitulasi";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String tampilkanForm(Model model) {
		model.addAttribute("rekapitulasi", new Rekapitulasi());
		return "/pages/formRekap";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String simpanDataRekapitulasi(Model model, Rekapitulasi rekapitulasi) {
		model.addAttribute("rekapitulasi", rekapitulasiService.saveOrUpdate(rekapitulasi));
		return "redirect:/pages/rekapitulasi";
	}
	
	@RequestMapping("/edit/{id_rekapitulasi}")
	public String tampilkanFormUpdate(@PathVariable("id_rekapitulasi") Integer id_rekapitulasi, Model model) {
		model.addAttribute("rekapitulasi", rekapitulasiService.getRekapitulasiById(id_rekapitulasi));
		return "/pages/formRekap";
	}
	
	@RequestMapping("/hapus/{id_rekapitulasi}")
	public String deleteDataRekapitulasi(@PathVariable("id_rekapitulasi") Integer id_rekapitulasi) {
		rekapitulasiService.delete(id_rekapitulasi);
		return "redirect:/pages/rekapitulasi";
	}
}
