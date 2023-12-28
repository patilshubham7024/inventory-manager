package com.shop.inventorymanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories({"com.shop.inventorymanager.repository"})
@EntityScan({"com.shop.inventorymanager.entity"})
@ComponentScan(basePackages = {"com.shop.inventorymanager.mapper"})
@EnableTransactionManagement
public class InventoryManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagerApplication.class, args);
	}

}
