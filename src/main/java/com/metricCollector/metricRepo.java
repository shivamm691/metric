package com.metricCollector;



import org.springframework.data.repository.CrudRepository;//CrudRepository is a Spring Data interface for generic CRUD operations on a repository of a specific type.

public interface metricRepo extends CrudRepository <metric ,Integer >{

}
