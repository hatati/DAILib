package com.nermi.dailib;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import dji.sdk.mobilerc.MobileRemoteController;

public class DJIFacade implements DAIFacade {


    private MobileRemoteController mMobileRemoteController;

    private static DJIFacade _djiFacade;

    private static class SingletonHelper{
        // Nested class is referenced when getDjiFacade is called
        private static final DJIFacade _djiFacade = new DJIFacade();
    }

    public static DJIFacade getDjiFacade(){
        return SingletonHelper._djiFacade;
    }

    private DJIFacade(){

    }

    @Override
    public void initUI(AppCompatActivity activity, int frameLayoutId) {
        activity.getSupportFragmentManager().beginTransaction().replace(frameLayoutId, Camera2Fragment.newInstance())
                .commit();

        // Initialize the DJI Mobile remote controller and virtual sticks listeners in the fragment onResume method
        activity.getSupportFragmentManager().registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() {
            @Override
            public void onFragmentResumed(FragmentManager fm, Fragment f) {
                super.onFragmentResumed(fm, f);

                try{
                    // Setup the Mobile Remote Controller
                    setupMobileRemoteController();
                }catch (NullPointerException ex){
                    ex.printStackTrace();
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast toast = Toast.makeText(activity, "No Mobile Remote Controller connection", Toast.LENGTH_LONG);
                            toast.show();
                        }
                    });
                }
            }

        }, false);
    }

    @Override
    public void pitchForward(AppCompatActivity activity, int frameLayoutId, String label) {
        ((Camera2Fragment)activity.getSupportFragmentManager().findFragmentById(frameLayoutId))
                .getLabels().put(label, DroneCommands.PITCH_FORWARD);
    }

    @Override
    public void pitchBackwards(AppCompatActivity activity, int frameLayoutId, String label) {
        ((Camera2Fragment)activity.getSupportFragmentManager().findFragmentById(frameLayoutId))
                .getLabels().put(label, DroneCommands.PITCH_BACKWARDS);
    }

    @Override
    public void rollLeft(AppCompatActivity activity, int frameLayoutId, String label) {
        ((Camera2Fragment)activity.getSupportFragmentManager().findFragmentById(frameLayoutId))
                .getLabels().put(label, DroneCommands.ROLL_LEFT);
    }

    @Override
    public void rollRight(AppCompatActivity activity, int frameLayoutId, String label) {
        ((Camera2Fragment)activity.getSupportFragmentManager().findFragmentById(frameLayoutId))
                .getLabels().put(label, DroneCommands.ROLL_RIGHT);
    }

    @Override
    public void yawLeft(AppCompatActivity activity, int frameLayoutId, String label) {
        ((Camera2Fragment)activity.getSupportFragmentManager().findFragmentById(frameLayoutId))
                .getLabels().put(label, DroneCommands.YAW_LEFT);
    }

    @Override
    public void yawRight(AppCompatActivity activity, int frameLayoutId, String label) {
        ((Camera2Fragment)activity.getSupportFragmentManager().findFragmentById(frameLayoutId))
                .getLabels().put(label, DroneCommands.YAW_RIGHT);
    }

    @Override
    public void setupMobileRemoteController() {
        if(mMobileRemoteController == null)
            mMobileRemoteController = DJIApplication.getAircraftInstance().getMobileRemoteController();
    }

    public MobileRemoteController getmMobileRemoteController() {
        return mMobileRemoteController;
    }

    public void setmMobileRemoteController(MobileRemoteController mMobileRemoteController) {
        this.mMobileRemoteController = mMobileRemoteController;
    }

}
