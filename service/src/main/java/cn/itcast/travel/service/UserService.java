package cn.itcast.travel.service;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Map;

public interface UserService {

    boolean register(User user);

    boolean activeUser(String Code);

    ResultInfo login(Map<String, String> postParams) throws JsonProcessingException;
}
