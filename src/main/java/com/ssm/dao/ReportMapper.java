package com.ssm.dao;

import com.ssm.pojo.Report;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReportMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reply
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reply
     *
     * @mbggenerated
     */
    int insert(Report record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reply
     *
     * @mbggenerated
     */
    Report selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reply
     *
     * @mbggenerated
     */
    List<Report> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table reply
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Report record);

    List<Report> selectReportByGoodsPrimaryKey(@Param("gid") Integer gid);


}