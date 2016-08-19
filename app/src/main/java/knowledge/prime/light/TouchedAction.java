package knowledge.prime.light;

import android.hardware.Camera;

/**
 * Created by takahisa007 on 8/17/16.
 */
public class TouchedAction {

    private boolean isTurnOn;

    private static TouchedAction action;

    private android.hardware.Camera camera;
    private Camera.Parameters params;

    public TouchedAction() {
        camera = android.hardware.Camera.open();
        camera.startPreview();
        params = camera.getParameters();
    }

    public static TouchedAction getInstance() {
        if (action == null) {
            action = new TouchedAction();
        }
        return action;
    }

    public boolean execute() {
        System.out.println("execute");

        //light on or off
        if (isTurnOn) {
            //to off
            params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            isTurnOn = false;
        } else {
            //to on
            params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            isTurnOn = true;
        }
        camera.setParameters(params);

        return isTurnOn;

    }
}
