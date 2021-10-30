package cui.shibing.rdsserver.biz.dabatase;

import cui.shibing.rdsserver.biz.dabatase.domain.RdsDatabaseInfo;
import cui.shibing.rdsserver.biz.dabatase.domain.factory.RdsDatabaseInfoFactory;
import cui.shibing.rdsserver.biz.dabatase.dto.DatabaseInfoParam;
import cui.shibing.rdsserver.biz.dabatase.repository.RdsDatabaseInfoRepository;
import cui.shibing.rdsserver.common.BizException;
import cui.shibing.rdsserver.entity.TRdsDatabaseInfo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RdsDatabaseInfoService {

    @Autowired
    private RdsDatabaseInfoRepository rdsDatabaseInfoRepository;

    public List<RdsDatabaseInfo> findAll() {
        List<TRdsDatabaseInfo> all = rdsDatabaseInfoRepository.findAll();
        return all.stream().map(RdsDatabaseInfoFactory::createDomain).collect(Collectors.toList());
    }

    public boolean createDatabaseInfo(DatabaseInfoParam param) {
        if (param == null) {
            return false;
        }
        String paramCheck = param.validateCreateScene();
        if (StringUtils.isNotBlank(paramCheck)) {
            throw new BizException("400", paramCheck);
        }
        TRdsDatabaseInfo exist = rdsDatabaseInfoRepository.findByName(param.getName());
        if (exist != null) {
            throw new BizException("400", "名称重复");
        }
        RdsDatabaseInfo info = new RdsDatabaseInfo();
        info.createNew(param.getName(), param.getHost(), param.getPort(), param.getUserName(), param.getPassword(), param.getDefaultDb());
        return rdsDatabaseInfoRepository.insert(RdsDatabaseInfoFactory.createStore(info));
    }

    public boolean updateDatabaseInfo(DatabaseInfoParam param) {
        if (param == null) {
            return false;
        }
        String paramCheck = param.validateUpdateScene();
        if (StringUtils.isNotBlank(paramCheck)) {
            throw new BizException("400", paramCheck);
        }
        TRdsDatabaseInfo exist = rdsDatabaseInfoRepository.findById(param.getId());
        if (exist == null) {
            throw new BizException("400", "要更新的数据不存在");
        }

        RdsDatabaseInfo domain = RdsDatabaseInfoFactory.createDomain(exist);
        domain.updateInfo(param.getName(), param.getHost(), param.getPort(), param.getUserName(), param.getPassword(), param.getDefaultDb());

        return rdsDatabaseInfoRepository.update(RdsDatabaseInfoFactory.createStore(domain));
    }

    public boolean deleteDatabaseInfo(DatabaseInfoParam param) {
        if (param == null) {
            return false;
        }

        if (param.getId() == null) {
            throw new BizException("400", "id不能为空");
        }
        TRdsDatabaseInfo exist = rdsDatabaseInfoRepository.findById(param.getId());
        if (exist == null) {
            throw new BizException("400", "要删除的数据不存在");
        }
        return rdsDatabaseInfoRepository.delete(param.getId());
    }

}
