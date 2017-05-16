package by.IvkoS.mongodb.dao;

public interface SequenceDao {

    Long getNextSequenceId(String key);

}
