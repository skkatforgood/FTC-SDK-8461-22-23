package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.Range;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOpTilt", group = "TeleOp")


public class TeleOp extends Dr_Leroy_Main{


    @Override
    public void runOpMode() throws InterruptedException {
        waitForPlayButtonTilt();
        while (opModeIsActive())
        {

        // Setup a variable for each drive wheel to save power level for telemetry
        double leftPower;
        double rightPower;

        // Choose to drive using either Tank Mode, or POV Mode
        // Comment out the method that's not used.  The default below is POV.

        // POV Mode uses left stick to go forward, and right stick to turn.
        // - This uses basic math to combine motions and is easier to drive straight.
        double turn = -gamepad1.left_stick_y;
        double drive  =  gamepad1.right_stick_x;
        leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
        rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

        // Tank Mode uses one stick to control each wheel.
        // - This requires no math, but it is hard to drive forward slowly and keep straight.
        // leftPower  = -gamepad1.left_stick_y ;
        // rightPower = -gamepad1.right_stick_y ;

        // Send calculated power to wheels
        LeftWheel.setPower(leftPower);
        RightWheel.setPower(rightPower);
        }
    }
}
