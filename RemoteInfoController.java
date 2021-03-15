package com.gl.longrange.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gl.longrange.entity.PageResult;
import com.gl.longrange.entity.ReSftware;
import com.gl.longrange.entity.RemoteInfo;
import com.gl.longrange.entity.ResponseResult;
import com.gl.longrange.service.IExceService;
import com.gl.longrange.service.IRemoteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Remote")
public class RemoteInfoController  {
    @Autowired
    private IRemoteInfoService iRemoteInfoService;
    @Autowired
    private IExceService iExceService;
    //首页显示接口
    @RequestMapping("/find")
    public String find() {
        return "index";
    }
    //跳转long-range.html页面
    @RequestMapping("/longrange")
    public String longrange() {
        return "long-range";
    }

    //添加
    @ResponseBody
    @RequestMapping("/add")
    public int add(Map<String, Object> map, RemoteInfo remoteInfo) {
        System.out.println("remoteInfo" + remoteInfo);
        map.put("Re_name", remoteInfo.getRe_name());
        map.put("Re_code", remoteInfo.getRe_code());
        map.put("Re_pwd", remoteInfo.getRe_pwd());
        map.put("Com_name", remoteInfo.getCom_name());
        map.put("Sf_id", remoteInfo.getSf_id());
        int result = iRemoteInfoService.insertRemoteInfo(map);
        System.out.println("iiiiii" + result);
        return result;

    }
    //下拉框
    @ResponseBody
    @RequestMapping("/addsele")
    public List<ReSftware> addsele(ReSftware reSftware) {
        List<ReSftware> data = iRemoteInfoService.addsele(reSftware);
        return data;

    }
    //单个删除
    @ResponseBody
    @RequestMapping("/delRemoteInfo")
    public int delRemoteInfo(Integer reid) {
        System.out.println("reid"+reid);
       int res = iRemoteInfoService.deleteRemoteInfo(reid);
        return res;
    }
//批量删除
    @ResponseBody
    @RequestMapping("/delmany")
    public int delMany(String ids) {
        List<String> dellist = new ArrayList<>();
        System.out.println("delmany方法" + ids);
        if(ids !=null ){
            System.out.println("ids+++" + ids);
            String[] strs = ids.split(",");
            for (String str : strs) {
                dellist.add(str);
            }
        }
        int data = iRemoteInfoService.deleteMany(dellist);
        System.out.println("data"+data);
        return data;
    }
    //根据id查询
    @ResponseBody
    @RequestMapping("/selectOne.do")
    public RemoteInfo selectOne( Integer re_id){
        RemoteInfo data = iRemoteInfoService.selectByPrimaryKey(re_id);
        System.out.println("data"+data);
        return  data;

    }
    //修改
    @ResponseBody
    @RequestMapping("/update.do")
    public  int update(RemoteInfo remoteInfo){
        System.out.println("这是update"+remoteInfo);
        int data = iRemoteInfoService.updateByPrimaryKey(remoteInfo);

        return data;
    }
    @ResponseBody
    @RequestMapping("/list")
     public  PageResult<RemoteInfo> RemoteInfoList(PageResult<RemoteInfo> pageResult,String Re_name){
       //搜索查询店名称   selectfindall.size()!=0解决搜索为查询不到内容时只刷新表格
        List<RemoteInfo> selectfindall = iRemoteInfoService.selectfindall(Re_name);
        if(Re_name!=null && Re_name!="" && selectfindall.size()!=0){
            pageResult.setData(selectfindall);
            pageResult.setCode("0");
            pageResult.setMsg("网络故障");
            pageResult.setCount(selectfindall.size());
            return pageResult;
        }
        //获取起始页，页数大小
        PageHelper.startPage(pageResult.getPage(),pageResult.getLimit());
        //设定状态
        pageResult.setExample(pageResult.getExample());
        //选择条件
        PageResult<RemoteInfo> remoteInfoPageResult = iRemoteInfoService.selectRemoteInfo(pageResult);
        //将客户信息封装的PageInfo中
        PageInfo<RemoteInfo> page = new PageInfo<>(remoteInfoPageResult.getData());
        pageResult.setCode("0");
        pageResult.setMsg("网络故障");
        pageResult.setCount(page.getTotal());
        return pageResult;
    }
    //批量导入
    @ResponseBody
    @RequestMapping(value="importExcel",method={RequestMethod.GET, RequestMethod.POST})
    public ResponseResult ajaxUploadExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("file");
        if (file.isEmpty()) {
            return ResponseResult.build(1, "文件不存在！");
        }
        String msg = iExceService.ajaxUploadExcel(file);
        if (msg.equals("导入成功！")) {
            return ResponseResult.build(0, msg);
        } else {
            return ResponseResult.build(1, msg);
        }

    }
    }
