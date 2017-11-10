package org.strykeforce.thirdcoast.telemetry.tct.talon.config.di;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import javax.inject.Qualifier;

/**
 * Qualifier for Talon config menu.
 */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface TalonConfigMenu {

}
