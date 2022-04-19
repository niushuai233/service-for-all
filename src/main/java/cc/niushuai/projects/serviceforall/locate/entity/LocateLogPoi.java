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
@TableName(value = "locate_log_poi")
@Data
@EqualsAndHashCode(callSuper = false)
public class LocateLogPoi extends BaseEntity {

    @TableField(value = "locate_id")
    private String locateId;
    @TableField(value = "region_name")
    private String regionName;
    @TableField(value = "region_tag")
    private String regionTag;
    @TableField(value = "poi_region_direction_desc")
    private String poiRegionDirectionDesc;
    @TableField(value = "remark")
    private String remark;


}
