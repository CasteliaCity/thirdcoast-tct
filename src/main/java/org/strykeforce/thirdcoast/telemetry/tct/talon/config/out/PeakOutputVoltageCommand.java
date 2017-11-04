package org.strykeforce.thirdcoast.telemetry.tct.talon.config.out;

import com.ctre.CANTalon;
import javax.inject.Inject;
import org.jline.reader.LineReader;
import org.strykeforce.thirdcoast.telemetry.tct.talon.TalonSet;
import org.strykeforce.thirdcoast.telemetry.tct.talon.config.FwdRevDoubleConfigCommand;

/**
 * Configure F.
 */
public class PeakOutputVoltageCommand extends FwdRevDoubleConfigCommand {

  public final static String NAME = "Peak Ouput Voltage";

  @Inject
  public PeakOutputVoltageCommand(TalonSet talonSet, LineReader reader) {
    super(NAME, reader, talonSet);
  }

  @Override
  protected void config(CANTalon talon, double foward, double reverse) {
    talon.configPeakOutputVoltage(foward, reverse);
  }
}
