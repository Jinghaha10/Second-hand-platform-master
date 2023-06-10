package com.ssm.dao;

import com.ssm.pojo.Catelog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CatelogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catelog
     *
     * @mbggenerated
     */ int deleteByPrimaryKey(Integer id);


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catelog
     *
     * @mbggenerated
     */
    int insert(Catelog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catelog
     *
     * @mbggenerated
     */
    Catelog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catelog
     *
     * @mbggenerated
     */
    List<Catelog> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table catelog
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Catelog record);


    List<Catelog> getAllCatelogByStatus(@Param("status") Byte status);


    int getCount(Catelog catelog);
    

    int updateCatelogNum(@Param("id") Integer id, @Param("number") Integer number);

    List<Catelog> searchCatelogByName(@Param("name") String name);
}