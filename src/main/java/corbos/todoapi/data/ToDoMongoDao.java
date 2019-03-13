package corbos.todoapi.data;

import corbos.todoapi.models.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author abhar
 * @date 13/03/2019
 */
@Repository
public class ToDoMongoDao implements ToDoDao {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public ToDoMongoDao(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public ToDo add(ToDo todo) {
        return mongoTemplate.insert(todo);
    }

    @Override
    public List<ToDo> getAll() {
        return mongoTemplate.findAll(ToDo.class);
    }

    @Override
    public ToDo findById(int id) {
        return mongoTemplate.findById(id, ToDo.class);
    }

    @Override
    public boolean update(ToDo todo) {
        mongoTemplate.save(todo);
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        mongoTemplate.remove(new Query(Criteria.where("id").is(id)), ToDo.class);
        return true;
    }
}
