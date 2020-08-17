package cn.testcross.testcrossblog.service;

import cn.testcross.testcrossblog.bean.Article;
import cn.testcross.testcrossblog.bean.Tag;

import java.util.List;

public interface TagService {
    /*
        tag基础的增删改查
     */
    void addTag(Tag tag);

    void deleteTagById(Integer id);
    //void deleteBatch(Tag tag);
    void updateTagById(Tag tag,Integer id);
    Tag queryTagById(Integer id);

   // List<Tag> queryByFiled(Tag tag);

    /**
     * 根据属性查询
     * @param id
     * @return
     */
    List<Tag> queryTagByArticleId(Integer id);

    /**
     * 查询所有tag
     * @return
     */
    List<Tag> queryAllTag();
}
