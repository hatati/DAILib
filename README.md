# DAILIB

DAILIB is an experimental android library with the goal of providing a common intelligent mobile remote controller access platform for drones coming from multiple vendors. Custom deep learning models may be used to add autonomous behavior to drones. DAILIB uses `tflite` models to run real time inferences on a video stream.

### Include in Android Project
DAILIB is available in JCenter, the latest version being 1.0.6. To include it in yout project add this to your **app** `build.gradle` file:
`compile 'com.nermi.dailib:dailib:1.0.6'`

### Example
DAILIB provides a fragment containing the setup for live inferencing images from a video stream. This fragment needs to be injected inside a `FrameLayout` view, therefore a frame layout is required in an activity layout:
```
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:id="@+id/container"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#000"
        tools:context="com.nermi.djidronepilot.CameraActivity" />
```

Currently the library only supports DJI drones. An example of how to apply DAILIB in an android application to add custom AI to a DJI drone is available in the following repository: [DjiDronePilot](https://github.com/hatati/DjiDronePilot).

(**Note**: The smartphone is supposed to be attached to the drone with the backcamera facing forward)

### License
The library is released under the GNU General Public License `GPL-3.0-or-later`.
