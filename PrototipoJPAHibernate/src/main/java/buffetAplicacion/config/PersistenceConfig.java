/*package buffetAplicacion.config;


import javax.sql.DataSource;
import jakarta.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;

import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import org.springframework.transaction.annotation.EnableTransactionManagement;


import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Properties;
@Configuration   // Marks the class as a configuration class for Spring.
@EnableTransactionManagement   //Enables declarative transaction management via Spring's @Transactional annotation.
@ComponentScan("buffetAplicacion")
public class PersistenceConfig {
 	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("pass");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/que_comemos");
		driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return driverManagerDataSource;
	}
	

	*
	 * El localContainerEntityManagerFactoryBean es un componente de Spring que facilita la configuración de la 
	 * fábrica de administradores de entidades de JPA. Este bean permite la integración de JPA con el contenedor
	 * de Spring, proporcionando una forma sencilla de gestionar las entidades y las transacciones.
	 * @return
	 


	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	    LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
	    emf.setDataSource(dataSource());
	    emf.setPackagesToScan("buffetAplicacion.Modelo");
	    
	    JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
	    emf.setJpaVendorAdapter(jpaVendorAdapter);
	    
	    Properties jpaProperties = new Properties();
	    jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	    jpaProperties.put("hibernate.hbm2ddl.auto", "update"); // Cambia a "validate" o "create" según tu necesidad
	    jpaProperties.put("hibernate.show_sql", "true");
	    jpaProperties.put("hibernate.format_sql", "true");
	    emf.setJpaProperties(jpaProperties);
	    
	    return emf;		
	}

		
	@Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }
}
*/