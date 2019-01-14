package com.projectK5.pabwe.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

import com.projectK5.pabwe.services.PrintSService;

@Controller
@RequestMapping("/pages")
public class PrintSController {

    @Autowired
    private PrintSService printSService;

    @RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView model = new ModelAndView();

        model.setViewName("home");
        return model;
    }

    @RequestMapping(value = "siswa/export", method = RequestMethod.POST)
    public void export(ModelAndView model, HttpServletResponse response) throws IOException, JRException, SQLException {
        JasperPrint jasperPrint = null;

        response.setContentType("application/x-download");
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"data_siswa.pdf\""));

        OutputStream out = response.getOutputStream();
        jasperPrint = printSService.exportPdfFile();
        JasperExportManager.exportReportToPdfStream(jasperPrint, out);
    }
}
