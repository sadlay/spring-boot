package com.lay.rest;

import com.lay.rest.entity.InstanceInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.management.ObjectName;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestApplicationTests {
    private final static Logger log = LoggerFactory.getLogger(RestApplicationTests.class);

    @Test
    public void contextLoads() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://172.23.4.11:8762/eureka/apps";
        //请求头
        HttpHeaders headers = new HttpHeaders();
        //设置请求内容为JSON类型
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        ArrayList<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        headers.setAccept(mediaTypes);

        //创建请求实体对象
        HttpEntity entity = new HttpEntity(null, headers);
        ResponseEntity<Map> exchange = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);
        Map body = exchange.getBody();
        Map applicationsMap = (Map) body.get("applications");
        List<Map> applicationList = (List<Map>) applicationsMap.get("application");

        List<InstanceInfo> serverList = new ArrayList();
        for (Map applicationMap : applicationList) {
            List<Map> instanceList = (List<Map>) applicationMap.get("instance");
            for (Map<String, Object> instanceMap : instanceList) {
                InstanceInfo instanceInfo = new InstanceInfo();
                instanceInfo.setInstanceId(String.valueOf(instanceMap.get("instanceId")));
                instanceInfo.setInstanceName(String.valueOf(instanceMap.get("app")));
                instanceInfo.setHomePageUrl(String.valueOf(instanceMap.get("homePageUrl")));
                instanceInfo.setHostName(String.valueOf(instanceMap.get("hostName")));
                instanceInfo.setIpAddress(String.valueOf(instanceMap.get("ipAddr")));
                instanceInfo.setPort(String.valueOf(((Map) instanceMap.get("metadata")).get("management.port")));

                Map<String, Object> leaseInfo = (Map) instanceMap.get("leaseInfo");
                instanceInfo.setServiceUpTimesString(String.valueOf(leaseInfo.get("serviceUpTimestamp")));
                instanceInfo.setRegistrationTimesString(String.valueOf(leaseInfo.get("registrationTimestamp")));
                instanceInfo.setLastRenewalTimesString(String.valueOf(leaseInfo.get("lastRenewalTimestamp")));
                instanceInfo.setStatus(String.valueOf(instanceMap.get("status")));
                serverList.add(instanceInfo);
            }
        }
        serverList.sort(Comparator.comparing(InstanceInfo::getInstanceName));
        List<InstanceInfo> collect = serverList.stream().filter(new Predicate<InstanceInfo>() {
            @Override
            public boolean test(InstanceInfo instanceInfo) {
                return true;
            }
        }).collect(Collectors.toList());
        log.info("serverList:{}", collect);
    }

    @Test
    public void testDown(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://172.24.0.63:9001/"+"shutdown";
        //请求头
        ResponseEntity<Object> objectResponseEntity = restTemplate.postForEntity(url, new HttpEntity<>(null), Object.class);
        Object body = objectResponseEntity.getBody();
    }

    @Test
    public void testDown2(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://172.23.4.11:8762/eureka/apps/Z-DEV-SHARE-SYSTEM-912/172.24.0.63:9001";
        //请求头
        restTemplate.delete(url);
    }

}
