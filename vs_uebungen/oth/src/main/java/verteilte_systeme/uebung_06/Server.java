package verteilte_systeme.uebung_06;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import verteilte_systeme.uebung_05.interfaces.IRoentgenbild;
import verteilte_systeme.uebung_06.interfaces.IFrueherkennung;

public class Server implements IFrueherkennung {
    public Server(String[] args, String host, int port) {
        try {
            IFrueherkennung stub = (IFrueherkennung)UnicastRemoteObject.exportObject(this, 0);
            Registry registry = LocateRegistry.createRegistry(port);
            registry.bind("Servus", stub);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String analysieren(IRoentgenbild roentgenbild) throws RemoteException {
        return "Analysiere Röntgenbild von " + roentgenbild.getPatientenName();
    }
}
