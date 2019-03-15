package com.example.opengl_es_test1;

import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;

import static android.opengl.GLES20.GL_COLOR_BUFFER_BIT;
import static android.opengl.GLES20.glClear;
import static android.opengl.GLES20.glClearColor;
import static android.opengl.GLES20.glViewport;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
//import javax.microedition.khronos.egl.EGLConfig;
//实现render抽象类，重写三个方法
public class FirstRender implements Renderer {
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config)
    {
        glClearColor(1.0f,1.0f, 0.0f, 0.2f);
    }
    @Override
    public void onSurfaceChanged(GL10 glUnused, int width, int height)
    {
        glViewport(0, 0, width, height);
    }
    @Override
    public void onDrawFrame(GL10 glUnused)
    {
        glClear(GL_COLOR_BUFFER_BIT);
    }
}
