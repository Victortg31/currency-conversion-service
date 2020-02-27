package br.com.indra.microservices.currencyconversionservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.indra.microservices.currencyconversionservice.bean.CurrencyConversionBean;

/*Falando que esse é o cliente, passando o nome do serviço que vamos consumir 
 * (pegar no application.properties)
@FeignClient(name="currency-exchange-service",url="localhost:8000")*/

/* não precisamos mais passar o url quando se utiliza o Ribbon, penas a instancia do serviço
@FeignClient("currency-exchange-service")*/

//Atribuindo o nome do meu APIGETWAY
@FeignClient(name="netflix-zuul-api-getway-server")

//adicionar o nome da aplicação que desejamos balancear
@RibbonClient("currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	/* URI antes da implemantação da APIGETWAYS, sem a necessidade de passar a aplicação
	@GetMapping("/currency-exchange/from/{from}/to/{to}")*/
	
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
	
}
