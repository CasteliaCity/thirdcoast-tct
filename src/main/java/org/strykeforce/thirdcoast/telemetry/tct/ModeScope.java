package org.strykeforce.thirdcoast.telemetry.tct;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import javax.inject.Scope;

@Documented
@Retention(RUNTIME)
@Scope
public @interface ModeScope {

}