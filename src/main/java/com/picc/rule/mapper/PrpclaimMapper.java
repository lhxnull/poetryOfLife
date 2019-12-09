package com.picc.rule.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.picc.rule.entity.PrpClaimInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2019/9/29.
 */

public interface PrpclaimMapper extends BaseMapper<PrpClaimInfo> {

    PrpClaimInfo findbyMapperId(String Id);

    @Select("select a.registno from prplisclaiminfo a left join prplismapschedule b on " +
            "a.registno=b.registno where a.registno like #{registno}")
    List<PrpClaimInfo> findByRegistno(String registno);
}
