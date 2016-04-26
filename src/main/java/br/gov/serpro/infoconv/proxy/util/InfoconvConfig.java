package br.gov.serpro.infoconv.proxy.util;

import java.net.URL;
import java.util.Properties;

import javax.inject.Singleton;

import br.gov.serpro.infoconv.ws.cnpj.ConsultarCNPJ;
import br.gov.serpro.infoconv.ws.cnpj.ConsultarCNPJSoap;
import br.gov.serpro.infoconv.ws.cpf.ConsultarCPF;
import br.gov.serpro.infoconv.ws.cpf.ConsultarCPFSoap;

/**
 * Classe criada para iniciar as configurações de certificados para acessar
 * o infoconv.
 *
 */
@Singleton
public class InfoconvConfig {

	public final ConsultarCPFSoap consultarCPFSoap;
	public final ConsultarCNPJSoap consultarCNPJSoap;
	public static URL keyStoreUrl = ConsultarCPFSoap.class.getResource("/META-INF/store/infoconv.jks");
	public static URL trustStoreUrl = ConsultarCPFSoap.class.getResource("/META-INF/store/truststore.jks");
	
	public InfoconvConfig(){
		
		Properties props = new Properties();
		props.setProperty("javax.net.ssl.keyStore", keyStoreUrl.getPath());
		props.setProperty("javax.net.ssl.keyStorePassword", "123456");
		props.setProperty("javax.net.ssl.keyStoreType", "JKS");
		props.setProperty("javax.net.ssl.trustStore", trustStoreUrl.getPath());
		props.setProperty("javax.net.ssl.trustStorePassword", "123456");
		props.setProperty("javax.net.ssl.trustStoreType", "JKS");
		props.setProperty("javax.net.debug", "ssl");
		System.getProperties().putAll(props);
				
		this.consultarCPFSoap = new ConsultarCPF().getConsultarCPFSoap12();
		this.consultarCNPJSoap = new ConsultarCNPJ().getConsultarCNPJSoap12();
	}
	
	
	
}
