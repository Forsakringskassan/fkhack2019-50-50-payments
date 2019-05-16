package se.fk.fifty.payment.model;

import io.openapitools.jackson.dataformat.hal.HALLink;
import io.openapitools.jackson.dataformat.hal.annotation.Link;
import io.openapitools.jackson.dataformat.hal.annotation.Resource;

@Resource
public class EntryPointRepresentation extends BaseRepresentation
{
    private static final String PATH = "/";

    @Link(Relationship.PAYMENTS)
    private HALLink payments;

    public EntryPointRepresentation()
    {
        payments = new HALLink.Builder( Relationship.PAYMENTS_CONTEXT + "/{" + Relationship.CUSTOMER_ID+"}" ).build();
    }

    public HALLink getPayments()
    {
        return payments;
    }

    @Override
    public String getSelfLink()
    {
        return PATH;
    }
}
