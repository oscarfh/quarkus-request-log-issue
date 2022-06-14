//package org.acme;
//
//import java.util.Iterator;
//import java.util.Set;
//import java.util.TreeMap;
//import java.util.stream.Collectors;
//import java.util.stream.StreamSupport;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.quarkus.runtime.QuarkusApplication;
//import io.quarkus.runtime.annotations.QuarkusMain;
//import javax.enterprise.inject.spi.BeanManager;
//import javax.inject.Inject;
//import org.acme.rest.client.Extension;
//import org.acme.rest.client.ExtensionsService;
//import org.eclipse.microprofile.config.Config;
//import org.eclipse.microprofile.config.ConfigProvider;
//import org.eclipse.microprofile.rest.client.inject.RestClient;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//@QuarkusMain
//public class ApplicationMain implements QuarkusApplication {
//	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationMain.class);
//
//	@RestClient
//	ExtensionsService extensionsService;
//
//
//	@Override
//	public int run(String... args) throws JsonProcessingException {
//		LOGGER.debug("Debig active");
//		LOGGER.info("Started without parameters");
//
//
//		Config config = ConfigProvider.getConfig();
//
//		TreeMap<String, String> stringStringTreeMap = new TreeMap<>(StreamSupport.stream(config.getPropertyNames()
//						.spliterator(), false)
//				.collect(Collectors.toMap(p -> p, p -> config.getConfigValue(p).getRawValue())));
//
//		LOGGER.info("Config: {}", (new ObjectMapper()).writeValueAsString(stringStringTreeMap));
//
//		//		return new TreeMap<>(StreamSupport.stream(config.getPropertyNames().spliterator(), false)
////				.collect(Collectors.toMap(p -> p, p -> config.getConfigValue(p).getRawValue())));
//
//
//		Set<Extension> byId = extensionsService.getById("io.quarkus:quarkus-rest-client-reactive");
//
//
//
//		Iterator<Extension> iterator = byId.iterator();
//		while (iterator.hasNext()) {
//			LOGGER.info("####");
//			LOGGER.info(iterator.next().name);
//
//		}
//
//		return 0;
//	}
//}
