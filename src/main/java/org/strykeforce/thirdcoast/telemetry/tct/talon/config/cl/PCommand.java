package org.strykeforce.thirdcoast.telemetry.tct.talon.config.cl;

import javax.inject.Inject;
import org.jline.reader.LineReader;
import org.strykeforce.thirdcoast.talon.ThirdCoastTalon;
import org.strykeforce.thirdcoast.telemetry.tct.talon.TalonSet;
import org.strykeforce.thirdcoast.telemetry.tct.talon.config.AbstractDoubleConfigCommand;

/** Configure P. */
public class PCommand extends AbstractDoubleConfigCommand {

  public static final String NAME = "P";

  @Inject
  public PCommand(LineReader reader, TalonSet talonSet) {
    super(NAME, reader, talonSet);
  }

  @Override
  protected void saveConfig(double value) {
    talonSet.talonConfigurationBuilder().P(value);
  }

  @Override
  protected void config(ThirdCoastTalon talon, double value) {
    talon.config_kP(0, value, TIMEOUT_MS);
  }
}
