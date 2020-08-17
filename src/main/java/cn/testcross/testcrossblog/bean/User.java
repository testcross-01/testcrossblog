package cn.testcross.testcrossblog.bean;

import java.util.Date;
import lombok.Data;

/**
 * Table: tc_user
 */
@Data
public class User {
    /**
     * Column:    user_id
     * Nullable:  false
     */
    private Integer userId;

    /**
     * Column:    user_name
     * Nullable:  true
     */
    private String userName;

    /**
     * Column:    user_pass
     * Nullable:  true
     */
    private String userPass;

    /**
     * Column:    user_nickname
     * Nullable:  true
     */
    private String userNickname;

    /**
     * Column:    user_email
     * Nullable:  true
     */
    private String userEmail;

    /**
     * Column:    user_url
     * Nullable:  true
     */
    private String userUrl;

    /**
     * Column:    user_avatar
     * Nullable:  true
     */
    private String userAvatar;

    /**
     * Column:    user_last_login_ip
     * Nullable:  true
     */
    private String userLastLoginIp;

    /**
     * Column:    user_register_time
     * Nullable:  true
     */
    private Date userRegisterTime;

    /**
     * Column:    user_last_login_time
     * Nullable:  true
     */
    private Date userLastLoginTime;

    /**
     * Column:    user_status
     * Nullable:  true
     */
    private Integer userStatus;
}