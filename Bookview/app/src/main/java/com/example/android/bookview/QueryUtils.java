package com.example.android.bookview;


import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public final class QueryUtils {

    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e("hi", "Problem building the URL ", e);
        }
        return url;
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e("hi", "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e("hi", "Problem retrieving the earthquake JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    private QueryUtils() {
    }

    public static ArrayList<custom> extractbooks(String bookJson) {
        String authorname;
        if (TextUtils.isEmpty(bookJson)) {
            return null;
        }
        ArrayList<custom> book = new ArrayList<>();
        try {
            JSONObject baseJsonResponse = new JSONObject(bookJson);
            JSONArray bookarray = baseJsonResponse.getJSONArray("items");

            for (int i = 0; i < bookarray.length(); i++) {
                JSONObject current = bookarray.getJSONObject(i);
                JSONObject info = current.getJSONObject("volumeInfo");
                String bookname = info.getString("title");
                if(info.has("authors")) {
                     authorname = info.getString("authors");
                    authorname = authorname.replaceAll("\\[", "by ").replaceAll("\\]","");
                    custom books = new custom(bookname, authorname);
                    book.add(books);
                }
                 else{
                    authorname="No Author";
                    custom books=new custom(bookname,authorname);
                    book.add(books);
                 }




            }

        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the JSON results", e);
        }
        return book;
    }

    public static List<custom> fetchData(String requestUrl) {
        URL url = createUrl(requestUrl);
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e("hi", "Problem making the HTTP request.", e);
        }
        List<custom> book = extractbooks(jsonResponse);
        return book;
    }
}


