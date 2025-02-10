package es.liernisarraoa.ejercicio2_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class ControladorAgenda implements Initializable {
    private Stage ejercicioStage;
    private ToggleGroup grupoRadioButton;
    @FXML
    private RadioButton radioButtonPersonas;

    @FXML
    private RadioButton radioButtonCalculos;

    @FXML
    private RadioButton radioButtonSubinformes;

    @FXML
    private Button botonAceptar;

    @FXML
    private Button botonCancelar;

    public void visualizarInforme(ActionEvent actionEvent) {
        if(grupoRadioButton.getSelectedToggle() == radioButtonPersonas){
            visualizarPersonas();
        } else if (grupoRadioButton.getSelectedToggle() == radioButtonCalculos) {
            visualizarCalculos();
        } else if (grupoRadioButton.getSelectedToggle() == radioButtonSubinformes) {
            visualizarSubInforme();
        }
    }

    private void visualizarSubInforme() {
        try {
            // Ruta del archivo Jasper (compilado)
            String reportPath = "C:\\DM2\\DEIN\\ProyectoFXJasper\\Ejercicio2_1\\src\\main\\resources\\es\\liernisarraoa\\ejercicio2_1\\Jasper\\SubInforme\\Ejercicio2SubInforme.jasper";

            // Cargar el archivo Jasper
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportPath);

            // Configurar conexión a la base de datos
            String dbUrl = "jdbc:mariadb://localhost:3306/agenda";
            String dbUser  = "root";
            String dbPassword = "WinRar3009*.";

            Connection connection = DriverManager.getConnection(dbUrl, dbUser , dbPassword);

            // Llenar el informe con datos
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connection);

            // Mostrar el informe
            JasperViewer.viewReport(jasperPrint, false);

            // Exportar a PDF (opcional)
            JasperExportManager.exportReportToPdfFile(jasperPrint, "PDF/reportePersonasSubInforme.pdf");

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void visualizarCalculos() {
        try {
            // Ruta del archivo Jasper (compilado)
            String reportPath = "C:\\DM2\\DEIN\\ProyectoFXJasper\\Ejercicio2_1\\src\\main\\resources\\es\\liernisarraoa\\ejercicio2_1\\Jasper\\Calculo\\Ejercicio2Calculos.jasper";

            // Cargar el archivo Jasper
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportPath);

            // Configurar conexión a la base de datos
            String dbUrl = "jdbc:mariadb://localhost:3306/agenda";
            String dbUser  = "root";
            String dbPassword = "WinRar3009*.";

            Connection connection = DriverManager.getConnection(dbUrl, dbUser , dbPassword);

            // Llenar el informe con datos
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connection);

            // Mostrar el informe
            JasperViewer.viewReport(jasperPrint, false);

            // Exportar a PDF (opcional)
            JasperExportManager.exportReportToPdfFile(jasperPrint, "PDF/reportePersonasCalculos.pdf");

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cerrarVentana(ActionEvent actionEvent) {
        ejercicioStage.close();
    }

    private void visualizarPersonas(){
        try {
            // Ruta del archivo Jasper (compilado)
            String reportPath = "C:\\DM2\\DEIN\\ProyectoFXJasper\\Ejercicio2_1\\src\\main\\resources\\es\\liernisarraoa\\ejercicio2_1\\Jasper\\Ejercicio2Personas.jasper";

            // Cargar el archivo Jasper
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportPath);

            // Configurar conexión a la base de datos
            String dbUrl = "jdbc:mariadb://localhost:3306/agenda";
            String dbUser  = "root";
            String dbPassword = "WinRar3009*.";

            Connection connection = DriverManager.getConnection(dbUrl, dbUser , dbPassword);

            // Llenar el informe con datos
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connection);

            // Mostrar el informe
            JasperViewer.viewReport(jasperPrint, false);

            // Exportar a PDF (opcional)
            JasperExportManager.exportReportToPdfFile(jasperPrint, "PDF/reportePersonas.pdf");

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        grupoRadioButton = new ToggleGroup();
        radioButtonPersonas.setToggleGroup(grupoRadioButton);
        radioButtonCalculos.setToggleGroup(grupoRadioButton);
        radioButtonSubinformes.setToggleGroup(grupoRadioButton);
    }

    public void setEjercicioStage(Stage ejercicioStage) {
        this.ejercicioStage = ejercicioStage;
    }
}