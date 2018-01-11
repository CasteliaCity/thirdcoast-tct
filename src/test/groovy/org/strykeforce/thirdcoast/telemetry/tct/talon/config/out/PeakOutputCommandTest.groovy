package org.strykeforce.thirdcoast.telemetry.tct.talon.config.out

import org.strykeforce.thirdcoast.telemetry.tct.Command
import org.strykeforce.thirdcoast.telemetry.tct.talon.config.AbstractTalonConfigCommandTest
import spock.lang.Ignore

class PeakOutputCommandTest extends AbstractTalonConfigCommandTest {

    Command command

    @Override
    void setup() {
        command = new PeakOutputCommand(reader, talonSet)
    }

    def "invalid or no input"() {
        when:
        command.perform()

        then:
        4 * reader.readLine(_) >>> ["ABC", "ABC,ABC", ",", ""]
        0 * talon._
    }

    @Ignore
    def "enters one number for both fwd/rev"() {
        when:
        command.perform()

        then:
        1 * reader.readLine(_) >> "27.67"

        1 * talon.configPeakOutputVoltage(27.67, -27.67)
        1 * talon.getDescription()
        0 * talon._
    }

    @Ignore
    def "enters two numbers for fwd/rev"() {
        when:
        command.perform()

        then:
        1 * reader.readLine(_) >> "27,67"

        1 * talon.configPeakOutputVoltage(27.0, 67.0)
        1 * talon.getDescription()
        0 * talon._
    }

}