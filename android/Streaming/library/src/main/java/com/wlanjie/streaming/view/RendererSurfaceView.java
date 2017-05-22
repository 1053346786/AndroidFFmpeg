package com.wlanjie.streaming.view;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;

import com.wlanjie.streaming.camera.CameraCallback;
import com.wlanjie.streaming.camera.CameraViewImpl;
import com.wlanjie.streaming.video.SurfaceRenderer;

/**
 * Created by wlanjie on 2017/5/20.
 */
public class RendererSurfaceView extends GLSurfaceView implements CameraCallback {

    private SurfaceRenderer mSurfaceRenderer;
    private CameraViewImpl mCameraView;

    public RendererSurfaceView(Context context) {
        this(context, null);
    }

    public RendererSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SurfaceRenderer getSurfaceRenderer() {
        return mSurfaceRenderer;
    }

    private void init() {
        mSurfaceRenderer = new SurfaceRenderer(getContext(), this);
        setEGLContextClientVersion(2);
        setRenderer(mSurfaceRenderer);
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {

            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                // stop camera
            }
        });
    }

    @Override
    public void onCameraOpened(int previewWidth, int previewHeight) {

    }

    @Override
    public void onCameraClosed() {

    }

    @Override
    public void onPreviewFrame(byte[] data) {

    }

    @Override
    public void onPreview(int previewWidth, int previewHeight) {

    }
}