package verteilte_systeme.uebung_05.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFrueherkennung extends Remote {
    public String hallo(String s) throws RemoteException;
}
