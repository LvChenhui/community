package com.wl.lch.core;

import com.wl.lch.entity.PostEsther;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostEstherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PostEsther record);

    int insertSelective(PostEsther record);

    PostEsther selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PostEsther record);

    int updateByPrimaryKeyWithBLOBs(PostEsther record);

    int updateByPrimaryKey(PostEsther record);

    List<PostEsther> selectLimit(@Param("start") int start, @Param("number") int number,@Param("good") Boolean good,@Param("top") Boolean top,@Param("search") String search);

    List<PostEsther> findPostByLabel(@Param("labelId") int labelId, @Param("start") int start, @Param("number") int number);

    List<PostEsther> selectAll();

    int sumPageSize(@Param("good") Boolean good,@Param("top") Boolean top,@Param("search") String search);

    public int sumPageSizeByLabel(@Param("labelId") int labelId);

    public List<PostEsther> findPostByUserId(@Param("userId") int userId);

    public List<PostEsther> findTopPost();
}