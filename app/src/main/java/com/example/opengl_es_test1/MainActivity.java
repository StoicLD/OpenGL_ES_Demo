package com.example.opengl_es_test1;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GLSurfaceView glSurfaceView;
    private boolean renderset = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //glSurfaceView = new GLSurfaceView(this);
        glSurfaceView = new MyGLSurfaceView(this);
        final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        final boolean supportES2 = configurationInfo.reqGlEsVersion >= 0x20000
                                    || (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
                                        && (Build.FINGERPRINT.startsWith("generic")
                                            || Build.FINGERPRINT.startsWith("unknown")
                                            || Build.MODEL.contains("google_sdk")
                                            || Build.MODEL.contains("Emulator")
                                            || Build.MODEL.contains("Android SDK built for x86"));
        //final boolean supportES2 = true;
        if(supportES2)
        {
            //glSurfaceView.setEGLContextClientVersion(2);
            setContentView(glSurfaceView);
            //glSurfaceView.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
            //glSurfaceView.setRenderer(new FirstRender());
            //glSurfaceView.setVisibility(View.VISIBLE);
            renderset = true;
        }
        else
        {
            Toast.makeText(this, "该设备不支持OpenGL ES 2.0", Toast.LENGTH_LONG).show();
            return;
        }
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        if(renderset)
        {
            glSurfaceView.onPause();

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(renderset)
        {
            glSurfaceView.onResume();
        }
    }
}
