package com.projectK5.pabwe.services;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

import com.projectK5.pabwe.dao.PrintDaoImpl;

@Service
public class PrintSService {

    @Autowired
    private PrintDaoImpl printDao;

    public JasperPrint exportPdfFile() throws SQLException, JRException, IOException {
        return printDao.exportPdfFile();
    }
}
