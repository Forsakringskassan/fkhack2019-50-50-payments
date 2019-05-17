package se.fk.fifty.payment;

import se.fk.fifty.payment.data.couchbase.CouchClient;
import se.fk.fifty.payment.model.Payment;
import se.fk.fifty.payment.model.PaymentNotFoundException;

import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class PaymentStoreImpl implements PaymentStore
{
    private Map<String, Map<String,Payment>> store = new HashMap<>();
    CouchClient client;

    @Override
    public Map<String,Payment> getPayments(String customerId)
    {
        return store.getOrDefault( customerId, new HashMap<>() );
    }

    @Override
    public Payment getPayment(String customerId, String paymentId)
    {
        return Optional.ofNullable( getPayments( customerId ).get( paymentId) ).orElseThrow(PaymentNotFoundException::new);
    }

    @Override
    public void cancelPayment(String customerId, String paymentId)
    {
        Optional.ofNullable( getPayments(customerId).remove( paymentId ) ).orElseThrow(PaymentNotFoundException::new);
    }

    @Override
    public Payment createPayment(String customerId, Payment payment)
    {
        Map<String,Payment> payments = store.getOrDefault( customerId, new HashMap<>() );
        String paymentId = UUID.randomUUID().toString();

        JsonObject data = Json.createObjectBuilder( payment.getData())
                .add( "id", paymentId )
                .add( "creation_date", LocalDateTime.now().format( DateTimeFormatter.ISO_DATE_TIME) )
                .add( "status", "PENDING" )
                .build();

        //persist( data );

        Payment created = new Payment( data );
        payments.put( paymentId, created );
        store.put( customerId, payments );
        return created;
    }

    private void persist( JsonObject data )
    {
        if( client == null )
        {
            client = new CouchClient();
        }
        client.createDocument( data );
    }

    @Override
    public JsonObject test()
    {
        if( client == null )
        {
            client = new CouchClient();
        }
        String id = UUID.randomUUID().toString();
        JsonObject object = Json.createObjectBuilder().add( "id", id ).build();
        client.createDocument( object );

        return client.getDocument( id );
    }
}
