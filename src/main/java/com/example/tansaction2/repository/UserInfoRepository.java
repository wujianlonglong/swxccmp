package com.example.tansaction2.repository;



import com.example.tansaction2.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wujianlong on 2017/5/4.
 */
public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {
    UserInfo findByUserNameAndStatus(String username, Integer status);

    List<UserInfo> findByStatus(Integer status);

    @Transactional
    @Modifying
    int deleteByNickName(String nickName);

    @Transactional
    @Modifying
    @Query(value = "update USER_INFONEW set nick_name=?",nativeQuery = true)
    int updateByNickName(String nickName);
}
