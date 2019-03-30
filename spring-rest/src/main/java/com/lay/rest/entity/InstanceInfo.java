package com.lay.rest.entity;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 13:00 2019/3/28
 * @Modified By:IntelliJ IDEA
 */
public class InstanceInfo {

    // 实例Id，（Ip:port 唯一）
    private String instanceId;

    // 实例名称
    private String instanceName;

    // 实例服务路径 (Http(s)://Ip:port/)
    private String homePageUrl;

    // 实例主机域名
    private String hostName;

    // 实例Ip
    private String ipAddress;

    // 实例端口
    private String port;

    // 实例启动时间
    private String serviceUpTimesString;

    // 实例注册时间
    private String registrationTimesString;

    // 实例最近更新时间
    private String lastRenewalTimesString;

    // 实例状态 （启动 宕机）
    private String status;

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public String getHomePageUrl() {
        return homePageUrl;
    }

    public void setHomePageUrl(String homePageUrl) {
        this.homePageUrl = homePageUrl;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getServiceUpTimesString() {
        return serviceUpTimesString;
    }

    public void setServiceUpTimesString(String serviceUpTimesString) {
        this.serviceUpTimesString = serviceUpTimesString;
    }

    public String getRegistrationTimesString() {
        return registrationTimesString;
    }

    public void setRegistrationTimesString(String registrationTimesString) {
        this.registrationTimesString = registrationTimesString;
    }

    public String getLastRenewalTimesString() {
        return lastRenewalTimesString;
    }

    public void setLastRenewalTimesString(String lastRenewalTimesString) {
        this.lastRenewalTimesString = lastRenewalTimesString;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
