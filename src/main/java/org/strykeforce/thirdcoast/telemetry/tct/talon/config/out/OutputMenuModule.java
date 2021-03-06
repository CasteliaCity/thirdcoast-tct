package org.strykeforce.thirdcoast.telemetry.tct.talon.config.out;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import java.util.Set;
import javax.inject.Named;
import org.jline.reader.LineReader;
import org.strykeforce.thirdcoast.telemetry.tct.Command;
import org.strykeforce.thirdcoast.telemetry.tct.CommandAdapter;
import org.strykeforce.thirdcoast.telemetry.tct.Menu;
import org.strykeforce.thirdcoast.telemetry.tct.talon.TalonMenu;
import org.strykeforce.thirdcoast.telemetry.tct.talon.TalonSet;

@Module
public abstract class OutputMenuModule {

  @Provides
  @Named("TALON_CONFIG_OUT")
  public static CommandAdapter configCommandsAdapter(
      @Named("TALON_CONFIG_OUT") Set<Command> commands) {
    return new CommandAdapter("TALON_CONFIG_OUT", commands);
  }

  @Provides
  @Named("TALON_CONFIG_OUT")
  public static Menu configMenu(
      @Named("TALON_CONFIG_OUT") CommandAdapter commandAdapter,
      LineReader reader,
      TalonSet talonSet) {
    return new TalonMenu(commandAdapter, reader, talonSet);
  }

  @Binds
  @IntoSet
  @Named("TALON_CONFIG_OUT")
  public abstract Command voltageRampRateCommand(OpenLoopRampRateCommand command);

  @Binds
  @IntoSet
  @Named("TALON_CONFIG_OUT")
  public abstract Command peakOutputVoltageCommand(PeakOutputCommand command);

  @Binds
  @IntoSet
  @Named("TALON_CONFIG_OUT")
  public abstract Command closedLoopRampRateCommand(ClosedLoopRampRateCommand command);

  @Binds
  @IntoSet
  @Named("TALON_CONFIG_OUT")
  public abstract Command nominalOutputVoltageCommand(NominalOutputCommand command);

  @Binds
  @IntoSet
  @Named("TALON_CONFIG_OUT")
  public abstract Command currentLimitCommand(CurrentLimitCommand command);

  @Binds
  @IntoSet
  @Named("TALON_CONFIG_OUT")
  public abstract Command peakCurrentLimitCommand(PeakCurrentLimitCommand command);

  @Binds
  @IntoSet
  @Named("TALON_CONFIG_OUT")
  public abstract Command peakCurrentDurationCommand(PeakCurrentDurationCommand command);

  @Binds
  @IntoSet
  @Named("TALON_CONFIG_OUT")
  public abstract Command brakeInNeutralCommand(BrakeInNeutralCommand command);
}
