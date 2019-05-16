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
        EntryPointRepresentation e = new EntryPointRepresentation();

        String reply = EntityMapper.toHalJson( e );

        return Response.ok(reply).build();
    }

    @GET
    @Produces(CONTENT_HAL_JSON)
    @Path("/payments")
    public Response getPayments()
    {
        //TODO: create response with the templated link for payment

        return Response.ok().build();
    }

    @GET
    @Produces(CONTENT_HAL_JSON)
    @Path("/payments/{custId}")
    public Response getCustomerPayments(@PathParam("custId") String custId)
    {
        //TODO: call store to get customers payments.
        return Response.ok().build();
    }
}
