package rpc;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author: nj
 * @date: 2020-10-21 13:30
 * @version: 0.0.1
 */
public class MyRemoteClient {

    private void go() throws RemoteException, NotBoundException, MalformedURLException {
        MyRemote service = (MyRemote) Naming.lookup("rmi://localhost/RemoteHello");
        System.out.println(service.sayHello());
    }

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        new MyRemoteClient().go();
    }
}