package com.picc.rule.service.imp;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.picc.common.entity.FebsConstant;
import com.picc.common.entity.QueryRequest;
import com.picc.common.utils.SortUtil;
import com.picc.rule.entity.PrpClaimInfo;
import com.picc.rule.mapper.PrpclaimMapper;
import com.picc.rule.service.IPrpclaimService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Administrator on 2019/9/29.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PrpclaimServiceImp extends ServiceImpl<PrpclaimMapper, PrpClaimInfo> implements IPrpclaimService {


    @Override
    public PrpClaimInfo findbyId(String ID) {
        QueryWrapper<PrpClaimInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(PrpClaimInfo::getUuid, ID);
        return this.getOne(queryWrapper);
    }

    @Override
    public PrpClaimInfo findbyMapperId(String Id) {
        return this.baseMapper.findbyMapperId(Id);
    }

    @Override
    public IPage<PrpClaimInfo> findAll(PrpClaimInfo prpClaimInfo, QueryRequest request) {
//
        LambdaQueryWrapper<PrpClaimInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(PrpClaimInfo::getUuid,PrpClaimInfo::getRegistNo).
                eq(!prpClaimInfo.getCityComCode().isEmpty(),PrpClaimInfo::getCityComCode,prpClaimInfo.getCityComCode())
        .eq(StringUtils.isNotBlank(prpClaimInfo.getRegistNo()),PrpClaimInfo::getRegistNo,prpClaimInfo.getRegistNo());

        Page<PrpClaimInfo> page = new Page<>(request.getPageNum(), request.getPageSize());
        SortUtil.handlePageSort(request, page, "registno", FebsConstant.ORDER_DESC, true);

        return this.page(page, queryWrapper);
    }

    @Override
    public IPage<PrpClaimInfo> findByRegistno(PrpClaimInfo prpClaimInfo,QueryRequest request) {
        Page<PrpClaimInfo> page = new Page<>(request.getPageNum(), request.getPageSize());

        return page.setRecords(this.baseMapper.findByRegistno("%"+prpClaimInfo.getRegistNo()+"%"));
    }

    @Override
    public List<PrpClaimInfo> getId(String Id) {
//        LambdaQueryWrapper<PrpClaimInfo> queryWrapper = new LambdaQueryWrapper<>(new PrpClaimInfo());
//        queryWrapper.select(i->i.getColumn().equalsIgnoreCase("registno")).eq(StringUtils.isNotBlank(Id),PrpClaimInfo::getUuid,Id);
//        List<PrpClaimInfo> prpClaimInfos = this.baseMapper.selectList(queryWrapper);
//        return prpClaimInfos;
//        方式二
        LambdaQueryWrapper<PrpClaimInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(PrpClaimInfo.class,p->p.getColumn().equalsIgnoreCase("registno")).eq(
                StringUtils.isNotBlank(Id),PrpClaimInfo::getUuid,Id);
        List<PrpClaimInfo> prpClaimInfos = this.baseMapper.selectList(queryWrapper);
        return prpClaimInfos;
    }



}
