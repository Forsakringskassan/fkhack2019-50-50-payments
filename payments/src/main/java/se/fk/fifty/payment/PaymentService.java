package se.fk.fifty.payment;

import se.fk.fifty.payment.model.EntryPointRepresentation;
import se.fk.fifty.payment.model.mapper.EntityMapper;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class PaymentService
{
    private static final String CONTENT_HAL_JSON = "application/hal+json";

    private PaymentStore store;

    public PaymentService()
    {
        //CDI no-arg
    }

    @Inject
    public PaymentService( PaymentStore store )
    {
        this.store = store;
    }

    @GET
    @Produces(CONTENT_HAL_JSON)
    @Path("/")
    public Response getEntryPoint()
    {
//        EntryPointRepresentation e = new EntryPointRepresentation();
//
//        String reply = EntityMapper.toHalJson( e );
//        System.out.println( "Reply: " + reply );

        String reply = "{\"_links\":{\"curies\":[{\"href\":\"/docs/{rel}\",\"templated\":true,\"name\":\"rel\"}],\"rel:payments\":{\"href\":\"/payments/{custId}\",\"templated\":true},\"self\":{\"href\":\"/\"}}}";

        return Response.ok(reply).build();
    }

    @GET
    @Produces(CONTENT_HAL_JSON)
    @Path("/payments/{custId}")
    public Response getCustomerPayments(@PathParam("custId") String custId)
    {
        //TODO: call store to get customers payments.

        String reply = "{\"_links\":{\"curies\":[{\"href\":\"/docs/{rel}\",\"templated\":true,\"name\":\"rel\"}],\"rel:payment\":{\"href\":\"/payments/"+custId+"/{id}\",\"templated\":true},\"self\":{\"href\":\"/payments/"+custId+"\"}}}";

        return Response.ok(reply).build();
    }
}
