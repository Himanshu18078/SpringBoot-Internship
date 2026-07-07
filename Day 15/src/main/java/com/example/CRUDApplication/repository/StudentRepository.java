package com.example.CRUDApplication.repository;

import com.example.CRUDApplication.entity.Student;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
//import org.springframework.stereotype.Repository;

//@Repository
/*
 We don't need @Component or @Repository here because:
 1. This is an interface, so we can't instantiate it directly anyway.
 2. Spring Data JPA automatically scans interfaces extending JpaRepository,
    generates a proxy implementation at runtime, and registers that proxy
    as a bean in the IOC container — no manual annotation needed.
*/
public interface StudentRepository extends JpaRepository<Student , Long> {
    /*
    JpaRepository<Student, Long>
    - Student = the entity type this repository manages (tells Spring which table/entity this repository works with)
    - Long = the type of the primary key of that entity (matches the type of the id field in Student)
    Because of this, Spring automatically provides ready-made CRUD methods for Student, such as:
    save(), findById(), findAll(), deleteById(), existsById(), etc.
     */
    Optional<Student>findByIdAndDeletedIsFalse(Long id);
    List<Student>findByDeletedIsFalse();
}
/*
These methods are not manually implemented.
Spring Data JPA generates their implementation automatically at runtime,
based on the method name itself. This is called a derived query method.

Spring parses the method name by breaking it into recognized keywords:
- findBy      -> indicates this is a query to fetch data
- Id          -> filter by the id field
- And         -> combines multiple conditions
- DeletedIsFalse -> filter where the deleted field is false

So findByIdAndDeletedIsFalse(id) is translated by Spring into:
SELECT * FROM student WHERE id = ? AND deleted = false

Similarly, findByDeletedIsFalse() becomes:
SELECT * FROM student WHERE deleted = false

No actual query or logic is written manually — Spring just follows
its naming convention and generates a proxy implementation of the
repository interface at application startup, handling the database
query internally.
 */