package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import java.util.Arrays;

public abstract class Dr_Leroy_Main extends LinearOpMode {

    public DcMotor RightWheel;
    public DcMotor LeftWheel;

    DcMotor RightFront;
    DcMotor RightBack;
    DcMotor LeftBack;
    DcMotor LeftFront;

    double leftFrontMecanum = 0;
    double rightFrontMecanum = 0;
    double leftBackMecanum = 0;
    double rightBackMecanum = 0;

    public static final double SCALEDPOWER = 1; //Emphasis on current controller reading (vs current motor power) on the drive train


    public void waitForPlayButtonTilt()
    {
        InitializeTilt();
        while (!opModeIsActive() && !isStopRequested()) {
            telemetry.addData("Press the play button one more time, I DARE YOU", "");
            telemetry.update();
        }


    }
    public  void InitializeTilt()
    {
        RightWheel = hardwareMap.dcMotor.get("RW");
        LeftWheel = hardwareMap.dcMotor.get("LW");
    }

    public void waitForPlayButtonMech()
    {
        InitializeTilt();
        while (!opModeIsActive() && !isStopRequested()) {
            telemetry.addData("Press the play button one more time, I DARE YOU", "");
            telemetry.update();
        }


    }
    public  void InitializeMech()
    {
        RightFront = hardwareMap.dcMotor.get("RFM");
        RightBack = hardwareMap.dcMotor.get("RBM");
        LeftBack = hardwareMap.dcMotor.get("LBM");
        LeftFront = hardwareMap.dcMotor.get("LFM");
    }


    public void arcadeMecanum(double y,  double c, DcMotor leftFront, DcMotor rightFront, DcMotor leftBack, DcMotor rightBack) {
        double leftFrontVal = y  + c;
        double rightFrontVal = y  - c;
        double leftBackVal = y  + c;
        double rightBackVal = y  - c;
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);

        //Move range to between 0 and +1, if not already
        double[] wheelPowers = {rightFrontVal, leftFrontVal, leftBackVal, rightBackVal};
        Arrays.sort(wheelPowers);
        if (wheelPowers[3] > 1) {
            leftFrontVal /= wheelPowers[3];
            rightFrontVal /= wheelPowers[3];
            leftBackVal /= wheelPowers[3];
            rightBackVal /= wheelPowers[3];
        }
        double scaledPower = SCALEDPOWER;

       /*
       leftFront.setPower(leftFrontVal*scaledPower+leftFront.getPower()*(1-scaledPower));
       rightFront.setPower(rightFrontVal*scaledPower+rightFront.getPower()*(1-scaledPower));
       leftBack.setPower(leftBackVal*scaledPower+leftBack.getPower()*(1-scaledPower));
       rightBack.setPower(rightBackVal*scaledPower+rightBack.getPower()*(1-scaledPower));
       */
        leftFrontMecanum = leftFrontVal*scaledPower+leftFront.getPower()*(1-scaledPower);
        rightFrontMecanum = rightFrontVal*scaledPower+rightFront.getPower()*(1-scaledPower);
        leftBackMecanum = leftBackVal*scaledPower+leftBack.getPower()*(1-scaledPower);
        rightBackMecanum = rightBackVal*scaledPower+rightBack.getPower()*(1-scaledPower);



    }





}
