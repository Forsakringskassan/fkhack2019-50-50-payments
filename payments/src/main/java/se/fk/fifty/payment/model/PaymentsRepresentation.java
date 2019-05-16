package se.fk.fifty.payment.model;

import io.openapitools.jackson.dataformat.hal.HALLink;
import io.openapitools.jackson.dataformat.hal.annotation.Link;
import io.openapitools.jackson.dataformat.hal.annotation.Resource;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
@Resource
public class PaymentsRepresentation extends BaseRepresentation
{
    private static final String PATH = "/";

    @Link(Relationship.PAYMENT)
    private HALLink payment;

    public PaymentsRepresentation( String customerId )
    {
        payment = new HALLink.Builder( Relationship.PAYMENTS_CONTEXT + "/" + customerId+ "/{" + Relationship.PAYMENT_ID+"}" ).build();
    }

    public HALLink getPayment()
    {
        return payment;
    }

    @Override
    public String getSelfLink()
    {
        return PATH;
    }
}
