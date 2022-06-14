package org.acme;

import io.quarkus.test.junit.main.LaunchResult;
import io.quarkus.test.junit.main.QuarkusMainLauncher;
import io.quarkus.test.junit.main.QuarkusMainTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusMainTest
public class ApplicationMainIT {

	@Test
	public void testApplicationFlowWithoutDelay(QuarkusMainLauncher launcher) {
		LaunchResult result = launcher.launch();
		assertEquals(0, result.exitCode());
	}
}
