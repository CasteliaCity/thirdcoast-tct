package org.strykeforce.thirdcoast.telemetry.tct.talon.config.enc

import org.strykeforce.thirdcoast.telemetry.tct.Command
import org.strykeforce.thirdcoast.telemetry.tct.talon.config.AbstractTalonConfigCommandTest
import spock.lang.Ignore

class ReverseOutputCommandTest extends AbstractTalonConfigCommandTest {

    Command command

    @Override
    void setup() {
        command = new ReverseOutputCommand(reader, talonSet)
    }

    def "nothing selected"() {
        given:
        reader.readLine(_) >> ""

        when:
        command.perform()

        then:
        0 * talon._
    }

    def "yes selected"() {
        given:
        reader.readLine(_) >> "Y"

        when:
        command.perform()

        then:
        1 * talon.setInverted(true)
        1 * talon.getDescription()
        0 * talon._
    }

    def "no selected"() {
        given:
        reader.readLine(_) >> "N"

        when:
        command.perform()

        then:
        1 * talon.setInverted(false)
        1 * talon.getDescription()
        0 * talon._
    }
}
