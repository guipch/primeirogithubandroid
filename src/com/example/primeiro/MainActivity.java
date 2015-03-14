package com.example.primeiro;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void runApp1(View v) {
	    Intent i = new Intent(Intent.ACTION_VIEW, 
	             Uri.parse("http://www.acertotec.com.br/"));
	    startActivity(i);
	}
	public void runApp2(View v) {
	     Intent i = new Intent();
	     i.setClassName("com.android.calculator2", "com.android.calculator2.Calculator");
	     startActivity(i);
	 }
	public void runApp3(View v) {
	    String msg = "Hello World, again!";
	    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}
	public void runApp4(View v) {
	     Vibrator vib;
	     vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
	     vib.vibrate(1000);
	}
	public void runApp5(View v) {
	    LocationManager locator = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	    Location l = locator.getLastKnownLocation(LocationManager.GPS_PROVIDER);
	    if (l == null) {
	        // Fall back to coarse location.
	        l = locator.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
	    }
	    double alt = l.getAltitude();
	    double lat = l.getLatitude();
	    double lon = l.getLongitude();
	    long time = l.getTime();
	    float acc = l.getAccuracy();
	    float speed = l.getSpeed();
	    String prov = l.getProvider();
	    String msg =
	        "Lat: " + lat + "\n" +
	        "Long: " + lon + "\n" +  
	        "Alt: " + alt + "\n" +  
	        "Time: " + time + "\n" +  
	        "Accuracy: " + acc + "\n" +  
	        "Speed: " + speed + "\n" +
	        "Provider: " + prov + "\n";
	    Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
	}
	public void runApp6(View v) {
	    String msg;
	    WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
	    if (wifi.isWifiEnabled()) {
	        msg = "Wifi ligado\n";
	        WifiInfo winfo = wifi.getConnectionInfo();
	    
	        int ipadd = winfo.getIpAddress();
	        String ip = String.format("%d.%d.%d.%d",
	           ipadd & 0xff,
	           ipadd >> 8 & 0xff,
	           ipadd >> 16 & 0xff,
	           ipadd >> 24 & 0xff);
	        msg +=
	           "BSSID: " + winfo.getBSSID() + "\n" +
	           "IP: " + ip + "\n" +
	           "Speed: " + winfo.getLinkSpeed() + "\n" +
	           "MAC: " + winfo.getMacAddress() + "\n" +
	           "RSSI: " + winfo.getRssi() + "\n" +
	           "SSID: " + winfo.getSSID();
	    } else
	        msg = "Wifi desligado";
	    Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
	}

}
