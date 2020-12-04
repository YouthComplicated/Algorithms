package rpc;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author: nj
 * @date: 2020-10-21 13:26
 * @version: 0.0.1
 */
public interface MyRemote extends Remote {

    String sayHello() throws RemoteException;
}