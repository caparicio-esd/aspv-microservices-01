package esd.carlos.learningspring.services;

public interface IService<T> {
    public Iterable<T> findAll();
}
