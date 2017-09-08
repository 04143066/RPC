package Server;

/**
 * 服务端接口实现
 * Created by zouxiongxin on 2017/9/7.
 */
public class EchoServiceImpl implements EchoService{

    public String echo(String ping) {
        return ping != null ? ping + "--> I am OK.":"I am ok.";
    }
}
