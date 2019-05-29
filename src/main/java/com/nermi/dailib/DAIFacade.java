package com.nermi.dailib;

import android.support.v7.app.AppCompatActivity;

public interface DAIFacade {

    /**
     * Initialize UI responsible for autonomously controlling drone
     * @param activity Activity containing the UI
     * @param frameLayoutId Id of frame layout containing the Camera2Fragment
     */
    void initUI(AppCompatActivity activity, int frameLayoutId);

    /**
     * Make the drone pitch forward based on a certain output label
     * @param activity Activity containing frame layout containing Camera2Fragment
     * @param frameLayoutId Id of frame layout containing the Camera2Fragment
     * @param label Label indicating a pitch forward action
     */
    void pitchForward(AppCompatActivity activity, int frameLayoutId, String label);

    /**
     * Make the drone pitch backwards based on a certain output label
     * @param activity Activity containing frame layout containing Camera2Fragment
     * @param frameLayoutId Id of frame layout containing the Camera2Fragment
     * @param label Label indicating a pitch backwards action
     */
    void pitchBackwards(AppCompatActivity activity, int frameLayoutId, String label);

    /**
     * Make the drone roll left based on a certain output label
     * @param activity Activity containing frame layout containing Camera2Fragment
     * @param frameLayoutId Id of frame layout containing the Camera2Fragment
     * @param label Label indicating a roll left action
     */
    void rollLeft(AppCompatActivity activity, int frameLayoutId, String label);

    /**
     * Make the drone roll right based on a certain output label
     * @param activity Activity containing frame layout containing Camera2Fragment
     * @param frameLayoutId Id of frame layout containing the Camera2Fragment
     * @param label Label indicating a roll right action
     */
    void rollRight(AppCompatActivity activity, int frameLayoutId, String label);

    /**
     * Make the drone yaw left based on a certain output label
     * @param activity Activity containing frame layout containing Camera2Fragment
     * @param frameLayoutId Id of frame layout containing the Camera2Fragment
     * @param label Label indicating a yaw left action
     */
    void yawLeft(AppCompatActivity activity, int frameLayoutId, String label);

    /**
     * Make the drone yaw right based on a certain output label
     * @param activity Activity containing frame layout containing Camera2Fragment
     * @param frameLayoutId Id of frame layout containing the Camera2Fragment
     * @param label Label indicating a yaw right action
     */
    void yawRight(AppCompatActivity activity, int frameLayoutId, String label);

    /**
     * Setup mobile remote controller for a certain drone vendor
     */
    void setupMobileRemoteController();

//    void setupVirtualSticksListeners(AppCompatActivity activity, int frameLayoutId);
//
//    void tearDownVirtualSticksListeners();
}
