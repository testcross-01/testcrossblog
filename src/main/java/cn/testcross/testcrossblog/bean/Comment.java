package cn.testcross.testcrossblog.bean;

import java.util.Date;
import lombok.Data;

/**
 * Table: comment
 */
@Data
public class Comment {
    /**
     * Column:    comment_id
     * Nullable:  false
     */
    private Integer commentId;

    /**
     * Column:    comment_pid
     * Nullable:  true
     */
    private Integer commentPid;

    /**
     * Column:    comment_pname
     * Nullable:  true
     */
    private String commentPname;

    /**
     * Column:    comment_article_id
     * Nullable:  true
     */
    private Integer commentArticleId;

    /**
     * Column:    comment_author_name
     * Nullable:  true
     */
    private String commentAuthorName;

    /**
     * Column:    comment_author_email
     * Nullable:  true
     */
    private String commentAuthorEmail;

    /**
     * Column:    comment_author_url
     * Nullable:  true
     */
    private String commentAuthorUrl;

    /**
     * Column:    comment_author_avatar
     * Nullable:  true
     */
    private String commentAuthorAvatar;

    /**
     * Column:    comment_content
     * Nullable:  true
     */
    private String commentContent;

    /**
     * Column:    comment_agent
     * Nullable:  true
     */
    private String commentAgent;

    /**
     * Column:    comment_ip
     * Nullable:  true
     */
    private String commentIp;

    /**
     * Column:    comment_create_time
     * Nullable:  true
     */
    private Date commentCreateTime;

    /**
     * Column:    comment_role
     * Nullable:  true
     */
    private Integer commentRole;
}