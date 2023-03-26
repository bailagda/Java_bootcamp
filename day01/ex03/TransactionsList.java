package ex03;

import java.util.UUID;

public interface TransactionsList {
    void AddTransaction(Transaction transaction);
    void RemoveById(UUID id); // (in this case, UUID string identifier is used)
    void TransformToArr(); // (ex. Transaction[] toArray())
}
