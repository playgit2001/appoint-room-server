package com.wfuhui.modules.wechat.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.binarywang.wx.miniapp.api.WxMaService;

import com.wfuhui.common.annotation.AuthIgnore;
import com.wfuhui.web.utils.JwtUtils;
import com.wfuhui.common.utils.R;
import com.wfuhui.modules.member.entity.MemberAuthEntity;
import com.wfuhui.modules.member.entity.MemberEntity;
import com.wfuhui.modules.member.service.MemberAuthService;
import com.wfuhui.modules.member.service.MemberService;

/**
 * 微信小程序用户接口
 */
@RestController
@RequestMapping("/api/wechat")
public class WxMaUserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WxMaService wxService;
    
    @Autowired
    private MemberService memberService;
    
    @Autowired
    private MemberAuthService memberAuthService;
    
    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 授权登录
     */
    @AuthIgnore
    @GetMapping("login")
    public R login(String avatarUrl, String nickname, String gender, String code) {
		try {
			String openid = this.wxService.getUserService().getSessionInfo(code).getOpenid();
			//查询用户信息
			MemberAuthEntity ma = memberAuthService.queryByOpenid(openid);
            MemberEntity member;
            String token;
            if(ma != null) { //判断是否注册
                member = memberService.queryObject(ma.getMemberId());
            }else{
                //注册
                member = new MemberEntity();
                member.setAvatarUrl(avatarUrl);
                member.setNickname(filterUtf8mb4(nickname));
                member.setGender(gender);
                member.setCreateTime(new Date());

                MemberAuthEntity memberAuth = new MemberAuthEntity();
                memberAuth.setAuthType("wechat");
                memberAuth.setOpenid(openid);
                memberAuth.setCreateTime(new Date());
                memberAuthService.register(member, memberAuth);

            }
            //生成token
            token = jwtUtils.generateToken(member.getId());
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("token", token);
            map.put("userInfo", member);
            return R.ok(map);
		} catch (Exception e) {
			e.printStackTrace();
			return R.error();
		}
    }
    
    public static String filterUtf8mb4(String str) {
        final int LAST_BMP = 0xFFFF;
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            int codePoint = str.codePointAt(i);
            if (codePoint < LAST_BMP) {
                sb.appendCodePoint(codePoint);
            } else {
                i++;
            }
        }
        return sb.toString();
    }

}
