package rpc;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author: nj
 * @date: 2020-10-21 13:27
 * @version: 0.0.1
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    public MyRemoteImpl() throws RemoteException {
    }

    @Override
    public String sayHello() throws RemoteException {
        System.out.println("调用成功！");
        return "sssssss";
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) throws MalformedURLException, RemoteException {
        MyRemote service = new MyRemoteImpl();
        // 启动本地rmi registry，默认端口1099
        LocateRegistry.createRegistry(1099);
        // 注册远程对象
        Naming.rebind("rmi://localhost:1099/RemoteHello", service);
    }
}