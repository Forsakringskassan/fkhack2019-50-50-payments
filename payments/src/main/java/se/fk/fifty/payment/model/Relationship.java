package se.fk.fifty.payment.model;

public final class Relationship
{

    private Relationship()
    {

    }

    public static final String NAMESPACE = "rel";

    //Rels
    public static final String PAYMENTS = NAMESPACE + ":payments";
    public static final String PAYMENT = NAMESPACE + ":payment";
    public static final String CANCEL_PAYMENT = NAMESPACE + ":cancelPayment";

    //Templated Params
    public static final String CUSTOMER_ID = "custId";
    public static final String PAYMENT_ID = "id";

    //Path Contexts
    public static final String PAYMENTS_CONTEXT = "/payments";
}