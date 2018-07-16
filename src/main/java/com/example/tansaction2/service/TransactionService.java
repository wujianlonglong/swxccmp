package com.example.tansaction2.service;


import com.example.tansaction2.domain.UserInfo;
import com.example.tansaction2.repository.UserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class TransactionService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Transactional
    public void saveUser() throws InterruptedException {
        log.info("saveUser start");
//        List<UserInfo> userInfos = userInfoRepository.findByStatus(1);

//        UserInfo userInfo = new UserInfo();
//        userInfo.setId(1l);
//        userInfo.setNickName("管理员1");
//        userInfo.setUserName("admin1");
//        userInfo.setPassWord("123");
//        userInfo.setDepartment("全渠道");
//        userInfo.setStatus(1);
//        userInfoRepository.save(userInfo);

        List<UserInfo> userInfos = userInfoRepository.findByStatus(1);
        userInfoRepository. updateByNickName("nickname");
//        userInfoRepository.deleteByNickName("nickname");
        log.info("updateByNickName end");

        Thread.sleep(10*1000);


        UserInfo u = new UserInfo();
//        u.setId(2l);
        u.setNickName("管理员2");
        u.setUserName("admin2");
        u.setPassWord("123");
        u.setDepartment("全渠道");
        u.setStatus(1);
        userInfoRepository.save(u);

    }

}
