package com.redhat.fisdemoaggregator;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

@Component
public class AuthenticationFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		//we must obtain the user from the context.
		//CatalinaRequestAuthenticator saves the security context as request attribute
		
		HttpServletResponse httpResponse = (HttpServletResponse)response;

		try{
			
			HttpServletRequest servReq = (HttpServletRequest)request;
			String token = servReq.getHeader("Authorization");
			token = token.substring(7);
			System.err.println("@@ Token -"+ token.substring(7));
			
			if(StringUtils.isEmpty(token))
				throw new IllegalArgumentException("Not Authorized");
				
			
			DecodedJWT jwt = JWT.decode(token);
			if(jwt.getClaim("resource_access") == null)
				throw new IllegalArgumentException("Not Authorized");

		
			//Map<String,Object> claimMaps = jwt.getClaim("resource_access").asMap();
			//if(!claimMaps.containsKey("temasek-demo-client"))
			//	throw new IllegalArgumentException("Not Authorized");
		
			//getClaim("resource_access") != null
//			if(jwt.getClaim("resource_access") != null) {
				//
//				for(String key : claimMaps.keySet()) {
//					System.err.println(key);
//				}
//			}
			//claim.asMap()
			//
			
			/*Bearer */
//			SecurityContextHolder.getContext().setAuthentication(KeycloakAuthentication.KeycloakAuthenticationBuilder.buildAuthentication((HttpServletRequest)request));
//			System.err.println("test filter");
//			
//			
//			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//			System.err.println("@@ -- credentials " + auth.getCredentials() );
//			System.err.println("@@ -- principal " + auth.getPrincipal());
//			System.err.println("@@ -- name " + auth.getName() );
//			System.err.println("@@ -- " + auth.getCredentials() + " - " + auth.getPrincipal());
//			
//			if(auth.getName() == null)
//				throw new IllegalArgumentException("Not Authorized");
			
			chain.doFilter(request, response);
			
		} catch(Exception e){
			httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
			
		}finally {
			SecurityContextHolder.clearContext();
		}
	}

	
	@Override
	public void destroy() {
	}

}
