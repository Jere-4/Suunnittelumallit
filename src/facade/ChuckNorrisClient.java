package facade;

public class ChuckNorrisClient {

    public static void main(String[] args) {
        ApiFacade api = new ApiFacade();

        try {
            String joke = api.getAttributeValueFromJson(
                    "https://api.chucknorris.io/jokes/random",
                    "value"
            );
            System.out.println("Chuck Norris joke:");
            System.out.println(joke);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
