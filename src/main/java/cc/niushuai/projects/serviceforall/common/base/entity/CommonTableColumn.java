package cc.niushuai.projects.serviceforall.common.base.entity;

/**
 * 公共table列 下划线 小写
 *
 * @author niushuai
 * @date 2022/4/11 16:08
 */
public interface CommonTableColumn {

    /**
     * id 列字段
     */
    String ID = "id";

    /**
     * 创建人 列字段
     */
    String CREATE_BY = "create_by";

    /**
     * 创建时间 列字段
     */
    String CREATE_TIME = "create_time";

    /**
     * 更新人 列字段
     */
    String UPDATE_BY = "update_by";

    /**
     * 更新时间 列字段
     */
    String UPDATE_TIME = "update_time";

    /**
     * 删除标识 列字段
     */
    String IS_DELETED = "is_deleted";

    /**
     * 备注
     */
    String NOTE = "note";

    /**
     * 状态值
     */
    String STATUS = "status";
}
