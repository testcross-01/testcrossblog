package cn.testcross.testcrossblog.bean;

import lombok.Data;

/**
 * Table: tag
 */
@Data
public class Tag {
    /**
     * Column:    tag_id
     * Nullable:  false
     */
    private Integer tagId;

    /**
     * Column:    tag_name
     * Nullable:  true
     */
    private String tagName;

    /**
     * Column:    tag_description
     * Nullable:  true
     */
    private String tagDescription;
}