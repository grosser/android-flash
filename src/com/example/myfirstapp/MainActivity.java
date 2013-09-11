package com.example.myfirstapp;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
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
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (isLightOn) {
					turnLightOff();
				} else {
					turnLightOn();
				}
			}
		});
	}

	@Override
	// release camera so other apps can use it
	protected void onStop() {
		super.onStop();
		turnLightOff();
	}

	private void turnLightOff() {
		Log.e("err", "Light off!");
		isLightOn = false;

		// TODO change color to black

		if (camera != null) {
			camera.stopPreview();
			camera.release();
			camera = null;
		}
	}

	private void turnLightOn() {
		Log.e("err", "Light on!");
		isLightOn = true;

		// TODO change color to white

		if (hasFlash()) {
			camera = Camera.open();
			Parameters p = camera.getParameters();
			p.setFlashMode(Parameters.FLASH_MODE_TORCH);
			camera.setParameters(p);
			camera.startPreview();
		}
	}

	private boolean hasFlash(){
		return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
	}


	@Override
	// TODO delete !?
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
