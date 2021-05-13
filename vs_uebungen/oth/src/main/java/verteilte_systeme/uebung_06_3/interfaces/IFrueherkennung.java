package verteilte_systeme.uebung_06_3.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFrueherkennung extends Remote {
    public IBericht analysieren(IRoentgenbild roentgenbild) throws RemoteException;
}
