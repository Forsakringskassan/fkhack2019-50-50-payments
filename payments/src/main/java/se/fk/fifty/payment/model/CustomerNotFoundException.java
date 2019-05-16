package se.fk.fifty.payment.model;

public class CustomerNotFoundException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public CustomerNotFoundException()
    {
    }

    public CustomerNotFoundException(String message)
    {
        super(message);
    }

    public CustomerNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public CustomerNotFoundException(Throwable cause)
    {
        super(cause);
    }
}
