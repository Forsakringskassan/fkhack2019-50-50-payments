package se.fk.fifty.payment.model;

public class PaymentNotFoundException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public PaymentNotFoundException()
    {
    }

    public PaymentNotFoundException(String message)
    {
        super(message);
    }

    public PaymentNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public PaymentNotFoundException(Throwable cause)
    {
        super(cause);
    }
}
