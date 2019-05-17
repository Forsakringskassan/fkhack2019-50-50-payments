package se.fk.fifty.payment.model;

import io.openapitools.jackson.dataformat.hal.HALLink;
import io.openapitools.jackson.dataformat.hal.annotation.Link;
import io.openapitools.jackson.dataformat.hal.annotation.Resource;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.net.URI;

@RegisterForReflection
@Resource
public class PaymentRepresentation extends BaseRepresentation
{
    private static final String PATH = Relationship.PAYMENTS_CONTEXT;
    private final String payment_to;
    private final String id;
    private final String status;
    private final String description;

    @Link(Relationship.CANCEL_PAYMENT)
    private HALLink cancelPayment;

    public PaymentRepresentation( String paymentId, String customerId, String status, String description )
    {
        this.payment_to = customerId;
        this.id = paymentId;
        this.status = status;
        this.description = description;
        this.cancelPayment = status.equals("COMPLETE") ? null : new HALLink.Builder(URI.create( getSelfLink() ) ).build();
    }

    public String getId()
    {
        return id;
    }

    public String getPayment_to()
    {
        return payment_to;
    }

    public String getStatus()
    {
        return status;
    }

    public String getDescription()
    {
        return description;
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
