package com.example.opengl_es_test1;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class MyGLSurfaceView extends GLSurfaceView {
    private final FirstRender renderer;

    public MyGLSurfaceView(Context context){
        super(context);
        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2);

        renderer = new FirstRender();
        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(renderer);
    }
}
