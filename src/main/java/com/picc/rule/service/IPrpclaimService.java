package com.picc.rule.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.picc.common.entity.QueryRequest;
import com.picc.rule.entity.PrpClaimInfo;

import java.util.List;

/**
 * Created by Administrator on 2019/9/29.
 */
public interface IPrpclaimService extends IService<PrpClaimInfo> {

    PrpClaimInfo findbyId(String ID);

    PrpClaimInfo findbyMapperId(String Id);

    IPage<PrpClaimInfo> findAll(PrpClaimInfo prpClaimInfo,QueryRequest request);

    IPage<PrpClaimInfo> findByRegistno(PrpClaimInfo prpClaimInfo,QueryRequest request);

    List<PrpClaimInfo> getId(String Id);

}
