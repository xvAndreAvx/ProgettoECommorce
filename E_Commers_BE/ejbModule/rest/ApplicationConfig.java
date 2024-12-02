package rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.jboss.resteasy.plugins.interceptors.CorsFilter;


@ApplicationPath("/api")
public class ApplicationConfig  extends Application {
	private Set<Object> singletons=new HashSet<Object>() ;
	

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> ret = new HashSet<>();
//		ret.add(CorsFilter.class);
//		ret.add(HelloController.class);
//		ret.add(ProdottoController.class);
		return ret;
	}


	public Set<Object> getSingletons() {
		return singletons;
	}


	public void setSingletons(Set<Object> singletons) {
		this.singletons = singletons;
	}


	public ApplicationConfig() {
		
		super();
		CorsFilter cors = new CorsFilter();
		cors.getAllowedOrigins().add("*");
		cors.setAllowedMethods("OPTIONS, GET, POST, DELETE, PUT, PATCH");
		cors.setAllowedHeaders("Authorization, Content-Type, Accept, Origin");
		cors.setAllowCredentials(true);
		cors.setCorsMaxAge(86400);
		singletons.add(cors);
		
	}
}
