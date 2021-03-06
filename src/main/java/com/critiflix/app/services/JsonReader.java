package com.critiflix.app.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class JsonReader {
	
	public JsonReader() {
		
	}

  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    JSONObject jso = null;
    
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);

      JSONParser parser = new JSONParser(); 
      jso = (JSONObject) parser.parse(jsonText);

      
    } catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
      is.close();
    }

    return jso;
  }

//  public static void main(String[] args) throws IOException, JSONException {
//    JSONObject json = readJsonFromUrl("https://graph.facebook.com/19292868552");
//    System.out.println(json.toString());
//    System.out.println(json.get("id"));
//  }
}