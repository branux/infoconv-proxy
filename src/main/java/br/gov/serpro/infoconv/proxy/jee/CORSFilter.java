package br.gov.serpro.infoconv.proxy.jee;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;




@WebFilter(filterName = "cors")
public class CORSFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if (response instanceof HttpServletResponse) {
			HttpServletResponse r = (HttpServletResponse) response;
			r.addHeader("Access-Control-Allow-Origin", "*");
			r.addHeader("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT, DELETE");
			r.addHeader("Access-Control-Allow-Headers", "Content-Type");
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
}