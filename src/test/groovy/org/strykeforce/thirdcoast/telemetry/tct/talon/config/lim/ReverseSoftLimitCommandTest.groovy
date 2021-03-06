package org.strykeforce.thirdcoast.telemetry.tct.talon.config.lim

import org.strykeforce.thirdcoast.telemetry.tct.Command
import org.strykeforce.thirdcoast.telemetry.tct.talon.config.AbstractDoubleConfigCommand
import org.strykeforce.thirdcoast.telemetry.tct.talon.config.AbstractTalonConfigCommandTest
import spock.lang.Ignore

class ReverseSoftLimitCommandTest extends AbstractTalonConfigCommandTest {

    Command command

    @Override
    void setup() {
        command = new ReverseSoftLimitCommand(reader, talonSet)
    }

    def "nothing input"() {
        when:
        command.perform()

        then:
        1 * reader.readLine(_) >> ""
        0 * talon._
    }

    def "handles input"() {
        when:
        command.perform()

        then:
        1 * reader.readLine(_) >>> ["27"]

        1 * talon.configReverseSoftLimitThreshold(27, AbstractDoubleConfigCommand.TIMEOUT_MS) // 27
        2 * talon.getDescription()
        0 * talon._
    }

}
