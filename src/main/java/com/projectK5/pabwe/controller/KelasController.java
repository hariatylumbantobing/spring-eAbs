package com.projectK5.pabwe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projectK5.pabwe.model.Kelas;
import com.projectK5.pabwe.services.KelasService;


@Controller
@RequestMapping("/pages/kelas")
public class KelasController {
	
	private KelasService kelasService;

	@Autowired
	public void setKelasService(KelasService kelasService) {
		this.kelasService = kelasService;
	}
	
	@RequestMapping("")
	public String KelasList(Model model) {
		model.addAttribute("kelas", kelasService.listKelas());
		return "/pages/kelas";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String tampilkanForm(Model model) {
		model.addAttribute("kelas", new Kelas());
		return "/pages/formKelas";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String simpanDataKelas(Model model, Kelas kelas) {
		model.addAttribute("kelas", kelasService.saveOrUpdate(kelas));
		return "redirect:/pages/kelas";
	}
	
	@RequestMapping("/edit/{id_kelas}")
	public String tampilkanFormUpdate(@PathVariable("id_kelas") long id_kelas, Model model) {
		model.addAttribute("kelas", kelasService.getKelasByIdKelas(id_kelas));
		return "/pages/formKelas";
	}
	
	@RequestMapping("/hapus/{id_kelas}")
	public String deleteDataKelas(@PathVariable("id_kelas") long id_kelas) {
		kelasService.delete(id_kelas);
		return "redirect:/pages/kelas";
	}
}
