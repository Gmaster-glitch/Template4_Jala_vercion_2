package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.openftc.apriltag.AprilTagDetection;

public class AprilTagSubsystem {
    private AprilTagProcessor processor;

    private AprilTagDetection tag;
    private VisionPortal visionPortal;
    private Telemetry telemetry;

    public AprilTagSubsystem(HardwareMap hardwareMap, Telemetry telemetry) {//inicializa el subsistema
        processor = new AprilTagProcessor.Builder().build();
        // Adjust Image Decimation to trade-off detection-range for detection-rate.
        // e.g. Some typical detection data using a Logitech C920 WebCam
        // Decimation = 1 ..  Detect 2" Tag from 10 feet away at 10 Frames per second
        // Decimation = 2 ..  Detect 2" Tag from 6  feet away at 22 Frames per second
        // Decimation = 3 ..  Detect 2" Tag from 4  feet away at 30 Frames Per Second
        // Decimation = 3 ..  Detect 5" Tag from 10 feet away at 30 Frames Per Second
        // Note: Decimation can be changed on-the-fly to adapt during a match.
        processor.setDecimation(2);
        // Create the vision portal by using a builder.
        if (true) {//if camera mounted
            visionPortal = new VisionPortal.Builder()
                    .setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"))
                    .addProcessor(processor)
                    .build();
        } else {
            visionPortal = new VisionPortal.Builder()
                    .setCamera(BuiltinCameraDirection.FRONT)
                    .addProcessor(processor)
                    .build();
        }
    }

    public void periodic() {
    }

    public org.firstinspires.ftc.vision.apriltag.AprilTagDetection getAprilTag(int tagNumber) {
        for (org.firstinspires.ftc.vision.apriltag.AprilTagDetection detection : processor.getDetections())  {
            // Original source data
            if (detection.id == tagNumber) {
                telemetry.addData("Apriltag Position", "X: " + detection.rawPose.x + " Y: " + detection.rawPose.y + " Z: " + detection.rawPose.z);
                return detection;
            }
        }
        telemetry.addData("Apriltag", "Not Found");
        return null;
    }
}
