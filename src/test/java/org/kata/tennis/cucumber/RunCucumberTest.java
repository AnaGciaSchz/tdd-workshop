package org.kata.tennis.cucumber;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org.kata.tennis.cucumber") //Necesario porque los steps no
// están en el paquete feature
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "not @pendiente") // Excluir los pemdientes, no
// usamos bbdd de verdad aquí
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty") //salida legible
@ConfigurationParameter(key = PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true") //quitar el banner de cucumber
public class RunCucumberTest {
}
