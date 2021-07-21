package com.example.gatest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTask {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() throws URISyntaxException {
        WebClient client = WebClient.create();
        client.post()
                .uri(new URI("www.google-analytics.com/collect"))
                .body(BodyInserters.fromValue("v=1&t=event&tid=UA-46171473-1&cid=555&ec=transaction&ea=commit&ev=" + new Date().getTime()))
                .retrieve()
                .bodyToMono(String.class)
                .block();
        
        log.info("The time is now {}", dateFormat.format(new Date()));
    }
}
