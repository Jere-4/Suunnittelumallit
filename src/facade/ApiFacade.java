package facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ApiFacade {

    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IllegalArgumentException, IOException {

        String json = fetchJson(urlString);
        Object value = findAttribute(json, attributeName);

        if (value == null) {
            throw new IllegalArgumentException(
                    "Attribute '" + attributeName + "' not found in JSON response");
        }

        return value.toString();
    }

    private String fetchJson(String urlString) throws IOException {
        URL url;
        try {
            url = new URL(urlString);
        } catch (Exception e) {
            throw new IOException("Invalid URL: " + urlString, e);
        }

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);

        int status = con.getResponseCode();
        if (status != HttpURLConnection.HTTP_OK) {
            throw new IOException("HTTP request failed with status: " + status);
        }

        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(con.getInputStream()))) {

            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            return json.toString();
        } finally {
            con.disconnect();
        }
    }

    private Object findAttribute(String jsonString, String attributeName) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject root = (JSONObject) parser.parse(jsonString);

            return root.get(attributeName);

        } catch (ParseException e) {
            return null;
        }
    }
}

