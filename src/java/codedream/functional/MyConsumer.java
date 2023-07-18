package codedream.functional;

/**
 *
 * @author alice
 * @time 2023-07-18 10:58
 **/
@FunctionalInterface
public interface MyConsumer<T> {
    void accept(T t);
}
