package facade;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FxRatesClient {

    public static void main(String[] args) {
        ApiFacade api = new ApiFacade();

        try {
            String ratesJson = api.getAttributeValueFromJson(
                    "https://api.fxratesapi.com/latest",
                    "rates"
            );

            JSONParser parser = new JSONParser();
            JSONObject ratesObject = (JSONObject) parser.parse(ratesJson);

            String currency = "EUR";
            Object rate = ratesObject.get(currency);

            if (rate == null) {
                throw new IllegalArgumentException("Currency not found: " + currency);
            }

            System.out.println("Exchange rate for " + currency + ": " + rate);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
