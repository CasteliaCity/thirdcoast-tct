package org.strykeforce.thirdcoast.telemetry.tct;

import javax.inject.Inject;
import javax.inject.Provider;
import org.jline.reader.LineReader;
import org.strykeforce.thirdcoast.telemetry.tct.servo.ServoMenuComponent;

/**
 * Command to enter mode for working with Servos.
 */
public class ServoModeCommand extends AbstractCommand {

  public final static String NAME = "Work with Servos";
  private final Provider<ServoMenuComponent.Builder> servoMenuComponentProvider;

  @Inject
  public ServoModeCommand(Provider<ServoMenuComponent.Builder> servoMenuComponentProvider,
      LineReader reader) {
    super(NAME, reader);
    this.servoMenuComponentProvider = servoMenuComponentProvider;
  }

  @Override
  public void perform() {
    ServoMenuComponent component = servoMenuComponentProvider.get().build();
    Menu menu = component.menu();
    menu.display();
  }
}
