package bridge;

public class Main {
    public static void main(String[] args) {

        SmartTV smartTV = new SmartTV();
        SmartRemote smartRemote = new SmartRemote(smartTV);

        smartRemote.togglePower();
        smartRemote.volumeUp();
        smartRemote.channelUp();
        smartRemote.voiceControl("Open YouTube");
        smartTV.browseInternet();
    }
}
