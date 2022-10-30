import proxy.BanqueService;
import proxy.BanqueWs;
import proxy.Compte;

public class ClientWs {
    public static void main(String[] args) {
        BanqueService stub=new BanqueWs().getBanqueServicePort();
        System.out.println(stub.convert(100));
        Compte cp=stub.getCompte(5);
        System.out.println(cp.getSolde());
    }
}
