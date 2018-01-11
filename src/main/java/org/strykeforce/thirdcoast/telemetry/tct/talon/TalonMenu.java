package org.strykeforce.thirdcoast.telemetry.tct.talon;

import java.util.StringJoiner;
import javax.inject.Inject;
import org.jline.reader.LineReader;
import org.strykeforce.thirdcoast.talon.ThirdCoastTalon;
import org.strykeforce.thirdcoast.telemetry.tct.CommandAdapter;
import org.strykeforce.thirdcoast.telemetry.tct.Menu;
import org.strykeforce.thirdcoast.telemetry.tct.Messages;

public class TalonMenu extends Menu {

  private final TalonSet talonSet;

  @Inject
  public TalonMenu(CommandAdapter commandsAdapter, LineReader reader, TalonSet talonSet) {
    super(commandsAdapter, reader);
    this.talonSet = talonSet;
  }

  @Override
  protected String header() {
    StringJoiner joiner = new StringJoiner(", ");
    for (ThirdCoastTalon talon : talonSet.selected()) {
      joiner.add(String.valueOf(talon.getDeviceID()));
    }
    return Messages.boldGreen("\nTalons: " + joiner.toString() + "\n");
  }
}
