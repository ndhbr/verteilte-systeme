package verteilte_systeme.uebung_06.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import verteilte_systeme.uebung_05.interfaces.IRoentgenbild;

public interface IFrueherkennung extends Remote {
    public String analysieren(IRoentgenbild roentgenbild) throws RemoteException;
}
