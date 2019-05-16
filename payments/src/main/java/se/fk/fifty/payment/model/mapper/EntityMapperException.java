package se.fk.fifty.payment.model.mapper;

public class EntityMapperException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public EntityMapperException()
    {
        super();
    }

    public EntityMapperException(String message)
    {
        super(message);
    }

    public EntityMapperException(Throwable t)
    {
        super(t);
    }

    public EntityMapperException(String message, Throwable t)
    {
        super(message, t);
    }
}
