module es.liernisarraoa.ejercicio2_1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jasperreports;
    requires org.mariadb.jdbc;
    requires slf4j.api;


    opens es.liernisarraoa.ejercicio2_1 to javafx.fxml;
    exports es.liernisarraoa.ejercicio2_1;
}