package com.projectK5.pabwe.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projectK5.pabwe.model.Siswa;
import com.projectK5.pabwe.services.SiswaService;


@Controller
@RequestMapping("/pages/siswa")
public class SiswaController {
	
	private SiswaService siswaService;

	@Autowired
	public void setSiswaService(SiswaService siswaService) {
		this.siswaService = siswaService;
	}

	@RequestMapping("")
	public String SiswaList(Model model) {
		model.addAttribute("siswa", siswaService.listSiswa());
		return "/pages/siswa";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String tampilkanForm(Model model) {
		model.addAttribute("siswa", new Siswa());
		return "/pages/formSiswa";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String simpanDataSiswa(Model model, Siswa siswa) {
		model.addAttribute("siswa", siswaService.saveOrUpdate(siswa));
		return "redirect:/pages/siswa";
	}
	
	@RequestMapping("/edit/{nis}")
	public String tampilkanFormUpdate(@PathVariable("nis") int nis, Model model) {
		model.addAttribute("siswa", siswaService.getSiswaByNis(nis));
		return "/pages/formSiswa";
	}
	
	@RequestMapping("/hapus/{nis}")
	public String deleteDataMahasiswa(@PathVariable("nis") int nis) {
		siswaService.delete(nis);
		return "redirect:/pages/siswa";
	}

}
