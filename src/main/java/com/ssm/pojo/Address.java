package com.ssm.pojo;

public class Address {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.uid
     *
     * @mbggenerated
     */
    private Integer uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.recv_name
     *
     * @mbggenerated
     */
    private String recvName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.recv_province
     *
     * @mbggenerated
     */
    private String recvProvince;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.recv_city
     *
     * @mbggenerated
     */
    private String recvCity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.recv_area
     *
     * @mbggenerated
     */
    private String recvArea;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.recv_district
     *
     * @mbggenerated
     */
    private String recvDistrict;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.recv_addr
     *
     * @mbggenerated
     */
    private String recvAddr;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.recv_phone
     *
     * @mbggenerated
     */
    private String recvPhone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.recv_tel
     *
     * @mbggenerated
     */
    private String recvTel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.recv_zip
     *
     * @mbggenerated
     */
    private String recvZip;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.recv_tag
     *
     * @mbggenerated
     */
    private String recvTag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.is_default
     *
     * @mbggenerated
     */
    private Integer isDefault;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.created_user
     *
     * @mbggenerated
     */
    private String createdUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.created_time
     *
     * @mbggenerated
     */
    private String createdTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.modified_user
     *
     * @mbggenerated
     */
    private String modifiedUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column address.modified_time
     *
     * @mbggenerated
     */
    private String modifiedTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address
     *
     * @mbggenerated
     */
    public Address(Integer id, Integer uid, String recvName, String recvProvince, String recvCity, String recvArea, String recvDistrict, String recvAddr, String recvPhone, String recvTel, String recvZip, String recvTag, Integer isDefault, String createdUser, String createdTime, String modifiedUser, String modifiedTime) {
        this.id = id;
        this.uid = uid;
        this.recvName = recvName;
        this.recvProvince = recvProvince;
        this.recvCity = recvCity;
        this.recvArea = recvArea;
        this.recvDistrict = recvDistrict;
        this.recvAddr = recvAddr;
        this.recvPhone = recvPhone;
        this.recvTel = recvTel;
        this.recvZip = recvZip;
        this.recvTag = recvTag;
        this.isDefault = isDefault;
        this.createdUser = createdUser;
        this.createdTime = createdTime;
        this.modifiedUser = modifiedUser;
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", uid=" + uid +
                ", recvName='" + recvName + '\'' +
                ", recvProvince='" + recvProvince + '\'' +
                ", recvCity='" + recvCity + '\'' +
                ", recvArea='" + recvArea + '\'' +
                ", recvDistrict='" + recvDistrict + '\'' +
                ", recvAddr='" + recvAddr + '\'' +
                ", recvPhone='" + recvPhone + '\'' +
                ", recvTel='" + recvTel + '\'' +
                ", recvZip='" + recvZip + '\'' +
                ", recvTag='" + recvTag + '\'' +
                ", isDefault=" + isDefault +
                ", createdUser='" + createdUser + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                '}';
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table address
     *
     * @mbggenerated
     */
    public Address() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.id
     *
     * @return the value of address.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.id
     *
     * @param id the value for address.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.uid
     *
     * @return the value of address.uid
     *
     * @mbggenerated
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.uid
     *
     * @param uid the value for address.uid
     *
     * @mbggenerated
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.recv_name
     *
     * @return the value of address.recv_name
     *
     * @mbggenerated
     */
    public String getRecvName() {
        return recvName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.recv_name
     *
     * @param recvName the value for address.recv_name
     *
     * @mbggenerated
     */
    public void setRecvName(String recvName) {
        this.recvName = recvName == null ? null : recvName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.recv_province
     *
     * @return the value of address.recv_province
     *
     * @mbggenerated
     */
    public String getRecvProvince() {
        return recvProvince;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.recv_province
     *
     * @param recvProvince the value for address.recv_province
     *
     * @mbggenerated
     */
    public void setRecvProvince(String recvProvince) {
        this.recvProvince = recvProvince == null ? null : recvProvince.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.recv_city
     *
     * @return the value of address.recv_city
     *
     * @mbggenerated
     */
    public String getRecvCity() {
        return recvCity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.recv_city
     *
     * @param recvCity the value for address.recv_city
     *
     * @mbggenerated
     */
    public void setRecvCity(String recvCity) {
        this.recvCity = recvCity == null ? null : recvCity.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.recv_area
     *
     * @return the value of address.recv_area
     *
     * @mbggenerated
     */
    public String getRecvArea() {
        return recvArea;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.recv_area
     *
     * @param recvArea the value for address.recv_area
     *
     * @mbggenerated
     */
    public void setRecvArea(String recvArea) {
        this.recvArea = recvArea == null ? null : recvArea.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.recv_district
     *
     * @return the value of address.recv_district
     *
     * @mbggenerated
     */
    public String getRecvDistrict() {
        return recvDistrict;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.recv_district
     *
     * @param recvDistrict the value for address.recv_district
     *
     * @mbggenerated
     */
    public void setRecvDistrict(String recvDistrict) {
        this.recvDistrict = recvDistrict == null ? null : recvDistrict.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.recv_addr
     *
     * @return the value of address.recv_addr
     *
     * @mbggenerated
     */
    public String getRecvAddr() {
        return recvAddr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.recv_addr
     *
     * @param recvAddr the value for address.recv_addr
     *
     * @mbggenerated
     */
    public void setRecvAddr(String recvAddr) {
        this.recvAddr = recvAddr == null ? null : recvAddr.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.recv_phone
     *
     * @return the value of address.recv_phone
     *
     * @mbggenerated
     */
    public String getRecvPhone() {
        return recvPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.recv_phone
     *
     * @param recvPhone the value for address.recv_phone
     *
     * @mbggenerated
     */
    public void setRecvPhone(String recvPhone) {
        this.recvPhone = recvPhone == null ? null : recvPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.recv_tel
     *
     * @return the value of address.recv_tel
     *
     * @mbggenerated
     */
    public String getRecvTel() {
        return recvTel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.recv_tel
     *
     * @param recvTel the value for address.recv_tel
     *
     * @mbggenerated
     */
    public void setRecvTel(String recvTel) {
        this.recvTel = recvTel == null ? null : recvTel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.recv_zip
     *
     * @return the value of address.recv_zip
     *
     * @mbggenerated
     */
    public String getRecvZip() {
        return recvZip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.recv_zip
     *
     * @param recvZip the value for address.recv_zip
     *
     * @mbggenerated
     */
    public void setRecvZip(String recvZip) {
        this.recvZip = recvZip == null ? null : recvZip.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.recv_tag
     *
     * @return the value of address.recv_tag
     *
     * @mbggenerated
     */
    public String getRecvTag() {
        return recvTag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.recv_tag
     *
     * @param recvTag the value for address.recv_tag
     *
     * @mbggenerated
     */
    public void setRecvTag(String recvTag) {
        this.recvTag = recvTag == null ? null : recvTag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.is_default
     *
     * @return the value of address.is_default
     *
     * @mbggenerated
     */
    public Integer getIsDefault() {
        return isDefault;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.is_default
     *
     * @param isDefault the value for address.is_default
     *
     * @mbggenerated
     */
    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.created_user
     *
     * @return the value of address.created_user
     *
     * @mbggenerated
     */
    public String getCreatedUser() {
        return createdUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.created_user
     *
     * @param createdUser the value for address.created_user
     *
     * @mbggenerated
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser == null ? null : createdUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.created_time
     *
     * @return the value of address.created_time
     *
     * @mbggenerated
     */
    public String getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.created_time
     *
     * @param createdTime the value for address.created_time
     *
     * @mbggenerated
     */
    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime == null ? null : createdTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.modified_user
     *
     * @return the value of address.modified_user
     *
     * @mbggenerated
     */
    public String getModifiedUser() {
        return modifiedUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.modified_user
     *
     * @param modifiedUser the value for address.modified_user
     *
     * @mbggenerated
     */
    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser == null ? null : modifiedUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column address.modified_time
     *
     * @return the value of address.modified_time
     *
     * @mbggenerated
     */
    public String getModifiedTime() {
        return modifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column address.modified_time
     *
     * @param modifiedTime the value for address.modified_time
     *
     * @mbggenerated
     */
    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime == null ? null : modifiedTime.trim();
    }
}