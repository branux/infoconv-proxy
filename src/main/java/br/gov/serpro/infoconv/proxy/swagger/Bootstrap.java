package br.gov.serpro.infoconv.proxy.swagger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import br.gov.serpro.infoconv.proxy.rest.Api;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.models.Contact;
import io.swagger.models.Info;


@WebServlet(loadOnStartup = 2)
public class Bootstrap extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("cetec01.sdr.serpro:8080/infoconv-proxy");
        beanConfig.setBasePath("/api");
        beanConfig.setResourcePackage(Api.class.getPackage().getName());
        beanConfig.setScan(true);
        beanConfig.setPrettyPrint(true);
        Info info = new Info();
        info.setTitle("Infoconv proxy");
        info.setDescription("Api para consumo dos webservcies do Infoconv CPF e CNPJ");
        info.setVersion("v1");
        beanConfig.setInfo(info);
        
    }
}