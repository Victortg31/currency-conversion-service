package br.com.indra.microservices.currencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//permitindo que o ferign encontre clientes, e passar o pacote que precisa ser verificado
@EnableFeignClients("br.com.indra.microservices.currencyconversionservice")
//buscando pelo pacote que eureka foi habilitada
@EnableDiscoveryClient
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}

}
