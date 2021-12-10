package cn.muses.wecom.web.service.handler;

import java.util.Map;

import org.springframework.stereotype.Component;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.api.WxConsts.MenuButtonType;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.bean.message.WxCpXmlMessage;
import me.chanjar.weixin.cp.bean.message.WxCpXmlOutMessage;

/**
 * 自定义菜单事件
 *
 * @author jervis
 * @date 2021-11-30
 */
@Component
public class MenuHandler extends AbstractWxCpMessageHandler {

    public MenuHandler() {
        super(new RouterStrategy(WxConsts.MenuButtonType.CLICK));
    }

    @Override
    public WxCpXmlOutMessage handle(WxCpXmlMessage wxMessage, Map<String, Object> context, WxCpService cpService,
        WxSessionManager sessionManager) {

        String msg = String.format("type:%s, event:%s, key:%s",
            wxMessage.getMsgType(), wxMessage.getEvent(),
            wxMessage.getEventKey());
        if (MenuButtonType.VIEW.equals(wxMessage.getEvent())) {
            return null;
        }

        return WxCpXmlOutMessage.TEXT().content(msg)
            .fromUser(wxMessage.getToUserName()).toUser(wxMessage.getFromUserName())
            .build();
    }
}
