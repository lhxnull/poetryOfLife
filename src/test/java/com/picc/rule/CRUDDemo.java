package com.picc.rule;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.picc.common.controller.BaseController;
import com.picc.common.entity.FebsResponse;
import com.picc.common.entity.QueryRequest;
import com.picc.rule.entity.PrpClaimInfo;
import com.picc.rule.mapper.PrpclaimMapper;
import com.picc.rule.service.IPrpclaimService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/10/9.1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CRUDDemo extends BaseController {

    @Autowired
    private IPrpclaimService iPrpclaimService;


    /**
     * 请参照IService源码
     *
     * @throws Exception
     */
    @Test
    public void getById() throws Exception {

        PrpClaimInfo prpClaimInfo = iPrpclaimService.getById("17f1bc4e-28dc-4c0e-ae4a-2f790ace5b34");
        System.out.println(prpClaimInfo);
    }

    @Test
    public void removeById() throws Exception {
        iPrpclaimService.removeById("id");
    }

    @Test
    public void save() throws Exception {
        PrpClaimInfo prpClaimInfo = new PrpClaimInfo();
        iPrpclaimService.save(prpClaimInfo);
    }

    @Test
    public void update() throws Exception {
        PrpClaimInfo prpClaimInfo = new PrpClaimInfo();
        iPrpclaimService.update();
    }

    /**
     * 通过mapper.xml方式查询
     *
     * @throws Exception
     */
    @Test
    public void selectByIdMapper() throws Exception {
        PrpClaimInfo prpClaimInfo = iPrpclaimService.findbyMapperId("17f1bc4e-28dc-4c0e-ae4a-2f790ace5b34");
    }

    /**
     * 通过mybatisplus方式查询
     *
     * @throws Exception
     */
    @Test
    public void selectById() throws Exception {
        PrpClaimInfo prpClaimInfo = iPrpclaimService.findbyId("17f1bc4e-28dc-4c0e-ae4a-2f790ace5b34");
    }


    /**
     * 分页查询
     * @throws Exception
     */
    @Test
    public void getpage() throws Exception {
        PrpClaimInfo prpClaimInfo = new PrpClaimInfo();
        prpClaimInfo.setCityComCode("32010000");
        QueryRequest queryRequest = new QueryRequest();
        IPage<PrpClaimInfo> ipage = iPrpclaimService.findAll(prpClaimInfo, queryRequest);
        System.out.println(ipage);
        Map<String, Object> dataTable = getDataTable(ipage);
        System.out.println(dataTable);
    }

    /**
     * 注解查询
     * @throws Exception
     */
    @Test
    public void getpage2() throws Exception {
        PrpClaimInfo prpClaimInfo = new PrpClaimInfo();
        prpClaimInfo.setRegistNo("RDAA2019320100N002122");
        QueryRequest queryRequest = new QueryRequest();
        IPage<PrpClaimInfo> ipage = iPrpclaimService.findByRegistno(prpClaimInfo,queryRequest);
        System.out.println("-----------------------");
        System.out.println(ipage.getTotal());
        System.out.println(ipage.getRecords().size());
        System.out.println(ipage.getSize());
        System.out.println("-----------------------");
        Map<String, Object> dataTable = getDataTable(ipage);
//        System.out.println(dataTable);
    }

    /**
     * 排除查询的某个字段
     * @throws Exception
     */
    @Test
    public void getId() throws Exception {
        List<PrpClaimInfo> list = iPrpclaimService.getId("fd17accb-558c-496c-9e19-efb8551e26c2");
        list.forEach(System.out::println);
    }
}