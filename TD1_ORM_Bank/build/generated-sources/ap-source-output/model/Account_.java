package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.BankBranch;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-07T19:53:34")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, String> numeroCompte;
    public static volatile SingularAttribute<Account, String> IBAN;
    public static volatile SingularAttribute<Account, String> libelle;
    public static volatile SingularAttribute<Account, BankBranch> banque;
    public static volatile SingularAttribute<Account, Double> solde;

}