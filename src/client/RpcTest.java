package client;

import Server.EchoService;
import Server.EchoServiceImpl;
import Server.RpcExporter;

import java.net.InetSocketAddress;

/**
 *
 * Created by xx on 2017/9/7.
 */
public class RpcTest {
    public static void main(String[] args) throws Exception {
        new Thread(new Runnable() {
            public void run() {
                try{
                    RpcExporter.exporter("localhost",8088);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
        RpcImporter<EchoService> importer = new RpcImporter<EchoService>();
        EchoService echo = importer.importer(EchoServiceImpl.class, new InetSocketAddress("localhost",8088));
        System.out.println(echo.echo("Are you ok？"));
    }
}
