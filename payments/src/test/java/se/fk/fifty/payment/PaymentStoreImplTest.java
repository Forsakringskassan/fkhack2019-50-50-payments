package se.fk.fifty.payment;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import se.fk.fifty.payment.model.Payment;

import javax.json.Json;
import javax.json.JsonObject;
import java.util.UUID;

import static org.junit.Assert.*;

@Ignore
public class PaymentStoreImplTest
{
    private PaymentStore instance;
    private String customerId = UUID.randomUUID().toString();
    private String paymentId = UUID.randomUUID().toString();
    private JsonObject data = Json.createObjectBuilder().add( "something","really interesting." ).build();
    private Payment payment = new Payment( data );

    @Before
    public void setup()
    {
        instance = new PaymentStoreImpl();
    }

    @Test
    public void createPayment()
    {

        Payment created = instance.createPayment( customerId, payment );

        assertEquals( created.getData(), data );

        assertEquals( instance.getPayments( customerId ).size(), 1 );
    }

    @Test
    public void getPayment()
    {
        Payment p = instance.createPayment( customerId, payment );
        Payment p2 = instance.createPayment( "123", new Payment(Json.createObjectBuilder().build()) );

        assertEquals( instance.getPayment( customerId, p.getId() ), payment );
    }

    @Test
    public void cancelPayment()
    {

        Payment p = instance.createPayment( customerId, payment );
        Payment p2 = instance.createPayment( customerId, new Payment( Json.createObjectBuilder().build()) );

        assertEquals( instance.getPayments( customerId ).size(), 2 );
        instance.cancelPayment( customerId, "321");
        assertEquals( instance.getPayments( customerId ).size(), 1 );
        assertEquals( instance.getPayment( customerId, paymentId ), payment );
    }


}