package se.fk.fifty.payment;

import se.fk.fifty.payment.model.CustomerNotFoundException;
import se.fk.fifty.payment.model.Payment;
import se.fk.fifty.payment.model.PaymentNotFoundException;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
public class PaymentStoreImpl implements PaymentStore
{
    private Map<String, Map<String,Payment>> store = new HashMap<>();

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
        Optional.ofNullable( getPayments(customerId).remove( paymentId ) );
    }

    @Override
    public Payment createPayment(String customerId, String paymentId, Payment payment)
    {
        Map<String,Payment> payments = store.getOrDefault( customerId, new HashMap<>() );
        payments.put( paymentId, payment );
        store.put( customerId, payments );
        return payment;
    }
}
