package com.projectK5.pabwe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projectK5.pabwe.model.Absensi;
import com.projectK5.pabwe.model.Siswa;
import com.projectK5.pabwe.services.AbsensiService;



@Controller
@RequestMapping("/pages/absensi")
public class AbsensiController {

//	private KelasService kelasService;
//
//	@Autowired
//	public void setKelasService(KelasService kelasService) {
//		this.kelasService = kelasService;
//	}
	
    private AbsensiService absensiService;

    @Autowired
    public void setAbsensiService(AbsensiService absensiService) {
        this.absensiService = absensiService;
    }

    @RequestMapping("")
    public String KelasListA(Model model) {
        model.addAttribute("kelas", absensiService.listKelas());
        return "/pages/absensi";
    }

//    @RequestMapping("/daftarAbsensi")
//    public String SiswaListA(Model model) {
//        model.addAttribute("siswa", absensiService.listSiswa());
//        return "/pages/daftarAbsensi";
//    }

    @RequestMapping("/daftarAbsensi")
    public String Absensi(Model model){
        model.addAttribute("absensi", absensiService.listAbsensi());

        int hStatus = 0, sStatus = 0, iStatus = 0, aStatus = 0;
        for (Absensi a : absensiService.listAbsensi()){
            switch (a.getStatus()){
                case 1:
                    hStatus++;
                    break;
                case 2:
                    sStatus++;
                    break;
                case 3:
                    iStatus++;
                    break;
                case 4:
                    aStatus++;
                    break;
            }
        }
        model.addAttribute("hStatus", hStatus);
        model.addAttribute("sStatus", sStatus);
        model.addAttribute("iStatus", iStatus);
        model.addAttribute("aStatus", aStatus);
        return "/pages/daftarAbsensi";
    }
    
    @RequestMapping("/rekapitulasiAbsensi")
    public String AbsensiList(Model model) {
        model.addAttribute("absensi", absensiService.listAbsensi());
        return "/pages/rekapitulasiAbsensi";
    }
    
    
	

    @RequestMapping(value = "/rekapitulasiAbsensi/create", method = RequestMethod.GET)
    public String tampilkanForm(Model model) {
        model.addAttribute("absensi", new Absensi());
        return "/pages/daftarAbsensi";
    }

    @RequestMapping(value = "/rekapitulasiAbsensi/create", method = RequestMethod.POST)
    public String simpanDataAbsensi(Model model, Absensi absensi) {
        model.addAttribute("absensi", absensiService.saveOrUpdate(absensi));
        return "redirect:/pages/rekapitulasiAbsensi";
    }

    @RequestMapping("/rekapitulasiAbsensi/edit/{id_absensi}")
    public String tampilkanFormUpdate(@PathVariable("id_absensi") Integer id_absensi, Model model) {
        model.addAttribute("absensi", absensiService.getAbsensiById(id_absensi));
        return "/pages/daftarAbsensi";
    }

    @RequestMapping("/rekapitulasiAbsensi/hapus/{id_absensi}")
    public String deleteDataRekapitulasi(@PathVariable("id_absensi") Integer id_absensi) {
        absensiService.delete(id_absensi);
        return "redirect:/pages/rekapitulasiAbsensi";
    }
    
    
}