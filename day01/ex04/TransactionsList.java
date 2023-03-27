package ex04;

import java.util.UUID;

public interface TransactionsList {
    void addTransaction(Transaction transaction);
    void removeById(UUID id); // (in this case, UUID string identifier is used)
    Transaction[] transformToArr(); // (ex. Transaction[] toArray())
}
