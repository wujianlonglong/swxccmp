package com.example.tansaction2.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wujianlong on 2017/5/4.
 */
@Data
@Entity(name = "USER_INFONEW")
@DynamicInsert(true)
//@DynamicUpdate(true)
public class UserInfo {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pordGenerator")
    //@SequenceGenerator(name = "pordGenerator", sequenceName = "USER_INFO_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.IDENTITY) // MYSQL时可以这样使用自增
    private Long id;

    @Column(nullable = false,  length = 25)
    private String userName;

    @Column(nullable = false, length = 40)
    private String passWord;

    @Column(nullable = true, length = 25)
    private String nickName;

    @Column(nullable = false, length = 30)
    private String department;

    @Column(nullable = false)
    private Integer status;

//    @Column(nullable = false,columnDefinition="date default sysdate")//orcale
@Column(nullable = true, columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ")//mysql
    private Date createTime;
}
