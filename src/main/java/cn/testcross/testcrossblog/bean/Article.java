package cn.testcross.testcrossblog.bean;

import java.util.Date;
import lombok.Data;

/**
 * Table: article
 */
@Data
public class Article {
    /**
     * Column:    article_id
     * Nullable:  false
     */
    private Integer articleId;

    /**
     * Column:    article_user_id
     * Nullable:  true
     */
    private Integer articleUserId;

    /**
     * Column:    article_title
     * Nullable:  true
     */
    private String articleTitle;

    /**
     * Column:    article_content
     * Nullable:  true
     */
    private String articleContent;

    /**
     * Column:    article_view_count
     * Nullable:  true
     */
    private Integer articleViewCount;

    /**
     * Column:    article_comment_count
     * Nullable:  true
     */
    private Integer articleCommentCount;

    /**
     * Column:    article_like_count
     * Nullable:  true
     */
    private Integer articleLikeCount;

    /**
     * Column:    article_has_comment
     * Nullable:  true
     */
    private Integer articleHasComment;

    /**
     * Column:    article_status
     * Nullable:  true
     */
    private Integer articleStatus;

    /**
     * Column:    article_order
     * Nullable:  true
     */
    private Integer articleOrder;

    /**
     * Column:    article_update_time
     * Nullable:  true
     */
    private Date articleUpdateTime;

    /**
     * Column:    article_create_time
     * Nullable:  true
     */
    private Date articleCreateTime;

    /**
     * Column:    article_summary
     * Nullable:  true
     */
    private String articleSummary;
}