package com.ssm.pojo;

public class Image {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.goods_id
     *
     * @mbggenerated
     */
    private Integer goodsId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column image.img_url
     *
     * @mbggenerated
     */
    private String imgUrl;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image
     *
     * @mbggenerated
     */
    public Image(Integer id, Integer goodsId, String imgUrl) {
        this.id = id;
        this.goodsId = goodsId;
        this.imgUrl = imgUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image
     *
     * @mbggenerated
     */
    public Image() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.id
     *
     * @return the value of image.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.id
     *
     * @param id the value for image.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.goods_id
     *
     * @return the value of image.goods_id
     *
     * @mbggenerated
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.goods_id
     *
     * @param goodsId the value for image.goods_id
     *
     * @mbggenerated
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column image.img_url
     *
     * @return the value of image.img_url
     *
     * @mbggenerated
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column image.img_url
     *
     * @param imgUrl the value for image.img_url
     *
     * @mbggenerated
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }
}