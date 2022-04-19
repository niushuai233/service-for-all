package cc.niushuai.projects.serviceforall.locate.vo;

import cc.niushuai.projects.serviceforall.locate.entity.LocateLog;
import cc.niushuai.projects.serviceforall.locate.entity.LocateLogPoi;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * vo
 *
 * @author niushuai
 * @date 2022/4/19 14:52
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LocateLogVO extends LocateLog {

    private List<LocateLogPoi> poiList;
}
