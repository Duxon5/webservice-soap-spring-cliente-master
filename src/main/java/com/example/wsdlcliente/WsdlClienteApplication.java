package com.example.wsdlcliente;

import com.example.wsdlcliente.clients.PaisClient;
import com.example.wsdlcliente.wsdl.GetPaisResponse;
import com.example.wsdlcliente.wsdl.Pais;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WsdlClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsdlClienteApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(PaisClient quoteClient) {
		return args -> {
			String pais = "Brasil";

			GetPaisResponse response = quoteClient.getPais(pais);
			System.out.println("Pais: " + pais);
			System.out.println("Capital: " + response.getPais().getCapital() + " | "
							 + "Moeda: " + response.getPais().getMoeda() + " | "
							 + "Populacao: " + response.getPais().getPopulacao());

			response = quoteClient.getPais("Reino Unido");
			System.out.println("Pais: " + pais);
			System.out.println("Capital: " + response.getPais().getCapital() + " | "
							 + "Moeda: " + response.getPais().getMoeda() + " | "
							 + "Populacao: " + response.getPais().getPopulacao());
		};
	}

}
