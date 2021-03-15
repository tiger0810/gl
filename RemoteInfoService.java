package com.gl.longrange.service;

import com.gl.longrange.entity.PageResult;
import com.gl.longrange.entity.ReSftware;
import com.gl.longrange.entity.RemoteInfo;
import com.gl.longrange.mapper.RemoteInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RemoteInfoService implements IRemoteInfoService {
     @Resource
     public RemoteInfoMapper remoteInfoMapper;

    @Override
    public List<RemoteInfo> selectfindall(String Re_name) {
        return remoteInfoMapper.selectfindall(Re_name);
    }

    @Override
    public PageResult<RemoteInfo> selectRemoteInfo(PageResult<RemoteInfo> pageResult) {
        List<RemoteInfo> remoteInfoPageResult = remoteInfoMapper.selectRemoteInfo(pageResult.getExample());
        pageResult.setData(remoteInfoPageResult);
        return pageResult;

    }

    @Override
    public int insertRemoteInfo(Map<String, Object> map) {
        return remoteInfoMapper.insertRemoteInfo(map);
    }

    @Override
    public int deleteMany(List<String> delList) {

        return  remoteInfoMapper.deleteMany(delList);
    }

    @Override
    public int deleteRemoteInfo(Integer reid) {
        return remoteInfoMapper.deleteRemoteInfo(reid);
    }

    @Override
    public RemoteInfo selectByPrimaryKey(Integer Re_id) {
        return remoteInfoMapper.selectByPrimaryKey(Re_id);
    }

    @Override
    public int updateByPrimaryKey(RemoteInfo remoteInfo) {
        return  remoteInfoMapper.updateByPrimaryKey(remoteInfo);
    }
    @Override
    public  List<ReSftware> addsele(ReSftware reSftware) {
        return remoteInfoMapper.addsele(reSftware) ;
    }

}
