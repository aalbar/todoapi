package corbos.todoapi.data;

/**
 * @author abhar
 * @date 13/03/2019
 */

import corbos.todoapi.models.ToDo;

import java.util.List;

public interface ToDoDao {

    ToDo add(ToDo todo);

    List<ToDo> getAll();

    ToDo findById(int id);

    // true if item exists and is updated
    boolean update(ToDo todo);

    // true if item exists and is deleted
    boolean deleteById(int id);
}
