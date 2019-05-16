package se.fk.fifty.payment.model;

import io.openapitools.jackson.dataformat.hal.HALLink;
import io.openapitools.jackson.dataformat.hal.annotation.Link;
import io.openapitools.jackson.dataformat.hal.annotation.Resource;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
@Resource
public class PaymentRepresentation extends BaseRepresentation
{
    private static final String PATH = Relationship.PAYMENTS_CONTEXT;
    private final String payment_to;
    private final String id;
    private final String payment_from;
    private final String amount;
    private final String currency;
    private final String payment_date;
    private final String created_date;

    @Link(Relationship.CANCEL_PAYMENT)
    private HALLink cancelPayment;

    public PaymentRepresentation( String paymentId, String customerId, String payment_from, String amount, String currency, String payment_date, String created_date )
    {
        this.payment_to = customerId;
        this.id = paymentId;
        this.payment_from = payment_from;
        this.amount = amount;
        this.currency = currency;
        this.payment_date = payment_date;
        this.created_date = created_date;
    }

    public String getId()
    {
        return id;
    }

    public String getPayment_to()
    {
        return payment_to;
    }

    public String getPayment_from()
    {
        return payment_from;
    }

    public String getAmount()
    {
        return amount;
    }

    public String getCurrency()
    {
        return currency;
    }

    public String getPayment_date()
    {
        return payment_date;
    }

    public String getCreated_date()
    {
        return created_date;
    }

    public HALLink getCancelPayment()
    {
        return cancelPayment;
    }

    @Override
    public String getSelfLink()
    {
        return PATH + "/"+payment_to+"/"+id;
    }
}
