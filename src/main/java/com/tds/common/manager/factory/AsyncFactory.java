package com.tds.common.manager.factory;

import com.tds.common.constant.Constants;
import com.tds.common.service.ISysLogininforService;
import com.tds.common.utils.LogUtils;
import com.tds.common.utils.ServletUtils;
import com.tds.common.utils.ip.AddressUtils;
import com.tds.common.utils.ip.IpUtils;
import com.tds.common.utils.Spring.SpringUtils;
import com.tds.modules.domain.SysLogininfor;
import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

public class AsyncFactory {
    private static  final Logger sys_user_logger= LoggerFactory.getLogger("sys-user");


    public static TimerTask recordLogininfor(final String username,final String status,final String message,final Object... args){
        final UserAgent userAgent=UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        final String ip= IpUtils.getIpAddr(ServletUtils.getRequest());
        return new TimerTask() {
            @Override
            public void run() {
                String address= AddressUtils.getRealAddressByIP(ip);
                StringBuilder s=new StringBuilder();
                s.append(LogUtils.getBlock(ip));
                s.append(address);
                s.append(LogUtils.getBlock(username));
                s.append(LogUtils.getBlock(status));
                s.append(LogUtils.getBlock(message));
                sys_user_logger.info(s.toString(),args);
                String os=userAgent.getOperatingSystem().getName();
                String browser=userAgent.getBrowser().getName();
                SysLogininfor sysLoininfor=new SysLogininfor();
                sysLoininfor.setUserName(username);
                sysLoininfor.setIpaddr(ip);
                sysLoininfor.setLoginLocation(address);
                sysLoininfor.setBrowser(browser);
                sysLoininfor.setOs(os);
                sysLoininfor.setMsg(message);
                if (Constants.LOGIN_SUCCESS.equals(status)||Constants.LOGOUT.equals(status)){
                    sysLoininfor.setStatus(Constants.SUCCESS);
                }else if (Constants.LOGIN_FAIL.equals(status)){
                    sysLoininfor.setStatus(Constants.FAIL);
                }
                SpringUtils.getBean(ISysLogininforService.class).insertLogininfor(sysLoininfor);
            }
        };
    }
}
