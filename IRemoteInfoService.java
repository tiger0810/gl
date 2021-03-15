package com.gl.longrange.service;

import com.gl.longrange.entity.PageResult;
import com.gl.longrange.entity.ReSftware;
import com.gl.longrange.entity.RemoteInfo;
import java.util.List;
import java.util.Map;

public interface IRemoteInfoService {
     //根据店名查询 RemoteInfo
     List<RemoteInfo> selectfindall(String Re_name);
     //查询所有数据 RemoteInfo
     PageResult<RemoteInfo> selectRemoteInfo(PageResult<RemoteInfo>pageResult);
     //添加 RemoteInfo
     int insertRemoteInfo(Map<String, Object> map);
     //批量删除 RemoteInfo
     int deleteMany(List<String> delList);
     //单个删除 RemoteInfo
     int deleteRemoteInfo(Integer reid);
    //根据id查询
     RemoteInfo selectByPrimaryKey(Integer Re_id);
     //修改
     int updateByPrimaryKey(RemoteInfo remoteInfo);
    //下拉框查询
    List<ReSftware> addsele (ReSftware reSftware);

}
