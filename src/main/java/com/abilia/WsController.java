package com.abilia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class WsController {

    int count;

    private SimpMessagingTemplate template;

    @Autowired
    public WsController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @Scheduled(fixedDelay = 2000)
    public void doEvenly() throws Exception{
        count++;
        int owner = (count % 5) + 1;
        String type = (count % 3) == 0 ? "calendar" : ((count % 3) == 1 ? "storage" : "sortable");
        template.convertAndSend("/data/" + owner, new WsEvent(type, owner, count));
        System.out.println("Sending \"" + type + "\' to " + owner);
    }
}
