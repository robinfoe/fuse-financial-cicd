/*
 * Copyright 2005-2016 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.redhat.fisdemoaggregator;

import java.io.InputStream;

import org.apache.catalina.Context;
import org.apache.tomcat.util.descriptor.web.LoginConfig;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
//import org.keycloak.adapters.HttpFacade;
//import org.keycloak.adapters.KeycloakConfigResolver;
//import org.keycloak.adapters.KeycloakDeployment;
//import org.keycloak.adapters.KeycloakDeploymentBuilder;
//import org.keycloak.adapters.tomcat.KeycloakAuthenticatorValve;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;



@SpringBootApplication
@ImportResource({"classpath:spring/camel-context.xml"})
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

   
    
    
//    @Bean
//    public EmbeddedServletContainerCustomizer getKeycloakContainerCustomizer() {
//        return new EmbeddedServletContainerCustomizer() {
//            @Override
//            public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
//            	
//            	System.err.println("@@ TomcatEmbeddedServletContainerFactory " + configurableEmbeddedServletContainer.toString());
//            	
//                if (configurableEmbeddedServletContainer instanceof TomcatEmbeddedServletContainerFactory) {
//                		System.err.println("@@ TomcatEmbeddedServletContainerFactory");
//                    TomcatEmbeddedServletContainerFactory container = (TomcatEmbeddedServletContainerFactory) configurableEmbeddedServletContainer;
//
//                    container.addContextValves(new KeycloakAuthenticatorValve());
//
//                    container.addContextCustomizers(getKeycloakContextCustomizer());
//                }
//            }
//        };
//    }
//
//    @Bean
//    public TomcatContextCustomizer getKeycloakContextCustomizer() {
//        return new TomcatContextCustomizer() {
//            @Override
//            public void customize(Context context) {
//                LoginConfig loginConfig = new LoginConfig();
//                
//                System.err.println("At Context Customiser");
//                loginConfig.setAuthMethod("KEYCLOAK");
//                context.setLoginConfig(loginConfig);
//
//                context.addSecurityRole("demo");
//
//                SecurityConstraint constraint = new SecurityConstraint();
//                constraint.addAuthRole("demo");
//
//                SecurityCollection collection = new SecurityCollection();
//                collection.addPattern("/demo");
//                constraint.addCollection(collection);
//
//                context.addConstraint(constraint);
//
//                context.addParameter("keycloak.config.resolver", SpringBootKeycloakConfigResolver.class.getName());
//            }
//        };
//    }
//
//    public static class SpringBootKeycloakConfigResolver implements KeycloakConfigResolver {
//
//        private KeycloakDeployment keycloakDeployment;
//
//        @Override
//        public KeycloakDeployment resolve(HttpFacade.Request request) {
//            if (keycloakDeployment != null) {
//                return keycloakDeployment;
//            }
//
//            InputStream configInputStream = getClass().getResourceAsStream("/keycloak.json");
//            if (configInputStream == null) {
//                keycloakDeployment = new KeycloakDeployment();
//            } else {
//                keycloakDeployment = KeycloakDeploymentBuilder.build(configInputStream);
//            }
//
//            return keycloakDeployment;
//        }
//    }

   
}