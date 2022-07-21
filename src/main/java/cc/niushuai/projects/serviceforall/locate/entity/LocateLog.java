package cc.niushuai.projects.serviceforall.locate.entity;

import cc.niushuai.projects.serviceforall.common.base.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * locate 实例
 *
 * @author niushuai
 * @date 2022/4/19 14:39
 */
@TableName("locate_log")
@Data
@EqualsAndHashCode(callSuper = false)
public class LocateLog extends BaseEntity {

    @TableField(value = "ip")
    private String ip;
    @TableField(value = "lat")
    private Double lat;
    @TableField(value = "lng")
    private Double lng;
    @TableField(value = "radius")
    private Double radius;
    @TableField(value = "locate_type")
    private Integer locateType;
    @TableField(value = "locate_time")
    private String locateTime;
    @TableField(value = "callback_time")
    private String callbackTime;
    @TableField(value = "loc_type")
    private String locType;
    @TableField(value = "loc_type_description")
    private String locTypeDescription;
    @TableField(value = "altitude")
    private Double altitude;
    @TableField(value = "direction")
    private String direction;
    @TableField(value = "country_code")
    private Integer countryCode;
    @TableField(value = "country")
    private String country;
    @TableField(value = "province")
    private String province;
    @TableField(value = "city_code")
    private Integer cityCode;
    @TableField(value = "city")
    private String city;
    @TableField(value = "district")
    private String district;
    @TableField(value = "address")
    private String address;
    @TableField(value = "street")
    private String street;
    @TableField(value = "indoor")
    private String indoor;
    @TableField(value = "locate_describe")
    private String locateDescribe;
    @TableField(value = "poi_region")
    private String poiRegion;
    @TableField(value = "poi_region_direction_desc")
    private String poiRegionDirectionDesc;
    @TableField(value = "poi_region_name")
    private String poiRegionName;
    @TableField(value = "remark")
    private String remark;
}
