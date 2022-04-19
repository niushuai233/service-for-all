package cc.niushuai.projects.serviceforall.locate.service.impl;

import cc.niushuai.projects.serviceforall.locate.entity.LocateLog;
import cc.niushuai.projects.serviceforall.locate.mapper.LocateLogMapper;
import cc.niushuai.projects.serviceforall.locate.service.LocateLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * locate service
 *
 * @author niushuai
 * @date 2022/4/19 14:56
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LocateLogServiceImpl extends ServiceImpl<LocateLogMapper, LocateLog> implements LocateLogService {

}
