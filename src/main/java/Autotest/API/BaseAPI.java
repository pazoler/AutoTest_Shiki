package Autotest.API;

import junit.framework.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class BaseAPI {

    public static boolean titleSearchInArrayList(ArrayList<String> Titles, String title) {
        for (String titleInArray : Titles) {
            if (titleInArray.equals(title)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isHostReachable(String address) {
        HttpURLConnection connection = null;

        try {
            connection = (HttpURLConnection) new URL(address).openConnection();
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            if (responseCode == 200)
                return true;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        return false;
    }
}
