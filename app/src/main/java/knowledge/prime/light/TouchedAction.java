package knowledge.prime.light;

import android.hardware.Camera;

/**
 * Created by takahisa007 on 8/17/16.
 */
public class TouchedAction {

    private boolean isTurnOn;

    public void execute() {
        System.out.println("execute");

        android.hardware.Camera camera = android.hardware.Camera.open();
        camera.startPreview();

        //light on or off
        if (isTurnOn) {
            //to off
            Camera.Parameters params = camera.getParameters();
            //フラッシュモードを点灯に設定
            params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            //パラメータ設定
            camera.setParameters(params);
        } else {
            //to on


            //パラメータ取得
            Camera.Parameters params = camera.getParameters();
            //フラッシュモードを点灯に設定
            params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            //パラメータ設定
            camera.setParameters(params);
        }




    }
}
