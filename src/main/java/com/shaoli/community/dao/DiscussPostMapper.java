package com.shaoli.community.dao;

import com.shaoli.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    //userId用于“我的帖子”开发，offset为起始行行号，limit记录最多显示数据量
    //userId在首页上为0，不用这个条件
    List<DiscussPost> selectDiscussPosts(int userId,int offset,int limit);

    //@Param用于给参数取别名
    //如果只有一个参数，并且在<if>里使用，则必须加别名
    //查询帖子的行数
    int selectDiscussPostRows(@Param("userId") int userId);

}
