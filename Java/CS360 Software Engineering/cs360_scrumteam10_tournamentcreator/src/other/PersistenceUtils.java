package other;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class PersistenceUtils {

	public PersistenceUtils() {
		
	}
	
	public static String calculateDistance(String origin, String destination) {
		
        String str = "https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins=" +  origin + 
        		"&destinations=" + destination + "&key=AIzaSyC3gEKpnaRXCbAiOYgkv_adAvsU1IPVX1g";
        String result = "";
        
        try {
        	URL url = new URL(str);
        	String urlResult = "";
        	String inputLine = "";
        	
            URLConnection yc = url.openConnection();
            BufferedReader in = new BufferedReader(
                                    new InputStreamReader(
                                    yc.getInputStream()));
            
            while ((inputLine = in.readLine()) != null) 
                urlResult+=inputLine;
            
            int indexOfString = urlResult.indexOf("distance\" : {");
            int nextIndex = urlResult.indexOf("\"duration\" : {");
            
            result = urlResult.substring(indexOfString, nextIndex);
            result = result.replaceAll("[^\\d.,-]", "");
            result = result.substring(0, result.length()-1);
            result = result.split(",")[1];
            
            in.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    
    
	}
	
	public static String[] getGeoPointFromAddress(String locationAddress) {
		
        String locationAddres = locationAddress.replaceAll(" ", "%20");
        String str = "https://maps.googleapis.com/maps/api/geocode/json?address="
                + locationAddres + "&sensor=true&key=AIzaSyC3gEKpnaRXCbAiOYgkv_adAvsU1IPVX1g";
        String latLng = "";
        String[] latLngArr = new String[2];
        
        try {
        	URL url = new URL(str);
        	String result = "";
        	
            URLConnection yc = url.openConnection();
            BufferedReader in = new BufferedReader(
                                    new InputStreamReader(
                                    yc.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) 
                result+=inputLine;
            
            
            int indexOfString = result.indexOf("\"location\" : {");
            int nextIndex = result.indexOf("location_type\" :");
            
            latLng = result.substring(indexOfString, nextIndex);
            latLng = latLng.replaceAll("[^\\d.,-]", "");
            latLng = latLng.substring(0, latLng.length()-1);
            
            latLngArr = latLng.split(",");
            
            in.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return latLngArr;
    
    
	}
	
}
