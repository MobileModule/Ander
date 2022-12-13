package com.lea.leaander.location;

import static android.content.Context.LOCATION_SERVICE;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;


import java.util.List;

public class LocationEngine implements LocationListener {
    public static final String TAG = LocationEngine.class.getName();
    private Context context;
    private LocationChangedListener listener;

    public LocationEngine(Context context, LocationChangedListener listener) {
        this.context = context;
        this.listener = listener;
    }

    private LocationManager locationManager;
    private Location location;

    public void onResume() {
        locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
        location = new Location(LocationManager.GPS_PROVIDER);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,this);
            if (location != null) {
                if (listener != null) {
                    LeaLocation leaLocation = new LeaLocation();
                    leaLocation.lat = location.getLatitude();
                    leaLocation.lng = location.getLongitude();
                    listener.locationChanged(leaLocation);
                }
            }
        }


    }

    public void onPause() {

    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        if (location != null) {
            if (listener != null) {
                LeaLocation leaLocation = new LeaLocation();
                leaLocation.lat = location.getLatitude();
                leaLocation.lng = location.getLongitude();
                listener.locationChanged(leaLocation);
            }
        }
    }

    @Override
    public void onLocationChanged(@NonNull List<Location> locations) {
        LocationListener.super.onLocationChanged(locations);
    }
}
