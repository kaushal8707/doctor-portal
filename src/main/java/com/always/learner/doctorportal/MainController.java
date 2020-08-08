package com.always.learner.doctorportal;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController
{
    @Autowired
    RestTemplateBuilder restTemplateBuilder;
    @Autowired
    EurekaClient eurekaClient;

    @GetMapping("/doctors")
    public String getDoctors()
    {
        RestTemplate restTemplate=restTemplateBuilder.build();
        InstanceInfo nextServerFromEureka=eurekaClient.getNextServerFromEureka("DOCTORSERVICE",false);
        String url=nextServerFromEureka.getHomePageUrl();
        return restTemplate.getForObject(url+"/location",String.class);
    }
    @GetMapping("/patients")
    public String getPatients()
    {
        RestTemplate restTemplate=restTemplateBuilder.build();
        InstanceInfo nextServerFromEureka=eurekaClient.getNextServerFromEureka("PATIENTSERVICE",false);
        String url=nextServerFromEureka.getHomePageUrl();
        return restTemplate.getForObject(url+"/location",String.class);
    }


}

