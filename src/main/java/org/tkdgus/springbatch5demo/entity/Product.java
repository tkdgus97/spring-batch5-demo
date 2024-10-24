package org.tkdgus.springbatch5demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "prd_id", nullable = false)
    private String prdId;

    @Column(name = "view_name")
    private String viewName;

    @Column(name = "prd_nm")
    private String prdNm;

    @Column(name = "cate1_nm")
    private String cate1Nm;

    @Column(name = "cate2_nm")
    private String cate2Nm;

    @Column(name = "cate3_nm")
    private String cate3Nm;

    @Column(name = "cate4_nm")
    private String cate4Nm;

    @Column(name = "brd_name")
    private String brdName;

    @Column(name = "supplier_code")
    private String supplierCode;

    @Column(name = "class_name")
    private String className;

    @Column(name = "cls_cd")
    private String clsCd;

    @Column(name = "org_item_cd")
    private Integer orgItemCd;

    @Column(name = "deal_flag")
    private Boolean dealFlag;

    @Column(name = "tv_flag")
    private Boolean tvFlag;

    @Column(name = "tempout_flag")
    private Boolean tempoutFlag;

    @Column(name = "price")
    private Integer price;

    @Column(name = "discprice")
    private Integer discPrice;

    @Column(name = "buy_count")
    private Integer buyCount;

    @Column(name = "review_score")
    private Integer reviewScore;

    @Column(name = "review_count")
    private Integer reviewCount;

    @Column(name = "createdate")
    private String createDate;

    @Column(name = "updatedate")
    private String updateDate;

    @Column(name = "upsertdate")
    private LocalDateTime upsertDate;

    @Column(name = "prd_discount_date")
    private String prdDiscountDate;

    @Column(name = "attr_char_val_1")
    private String attrCharVal1;

    @Column(name = "attr_char_val_2")
    private String attrCharVal2;

    @Column(name = "attr_char_val_3")
    private String attrCharVal3;

    @Column(name = "attr_char_val_4")
    private String attrCharVal4;

    @Column(name = "attr_char_val_5")
    private String attrCharVal5;

    @Column(name = "attr_char_val_6")
    private String attrCharVal6;

    @Column(name = "attr_char_val_7")
    private String attrCharVal7;

    @Column(name = "attr_char_val_8")
    private String attrCharVal8;

    @Column(name = "coupon_desc")
    private String couponDesc;

    @Column(name = "coupon_num")
    private String couponNum;

    @Column(name = "delivery_code")
    private String deliveryCode;

    @Column(name = "dtct_cd")
    private String dtctCd;

    @Column(name = "dlv_pick_mthod_cd")
    private String dlvPickMethodCd;

    @Column(name = "prd_adult_flag")
    private Boolean prdAdultFlag;
}
