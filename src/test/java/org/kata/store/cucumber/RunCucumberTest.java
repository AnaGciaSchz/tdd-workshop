package org.kata.store.cucumber;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME;

/*
 * Extra opcional: runner de Cucumber.
 *
 * Ejecuta los ficheros .feature de src/test/resources/features con los steps de este paquete.
 * Mientras no haya escenarios no falla (failIfNoTests = false).
 *
 * Para empezar:
 *   1. Escribe un escenario en src/test/resources/features/orders.feature (hay un ejemplo comentado).
 *   2. Ejecuta `mvn test`: Cucumber marcará los pasos como undefined y te propondrá el esqueleto de los steps.
 *   3. Crea una clase OrderSteps en este paquete con @Given, @When y @Then.
 */
@Suite(failIfNoTests = false)
@IncludeEngines("cucumber")
@SelectPackages("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org.kata.store.cucumber")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")
public class RunCucumberTest {
}
