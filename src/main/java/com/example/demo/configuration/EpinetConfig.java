//package com.example.demo.configuration;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//@Configuration
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "db2EntityMgrFactory", transactionManagerRef = "db2TransactionMgr",
//        basePackages = {"com.example.demo.data.repository.product"})
//@EnableTransactionManagement
//public class EpinetConfig {
//    @Bean(name = "datasource2")
//    @ConfigurationProperties(prefix = "spring.db2.datasource")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
////    @Bean(name = "datasource2")
////    @ConfigurationProperties(prefix = "spring.db2.datasource")
////    public DataSource postgresDataSource() {
////        return  DataSourceBuilder.create().build();
////    }
//
//    @Bean(name = "db2EntityMgrFactory")
//    public LocalContainerEntityManagerFactoryBean db2EntityMgrFactory (   final EntityManagerFactoryBuilder builder,
//                                                                          @Qualifier("datasource2") final DataSource dataSource) {
//
//        return builder
//                .dataSource(dataSource)
//                .packages("com.example.demo.data.entity.teacher")
//                .persistenceUnit("db2")
//                .build();
//    }
//
//    @Bean(name = "db2TransactionMgr")
//    public PlatformTransactionManager db2TransactionMgr(
//            @Qualifier("db2EntityMgrFactory") final EntityManagerFactory entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//}