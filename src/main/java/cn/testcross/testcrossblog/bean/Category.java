package cn.testcross.testcrossblog.bean;

import lombok.Data;

/**
 * Table: category
 */
@Data
public class Category {
    /**
     * Column:    category_id
     * Nullable:  false
     */
    private Integer categoryId;

    /**
     * Column:    category_pid
     * Nullable:  true
     */
    private Integer categoryPid;

    /**
     * Column:    category_name
     * Nullable:  true
     */
    private String categoryName;

    /**
     * Column:    category_description
     * Nullable:  true
     */
    private String categoryDescription;

    /**
     * Column:    category_order
     * Nullable:  true
     */
    private Integer categoryOrder;

    /**
     * Column:    category_icon
     * Nullable:  true
     */
    private String categoryIcon;
}