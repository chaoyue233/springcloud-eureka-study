package chaoyue.study.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ConsumerController {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("test")
    public String test() {
        // 通过服务名获取服务信息
        List<ServiceInstance> instances = discoveryClient.getInstances("EUREKA-PROVIDER");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        // 获取其中的一个服务实例进行调用
        ServiceInstance serviceInstance = instances.get(0);
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        System.out.println(host);
        System.out.println(port);
        // 拿到IP和端口之后拼装成地址进行REST接口调用
        String url = "http://" + host + ":" + port + "/providerFunction";
        String result = restTemplate.getForObject(url, String.class);
        return "consumer: " + result;
    }
}
