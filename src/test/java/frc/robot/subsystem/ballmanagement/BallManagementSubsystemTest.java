package frc.robot.subsystem.ballmanagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.powermock.api.mockito.PowerMockito.whenNew;
import static org.powermock.api.mockito.PowerMockito.verifyNew;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import frc.robot.subsystem.SubsystemTest;
import frc.robot.subsystems.ballmanagement.BallManagementSubsystem;

/**
 * This will test the BallManagementSubsystem. We prepare a couple other classes
 * for test because this subsystem creates a motor
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ BallManagementSubsystem.class // mock new motor initializing
})
public class BallManagementSubsystemTest extends SubsystemTest {

    /**
     * This is a mock version of the motor the intake subsystem uses
     */
    @Mock
    WPI_TalonSRX motor;

    @Before
    public void beforeTest() throws Exception {
        super.beforeTest();

        // when our subsystem is initialized, it will create a motor. We
        // don't want actual motors to be created, we want mock ones. Make sure we
        // return our mocked instances instead of new real instances.
        whenNew(WPI_TalonSRX.class).withArguments(eq(14)).thenReturn(motor);
    }

    /**
     * Test the IntakeSubsystem off + periodic function
     * 
     * @throws Exception
     */
    @Test
    public void testInitialize() throws Exception {
        // create and initialize the subsystem so we have motor objects
        var subsystem = new BallManagementSubsystem();
        subsystem.initialize();

        // verify that the motor is set to intake
        assertNotNull(subsystem.getBallmanagement());
        verifyNew(WPI_TalonSRX.class).withArguments(14);
    }

}
