package cl.utem.inf.nota;

import java.sql.DriverManager;
import javax.sql.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class NotaApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotaApplication.class, args);
    }

    @Bean
    public DataSource datasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("prueba");
        dataSource.setPassword("prueba");
        dataSource.setUrl("jdbc:postgresql:pruebadb");
        return dataSource;
    }
}
