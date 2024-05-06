package com.example.demo.service;

import com.example.demo.dto.IPOinfo;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChatService {

    public void discord(List<IPOinfo> sendList, String today) {

    }

    public void slack(List<IPOinfo> sendList, String today) {
        String url = "https://hooks.slack.com/services/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"; // 사용할 슬랙의 Webhook URL 넣기
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> request = new HashMap<String, Object>();
        String message = "";

        if (sendList.size() == 0) {
            message = "오늘은 공모주 일정이 없습니다.";
        }
        else {
            message = getString(sendList, today, message);
        }

        request.put("username", "slackbot");
        request.put("text", message);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String, Object>>(request);
        restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
    }

    public void telegram(List<IPOinfo> sendList, String today) {
        String Token = "";
        String chat_id = "";
        String message = "";
        String url = "https://api.telegram.org/bot" + Token + "/sendmessage?chat_id=" + chat_id + "&text=";
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> request = new HashMap<String, Object>();

        message = getString(sendList, today, message);
        url += message;
        HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String, Object>>(request);
        restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }

    public void printTest(List<IPOinfo> sendList, String today){
        String message = "";
        message = getString(sendList, today, message);
        System.out.println(message);
    }

    private String getString(List<IPOinfo> sendList, String today, String message) {
        if ("일요일".equals(today)) {
            message += "다음주 공모주 일정입니다.\n\n";
        } else {
            message += "오늘의 공모주 일정입니다.\n\n";
        }
        for (int i = 0; i < sendList.size(); i++) {
            message += "공모주일정: " + sendList.get(i).getDate() + "\n";
            message += "종목명: " + sendList.get(i).getCompany() + "\n";
            message += "확정공모가: " + sendList.get(i).getFinalPrice() + "\n";
            message += "희망공모가: " + sendList.get(i).getHopePrice() + "\n";
            message += "주간사: " + sendList.get(i).getStockCompanys() + "\n";
            message += "\n";
        }
        return message;
    }
}
