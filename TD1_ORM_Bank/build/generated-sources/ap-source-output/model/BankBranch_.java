package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Account;
import model.Adresse;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-09T11:51:02")
@StaticMetamodel(BankBranch.class)
public class BankBranch_ { 

    public static volatile CollectionAttribute<BankBranch, Account> comptes;
    public static volatile SingularAttribute<BankBranch, Adresse> adresseAgence;
    public static volatile SingularAttribute<BankBranch, Integer> codeAgence;

}