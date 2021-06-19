package com.example.flashlight;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity {
    private SwitchCompat sw;
    private CameraManager cameraManager;
    private String cameraId;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sw = findViewById(R.id.switch1);
        cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);

        try {
            cameraId = cameraManager.getCameraIdList()[0];
        }catch (CameraAccessException e){
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void torch(View view) {
       if(sw.isChecked()){
           try{
               // Enabling Flash light associated with cameraId.
               cameraManager.setTorchMode(cameraId,true);
           }catch (CameraAccessException e){
               e.printStackTrace();
           }
       }
       else {
           try{
               // Turning Flaslight OFF
               cameraManager.setTorchMode(cameraId,false);
           }catch (CameraAccessException e){
               e.printStackTrace();
           }
       }
    }
}