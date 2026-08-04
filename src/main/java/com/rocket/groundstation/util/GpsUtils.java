package com.rocket.groundstation.util;

import java.util.Locale;
import org.mapsforge.core.util.LatLongUtils;


public class GpsUtils {
    
    public static double haversineDistance(double lat1, double lon1, double lat2, double lon2){
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return c * 6378137.0;
    }
    
    public static double validateLat(String lat) throws NumberFormatException, IllegalArgumentException{
        return LatLongUtils.validateLatitude(Double.parseDouble(lat));
    }
    
    public static double validateLon(String lon) throws NumberFormatException, IllegalArgumentException{
        return LatLongUtils.validateLongitude(Double.parseDouble(lon));
    }
    
    public static String format(double coordinate){
        return String.format(Locale.US, "%.6f", coordinate);
    }
}
