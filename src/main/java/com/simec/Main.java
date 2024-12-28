package com.simec;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simec.model.Event;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Missing username.");
            return;
        }

        if (args[0].isEmpty()) {
            System.out.println("Missing username.");
            return;
        }

        Event[] events = getEventsForUsername(args[0]);

        for (Event event : events) {
            String description = DescriptionFactory.forEvent(event);
            System.out.println(description);
        }
    }

    private static Event[] getEventsForUsername(String username) {
        try {
            URL url = new URI("https://api.github.com/users/" + username + "/events").toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            InputStream responseStream = connection.getInputStream();
            return new ObjectMapper().readValue(responseStream, Event[].class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Event[0];
    }
}