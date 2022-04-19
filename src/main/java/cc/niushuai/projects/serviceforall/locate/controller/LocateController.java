package cc.niushuai.projects.serviceforall.locate.controller;

import cc.niushuai.projects.serviceforall.common.base.vo.Result;
import cc.niushuai.projects.serviceforall.common.util.IpUtil;
import cc.niushuai.projects.serviceforall.locate.entity.LocateLogPoi;
import cc.niushuai.projects.serviceforall.locate.service.LocateLogPoiService;
import cc.niushuai.projects.serviceforall.locate.service.LocateLogService;
import cc.niushuai.projects.serviceforall.locate.vo.LocateLogVO;
import cn.hutool.core.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 定位服务接收
 *
 * @author niushuai
 * @date 2022/4/19 14:51
 */
@Slf4j
@RestController
@RequestMapping("/locate")
public class LocateController {

    @Resource
    private LocateLogService locateLogService;

    @Resource
    private LocateLogPoiService locateLogPoiService;

    @PostMapping("/report")
    public Result report(@RequestBody LocateLogVO locateLogVO, HttpServletRequest request) {

        log.info("req: {}", locateLogVO);
        locateLogVO.setIp(IpUtil.getIpAddr(request));

        locateLogService.save(locateLogVO);

        List<LocateLogPoi> poiList = locateLogVO.getPoiList();

        if (CollUtil.isNotEmpty(poiList)) {
            poiList.stream().forEach(item -> item.setLocateId(locateLogVO.getId()));
        }

        locateLogPoiService.saveBatch(poiList);

        return Result.ok();
    }
}
