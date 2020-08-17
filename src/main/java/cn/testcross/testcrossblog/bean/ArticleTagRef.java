package cn.testcross.testcrossblog.bean;

import lombok.Data;

/**
 * Table: article_tag_ref
 */
@Data
public class ArticleTagRef {
    /**
     * Column:    article_id
     * Nullable:  false
     */
    private Integer articleId;

    /**
     * Column:    tag_id
     * Nullable:  false
     */
    private Integer tagId;
}