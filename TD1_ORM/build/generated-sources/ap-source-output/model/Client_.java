package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Account;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-10T18:18:52")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile CollectionAttribute<Client, Account> mesComptes;
    public static volatile SingularAttribute<Client, String> numeroClient;
    public static volatile SingularAttribute<Client, Date> dateNaiss;
    public static volatile SingularAttribute<Client, String> nom;
    public static volatile SingularAttribute<Client, String> prenom;

}