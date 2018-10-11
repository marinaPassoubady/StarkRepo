package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.BankBranch;
import model.Client;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-10T18:18:52")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, String> numeroCompte;
    public static volatile CollectionAttribute<Account, Client> clients;
    public static volatile SingularAttribute<Account, String> IBAN;
    public static volatile SingularAttribute<Account, String> libelle;
    public static volatile SingularAttribute<Account, BankBranch> banque;
    public static volatile SingularAttribute<Account, Double> solde;

}