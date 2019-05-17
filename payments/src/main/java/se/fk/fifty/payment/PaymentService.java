package se.fk.fifty.payment;

import se.fk.fifty.payment.model.EntryPointRepresentation;
import se.fk.fifty.payment.model.Payment;
import se.fk.fifty.payment.model.PaymentRepresentation;
import se.fk.fifty.payment.model.PaymentsRepresentation;
import se.fk.fifty.payment.model.mapper.EntityMapper;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

        return Response.ok(reply).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Produces(CONTENT_HAL_JSON)
    @Path("/payments/{custId}")
    public Response getCustomerPayments(@PathParam("custId") String custId)
    {
        Map<String, Payment> payments = store.getPayments( custId );

        PaymentsRepresentation representation = new PaymentsRepresentation( custId );

        List<PaymentRepresentation> paymentReps = new ArrayList<>();
        for( Payment p: payments.values() )
        {
            paymentReps.add( createRepresentation( p ) );
        }
        representation.setPayments( paymentReps );

        String reply = EntityMapper.toHalJson( representation );

        return Response.ok(reply).header("Access-Control-Allow-Origin", "*").build();
    }

    @POST
    @Produces(CONTENT_HAL_JSON)
    @Path("/payments/{custId}")
    public Response getCustomerPayments(@PathParam("custId") String custId, String data )
    {
        JsonObject object = Json.createReader(new StringReader( data )).readObject();
        Payment p = store.createPayment( custId, new Payment( object ) );

        PaymentRepresentation representation = createRepresentation( p );

        String reply = toMergeDocuemnt( representation, p );

        return Response.status(Response.Status.CREATED).entity(reply).header("Access-Control-Allow-Origin", "*").build();
    }

    private PaymentRepresentation createRepresentation( Payment p )
    {
        return new PaymentRepresentation( p.getId(), p.getPaymentTo(), p.getStatus(), p.getDescription() );
    }

    private String toMergeDocuemnt( PaymentRepresentation rep, Payment p )
    {
        return JsonMerger.merge( Json.createReader( new StringReader( EntityMapper.toHalJson( rep ) ) ).readObject(), p.getData() ).toString();
    }

    @GET
    @Produces(CONTENT_HAL_JSON)
    @Path("/payments/{custId}/{paymentId}")
    public Response getCustomerPayment( @PathParam("custId") String custId, @PathParam("paymentId") String paymentId )
    {
        Payment payment = store.getPayment( custId, paymentId);

        PaymentRepresentation representation = createRepresentation( payment );

        String reply = toMergeDocuemnt( representation, payment );

        return Response.ok(reply).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Produces(CONTENT_HAL_JSON)
    @Path("/test")
    public Response test()
    {
        store.test();
        return Response.ok("test " + UUID.randomUUID().toString() ).build();
    }
}
