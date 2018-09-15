package g.proxy.protocol;

import g.util.CommonConsts;
import lombok.Data;

/**
 * @author chengjin.lyf on 2018/9/5 上午9:56
 * @since 1.0.25
 */
@Data
public class LoginMessage extends Message {

    private String account;

    private String password;

    public LoginMessage() {
        this.cmd = CommonConsts.COMMAND_LOGIN;
    }

    @Override
    public void decode() throws Exception{
        String str = new String(codec, "utf-8");
        String arr[] = str.split(";");
        account = arr[0];
        password = arr[1];
    }

    @Override
    public void encode() throws Exception{
        String data = account + ";" + password;
        codec = data.getBytes("utf-8");
    }
}
