package org.acme;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.acme.rest.client.Extension;
import org.acme.rest.client.ExtensionsService;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/hello")
public class GreetingResource {
	private static final Logger LOGGER = LoggerFactory.getLogger(GreetingResource.class);

	@RestClient
	ExtensionsService extensionsService;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() throws JsonProcessingException {

		LOGGER.debug("Debig active");
		LOGGER.info("Started without parameters");

		Config config = ConfigProvider.getConfig();

		TreeMap<String, String> stringStringTreeMap = new TreeMap<>(StreamSupport.stream(config.getPropertyNames()
						.spliterator(), false)
				.collect(Collectors.toMap(p -> p, p -> config.getConfigValue(p).getRawValue())));

		LOGGER.info("Config: {}", (new ObjectMapper()).writeValueAsString(stringStringTreeMap));

		//		return new TreeMap<>(StreamSupport.stream(config.getPropertyNames().spliterator(), false)
		//				.collect(Collectors.toMap(p -> p, p -> config.getConfigValue(p).getRawValue())));

		Set<Extension> byId = extensionsService.getById("io.quarkus:quarkus-rest-client-reactive");

		Iterator<Extension> iterator = byId.iterator();
		while (iterator.hasNext()) {
			LOGGER.info("####");
			LOGGER.info(iterator.next().name);

		}

		return "done";
	}
}
