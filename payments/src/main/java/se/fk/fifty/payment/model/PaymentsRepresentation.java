package se.fk.fifty.payment.model;

import io.openapitools.jackson.dataformat.hal.HALLink;
import io.openapitools.jackson.dataformat.hal.annotation.EmbeddedResource;
import io.openapitools.jackson.dataformat.hal.annotation.Link;
import io.openapitools.jackson.dataformat.hal.annotation.Resource;
import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.List;

@RegisterForReflection
@Resource
public class PaymentsRepresentation extends BaseRepresentation
{
    private static final String PATH = Relationship.PAYMENTS_CONTEXT;

    private final String customerId;

    @Link(Relationship.PAYMENT)
    private HALLink payment;

    @EmbeddedResource(Relationship.PAYMENT)
    private List<PaymentRepresentation> payments;

    public PaymentsRepresentation( String customerId )
    {
        this.customerId = customerId;
        payment = new HALLink.Builder( PATH + "/" + customerId+ "/{" + Relationship.PAYMENT_ID+"}" ).build();
    }

    public List<PaymentRepresentation> getPayments()
    {
        return payments;
    }

    public void setPayments(List<PaymentRepresentation> payments)
    {
        this.payments = payments;
    }

    public HALLink getPayment()
    {
        return payment;
    }

    @Override
    public String getSelfLink()
    {
        return PATH + "/" + this.customerId;
    }
}
