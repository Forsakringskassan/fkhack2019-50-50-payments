package se.fk.fifty.payment;

import se.fk.fifty.payment.model.Payment;
import se.fk.fifty.payment.model.PaymentNotFoundException;

import java.util.List;

public interface PaymentStore
{
    /**
     * Retrieve payments for a specific customer id
     *
     * @param custId to retrieve payments
     * @return customers payments.
     */
    List<Payment> getPayments(String custId);

    /**
     * Retrieve a payment by id.
     * @param paymentId to retrieve.
     * @return payment if exists.
     * @throws PaymentNotFoundException
     */
    Payment getPayment(String paymentId);

    /**
     * Remove a payment with the given id.
     *
     * @param paymentId of the payment to remove.
     */
    void cancelPayment(String paymentId);

    /**
     * Create a new payment with the provided data.
     *
     * @param payment to create.
     * @return
     */
    Payment createPayment(Payment payment);
}
