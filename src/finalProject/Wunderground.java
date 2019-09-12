package finalProject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.JsonElement;
// Requires gson jars
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Wunderground 
{         
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception 
	{
		// Get from http://www.wunderground.com/weather/api/
//		String key;
//		if(args.length < 1) {
//			System.out.println("Enter key: ");
//			
//			Scanner in = new Scanner(System.in);
//			key = in.nextLine();
//		} else {
//			key = args[0];
//		}
		
		String sURL = "http://api.wunderground.com/api/96d0230d9b961e4d/conditions/forecast/q/autoip.json";
		// Connect to the URL
		URL url = new URL(sURL);
		HttpURLConnection request = (HttpURLConnection) url.openConnection();
		request.connect();
		
		// Convert to a JSON object to print data
    	JsonParser jp = new JsonParser();
    	JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
    	JsonObject rootobj = root.getAsJsonObject(); // may be Json Array if it's an array, or other type if a primitive
    	
    	// Get some data elements and print them
    	double temp_f = rootobj.get("current_observation").getAsJsonObject().get("temp_f").getAsDouble();
		System.out.println(temp_f);
		
		String todayforecast = rootobj.get("forecast").getAsJsonObject().get("txt_forecast").getAsJsonObject().get("forecastday").getAsJsonArray().get(0).getAsJsonObject().get("fcttext").getAsString();
		System.out.println(todayforecast);
	}

}