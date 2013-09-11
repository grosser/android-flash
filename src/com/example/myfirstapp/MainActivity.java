package com.example.myfirstapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.graphics.Color;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private boolean isLightOn = false;
	private Camera camera;
	private Button button;
	private View v;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button = (Button) findViewById(R.id.buttonFlashlight);
		camera = Camera.open();
		final Parameters p = camera.getParameters();
		
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {

				if (isLightOn) {
					Log.e("err", "Light off!");
					isLightOn = false;

					/*
					 * INSERT CODE here that does the following:
					 * 1. Prints to the LogCat the state you are about to change the light to ("Flashlight is on/off!")
					 * 2. Turns on or off the flash (google "setFlashMode" on Parameters of the camera ('p')
					 * 3. Starts or stops the preview (required for camera access) [e.g. camera.stopPreview(); is run when you want to switch it off]
					 * 4. Changes the background color of our backgroundView (which we'ved named 'v' above)
					 * 5. Adjusts the boolean value accordingly (so we can toggle it again next time)
					 */
				} else {
					Log.e("err", "Light on!");
					isLightOn = true;

					/*
					 * INSERT CODE here that does the following:
					 * 1. Prints to the LogCat the state you are about to change the light to ("Flashlight is on/off!")
					 * 2. Turns on or off the flash (google "setFlashMode" on Parameters of the camera ('p')
					 * 3. Starts or stops the preview (required for camera access) [e.g. camera.stopPreview(); is run when you want to switch it off]
					 * 4. Changes the background color of our backgroundView to Color.WHITE when the light is on and Color.BLACK when the light is off (which we'ved named 'v' above)
					 * 5. Adjusts the boolean value accordingly (so we can toggle it again next time)
					 */
				}
			}
		});

	}

	@Override
	protected void onStop() {
		super.onStop();

		/*
		 * Here we handle the case when the app is Stopped (via exit or by the OS)
		 * [no need for code here, just understand why we've put this here in the onStop Method of the application lifecycle]
		 */
		if (camera != null) {
			camera.release();
		}
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
}
