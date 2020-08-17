package cn.testcross.testcrossblog.bean;

import lombok.Data;

/**
 * Table: article_category_ref
 */
@Data
public class ArticleCategoryRef {
    /**
     * Column:    article_id
     * Nullable:  false
     */
    private Integer articleId;

    /**
     * Column:    category_id
     * Nullable:  false
     */
    private Integer categoryId;
}