# Important Java Springboot Commands

- Compile a Java program:

  ```
  javac FileName.java
  ```

- Package a Maven project(with mvnw wrapper):

  ```
  mvnw package
  ```

- to force Maven to delete the old files and start fresh. Run this command:

  ```
  mvnw clean package
  ```

- Run a Spring Boot application:

  ```
  java -jar target\sampleProj-0.0.1-SNAPSHOT.jar
  ```

- Run a Spring Boot application using Maven:
  ```
    mvnw spring-boot:run
  ```

# Spring Boot Annotations

- `@SpringBootApplication`: This is a convenience annotation that combines `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`. It is used to mark the main class of a Spring Boot application.
- `@RestController`: This annotation is used to create RESTful web services. It combines `@Controller` and `@ResponseBody`, indicating that the class is a controller where every method returns a domain object instead of a view.
- `@RequestMapping`: This annotation is used to map web requests to specific handler classes or methods. It can be applied at the class level or method level to specify the URL patterns that the controller or method should handle.
- `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`: These annotations are shortcuts for `@RequestMapping` with specific HTTP methods. They are used to handle GET, POST, PUT, and DELETE requests respectively.
- `@Autowired`: This annotation is used for automatic dependency injection. It allows Spring to resolve and inject collaborating beans into your bean.
- `@Service`: This annotation is used to mark a class as a service provider. It is a specialization of the `@Component` annotation and is used to indicate that the class provides some business functionalities.
- `@Override`: This annotation indicates that a method is intended to override a method in a superclass. It helps to catch errors at compile time if the method does not actually override a method in the superclass.
- `@Component`: This annotation is used to indicate that a class is a Spring component. It is a generic stereotype for any Spring-managed component and can be used to annotate classes that do not fit into other specific stereotypes like `@Service` or `@Repository`.
- `@Lazy`: This annotation is used to indicate that a bean should be lazily initialized. It tells Spring to create the bean only when it is needed, rather than at application startup.
- `@Scope`: This annotation is used to specify the scope of a bean. It can be used to define whether a bean is a singleton, prototype, request, session, or application scoped.
- `@PathVariable`: This annotation is used to bind a method parameter to a URI template variable. It allows you to extract values from the URL and use them as method parameters in your controller methods.
- `@RequestParam`: This annotation is used to bind a method parameter to a web request parameter. It allows you to extract query parameters from the URL and use them as method parameters in your controller methods.
- `@RequestBody`: This annotation is used to bind the body of a web request to a method parameter. It allows you to deserialize the request body into a Java object.
- `@ResponseBody`: This annotation is used to indicate that the return value of a method should be serialized and sent as the response body. It is typically used in RESTful web services to return JSON or XML data.

- `@PostConstruct`: This annotation is used to indicate that a method should be executed after the bean has been initialized. It is typically used for any initialization code that needs to run after the bean's properties have been set. First, the bean is created and its dependencies are injected, and then the method annotated with `@PostConstruct` is called to perform any additional setup or initialization tasks.
- `@PreDestroy`: This annotation is used to indicate that a method should be executed before the bean is destroyed. It is typically used for any cleanup code that needs to run before the bean is removed from the application context.
  - For "prototype" scoped beans, Spring does not call the destroy method. Gasp!

In contrast to the other scopes, Spring does not manage the complete lifecycle of a prototype bean: the container instantiates, configures, and otherwise assembles a prototype object, and hands it to the client, with no further record of that prototype instance.

Thus, although initialization lifecycle callback methods are called on all objects regardless of scope, in the case of prototypes, configured destruction lifecycle callbacks are not called. The client code must clean up prototype-scoped objects and release expensive resources that the prototype bean(s) are holding.

Bean - A bean is an object that is instantiated, assembled, and otherwise managed by a Spring IoC container. These beans are created with the configuration metadata that you supply to the container, for example, in the form of XML `<bean/>` definitions or Java annotations.

- Why its used: Its used for making a third party library class a Spring bean, so that we can use it in our application with the help of dependency injection.
- Example: If we have a third party library class `ExternalService` that we want to use in our Spring application, we can create a configuration class and define a bean for it.

- `@Configuration`: This annotation indicates that the class can be used by the Spring IoC container as a source of bean definitions. It is typically used in conjunction with `@Bean` methods to define beans.
- `@Bean`: This annotation indicates that a method produces a bean to be managed by the Spring container. It is used within a `@Configuration` class to define beans that can be injected into other components.

  ```java
  import org.springframework.context.annotation.Bean;
  import org.springframework.context.annotation.Configuration;

  @Configuration
  public class AppConfig {

      @Bean
      public ExternalService externalService() {
          return new ExternalService();
      }
  }
  ```

  In this example, we have a configuration class `AppConfig` that defines a bean for the `ExternalService` class. The `externalService()` method is annotated with `@Bean`, which tells Spring to manage this bean and make it available for dependency injection throughout the application.

- We can also use Bean ID to specify a custom name for the bean. By default, the bean name is the same as the method name, but we can override it by providing a value to the `@Bean` annotation.

- `@ExceptionHandler`: This annotation is used to define a method that will handle exceptions thrown by controller methods. It allows you to specify how to handle specific exceptions and return appropriate responses to the client.

- `@ControllerAdvice`: This annotation is used to define a global exception handler that applies to all controllers in the application. It allows you to centralize exception handling logic and provide consistent error responses across the application.

# Hibernate

- Hibernate is an Object-Relational Mapping (ORM) framework for Java. It provides a way to map Java objects to database tables and vice versa, allowing developers to work with databases using Java objects instead of SQL queries.

- EntityManager: The EntityManager is the primary interface used to interact with the persistence context in Hibernate. It provides methods for performing CRUD (Create, Read, Update, Delete) operations on entities, as well as managing transactions and queries.

### ID Generation Strategies

- `@Entity`: This annotation is used to mark a class as a JPA entity. It indicates that the class is a persistent Java object that will be mapped to a database table.
- `@Table`: This annotation is used to specify the name of the database table that the entity will be mapped to. If not specified, the default table name will be the same as the entity class name.
- `@Id`: This annotation is used to mark a field as the primary key of the entity. It indicates that the field will be used to uniquely identify each record in the database table.
- `@GeneratedValue(strategy = GenerationType.<Method>)`: This annotation is used to specify the generation strategy for the primary key. It is typically used in conjunction with the `@Id` annotation to indicate how the primary key value should be generated.
  - `@Column`: This annotation is used to specify the mapping between a field in the entity class and a column in the database table. It allows you to customize the column name, data type, length, and other properties.
  - `@OneToOne`: This annotation is used to define a one-to-one relationship between two entities. It indicates that each instance of the first entity is associated with exactly one instance of the second entity, and vice versa.
  - `@OneToMany`: This annotation is used to define a one-to-many relationship between two entities. It indicates that each instance of the first entity can be associated with multiple instances of the second entity, but each instance of the second entity is associated with only one instance of the first entity.
  - `@ManyToOne`: This annotation is used to define a many-to-one relationship between two entities. It indicates that each instance of the first entity can be associated with only one instance of the second entity, but each instance of the second entity can be associated with multiple instances of the first entity.
  - `@ManyToMany`: This annotation is used to define a many-to-many relationship between two entities. It indicates that each instance of the first entity can be associated with multiple instances of the second entity, and each instance of the second entity can be associated with multiple instances of the first entity.

- `GenerationType.IDENTITY`: This strategy relies on the database to generate the primary key value. The database will automatically generate a unique identifier for each new record inserted into the table. This is commonly used with auto-incrementing columns in databases like MySQL.
- `GenerationType.SEQUENCE`: This strategy uses a database sequence to generate unique identifiers. A sequence is a database object that generates a sequence of unique numbers. This strategy is commonly used in databases like Oracle and PostgreSQL.
- `GenerationType.TABLE`: This strategy uses a separate database table to generate unique identifiers. The
  table will contain a single row that keeps track of the next available identifier. This strategy is less efficient than the other two and is generally not recommended.
- `GenerationType.AUTO`: This strategy allows the persistence provider (e.g., Hibernate) to choose the appropriate generation strategy based on the database dialect and other configuration settings. It is a convenient option when you want to let Hibernate decide the best strategy for your database.
- `GenerationType.UUID`: This strategy generates a universally unique identifier (UUID) as the primary key. It is useful when you want to ensure uniqueness across different systems or databases.
- `GenerationType.CUSTOM`: This strategy allows you to define a custom generator for generating primary key values. You can implement your own logic for generating unique identifiers based on your specific requirements.

- `@Transactional`: This annotation is used to indicate that a method or class should be executed within a transactional context. It allows you to define the boundaries of a transaction and manage the commit and rollback behavior.
- `@Repository`: This annotation is used to indicate that a class is a repository. It is a specialization of the `@Component` annotation and is used to indicate that the class provides data access functionalities.

- `@Service`: This annotation is used to indicate that a class is a service provider. It is a specialization of the `@Component` annotation and is used to indicate that the class provides some business functionalities.

## Flow of Data in Spring Boot Application in Database Operations:

1. Main App creates the Student Object (Data).

2. Main App passes it to the DAO Interface (The Contract).

3. DAO Implementation receives it and uses the EntityManager (The Tool).

4. @Transactional opens the database gate.

5. persist() puts the object in the "To-Do List".

6. Closing Brace } triggers the actual INSERT SQL and updates the ID.

7. The database generates the ID and sends it back to the application.

8. The Student Object now has the generated ID and is fully persisted in the database.

## Crud Operarions Important Methods:

- `persist()`: This method is used to save a new entity to the database. It makes the entity instance managed and persistent, meaning it will be tracked by the EntityManager and will be inserted into the database when the transaction is committed.
- `merge()`: This method is used to update an existing entity in the database. It takes a detached entity instance and merges its state with the current persistence context. If the entity does not exist in the database, it will be inserted as a new record.
- `remove()`: This method is used to delete an entity from the database. It takes a managed entity instance and removes it from the persistence context, which will result in a DELETE SQL statement being executed when the transaction is committed.
- `find()`: This method is used to retrieve an entity from the database based on its primary key. It takes the entity class and the primary key value as parameters and returns the corresponding entity instance if found, or null if not found.
- `findAll()`: This method is used to retrieve all instances of a particular entity from the database. It typically involves executing a JPQL query to fetch all records of the specified entity type.
- `getReference()`: This method is similar to `find()`, but it returns a proxy instance of the entity instead of the actual entity. The proxy will be initialized with the entity's data when it is accessed for the first time. This can be useful for performance optimization, as it allows you to defer loading the entity's data until it is actually needed.
- `createQuery()`: This method is used to create a JPQL (Java Persistence Query Language) query. It takes a JPQL query string as a parameter and returns a Query object that can be used to execute the query and retrieve results.
- `executeUpdate()`: This method is used to execute a JPQL update or delete query. It returns the number of entities that were updated or deleted as a result of the query execution.

- To Auto create tables in the database, we can use the following property in the application.properties file:

  ```
  spring.jpa.hibernate.ddl-auto=update

  ```

  This property tells Hibernate to automatically update the database schema based on the entity classes. It will create tables if they do not exist and update them if there are any changes to the entity classes. Other options for this property include `create`, `create-drop`, and `validate`, which have different behaviors for managing the database schema.

## Before JPA repository:

1. Create a Student class and annotate it with `@Entity` to mark it as a JPA entity.
2. Create a StudentDAO interface that defines the contract for data access operations related to the Student entity.
3. Create a StudentDAOImpl class that implements the StudentDAO interface and provides the actual implementation of the data access methods using the EntityManager. All all implemented methods with `@Transactional` to manage transactions.(Once service layer is implemented, we can move the `@Transactional` annotation to the service layer and remove it from the DAO implementation.)
4. In the main application class, create an instance of the StudentDAO implementation and use it to perform CRUD operations on the Student entity.

## After JPA repository:

1. Create a Student class and annotate it with `@Entity` to mark it as a JPA entity.
2. Create a StudentRepository interface that extends the JpaRepository interface provided by Spring Data JPA. This will automatically provide basic CRUD operations for the Student entity without the need for a separate DAO implementation.
   `public interface StudentRepository extends JpaRepository<Student, Long> { }` where Student is the entity class and Long is the type of the primary key.
3. In the main application class, create an instance of the StudentRepository and use it to perform CRUD operations on the Student entity. You can also use the built-in methods provided by JpaRepository, such as `save()`, `findById()`, `findAll()`, `deleteById()`, etc., to interact with the database without writing any custom implementation.

## Some Spring Data Projects:

Spring Framework - This is a comprehensive framework for building Java applications. It provides a wide range of features and modules for various aspects of application development, including dependency injection, aspect-oriented programming, web development, data access, and more. Spring Framework is designed to be flexible and modular, allowing developers to choose the components they need for their specific use cases. It is widely used in the industry for building enterprise-level applications.

Spring Boot - This is a project built on top of the Spring Framework that provides a simplified and opinionated approach to building Spring applications. It eliminates the need for boilerplate code and configuration by providing auto-configuration and convention-over-configuration features. Spring Boot allows developers to quickly create standalone, production-grade applications with minimal setup and configuration. It is designed to be easy to use and provides a wide range of features for building modern applications, including embedded servers, metrics, health checks, and more.

Spring Core - This is the core module of the Spring Framework that provides fundamental features such as dependency injection, bean management, and application context. It is the foundation upon which other Spring modules are built and provides the basic building blocks for creating Spring applications.

Spring Hibernate - This is a popular ORM (Object-Relational Mapping) framework for Java that provides a way to map Java objects to database tables and vice versa. It allows you to work with databases using Java objects instead of SQL queries, making it easier to manage data persistence in your applications. Spring Hibernate integrates Hibernate with the Spring Framework, providing features such as transaction management and dependency injection for Hibernate-based applications.

Spring Data JPA - This is a part of the Spring Data project that provides an abstraction layer over JPA (Java Persistence API). It simplifies the implementation of data access layers by providing a set of interfaces and annotations that allow you to define repository interfaces for your entities. Spring Data JPA will automatically generate the implementation of these interfaces at runtime, allowing you to perform CRUD operations and custom queries without writing any boilerplate code.

Spring Data REST - This is a part of the Spring Data project that makes it easy to create RESTful APIs for your Spring Data repositories. It automatically exposes CRUD operations and query methods as REST endpoints, allowing you to interact with your data using standard HTTP methods without writing any additional code.

- `@RepositoryRestResource`: This annotation is used to customize the REST endpoint for a Spring Data repository. It allows you to specify the path and other properties of the REST endpoint that will be generated for the repository. By default, Spring Data REST will generate endpoints based on the repository interface name, but you can use this annotation to override the default behavior and provide a custom endpoint path.
- `@RestResource`: This annotation is used to customize the REST endpoint for a specific repository method. It allows you to specify the path and other properties of the REST endpoint that will be generated for that method. By default, Spring Data REST will generate endpoints based on the method name, but you can use this annotation to override the default behavior and provide a custom endpoint path for that specific method.

## SpringDoc -

This is a library that provides automatic generation of API documentation for Spring Boot applications. It uses the OpenAPI specification to generate interactive API documentation that can be accessed through a web interface. SpringDoc integrates with Spring Boot and allows you to easily document your RESTful APIs without writing any additional code. It provides features such as support for multiple API versions, customizable documentation, and integration with Swagger UI for interactive API exploration.

Swagger UI - This is a popular tool for visualizing and interacting with RESTful APIs. It provides a user-friendly interface that allows developers to explore and test API endpoints, view request and response details, and generate API documentation. Swagger UI can be integrated with Spring Boot applications using libraries like SpringDoc to automatically generate API documentation based on the OpenAPI specification. It is widely used in the industry for API development and documentation.

For API documentation with SpringDoc and Swagger UI, you can refer to the following resources:

- /v3/api-docs - This endpoint provides the OpenAPI specification in JSON format for your Spring Boot application. It contains all the details about your API endpoints, request and response models, and other relevant information.
- /swagger-ui.html - This endpoint provides the Swagger UI interface for your API documentation. It allows you to interact with your API endpoints, view request and response details, and explore the API documentation in a user-friendly way. You can access this endpoint in your web browser to see the generated API documentation for your Spring Boot application.

## Spring Security

- `Configuration`: This annotation indicates that the class can be used by the Spring IoC container as a source of bean definitions. It is typically used in conjunction with `@EnableWebSecurity` to configure security settings for a Spring Boot application.
- `EnableWebSecurity`: This annotation enables Spring Security's web security support and provides the configuration for securing web applications. It is typically used in conjunction with `@Configuration` to define security settings for a Spring Boot application.

- UserDetailsManager - This is an interface provided by Spring Security that extends the UserDetailsService interface. It provides additional methods for managing user accounts, such as creating, updating, and deleting user accounts. It is typically used in applications that require user management functionality, allowing you to easily manage user accounts and their associated details.

## Spring MVC

- `@Controller`: This annotation is used to indicate that a class is a Spring MVC controller. It is a specialization of the `@Component` annotation and is used to indicate that the class is responsible for handling web requests and returning views or data as responses.

- `@ModelAttribute`: This annotation is used to bind a method parameter or method return value to a named model attribute. It allows you to add attributes to the model that can be accessed in the view layer, such as in JSP or Thymeleaf templates. It can be used at the method level or parameter level to specify the name of the model attribute and its value.

- `@Value("${<Var-name-of-value>}")`: This annotation is used to inject values from properties files or environment variables into Spring beans. It allows you to externalize configuration and make your application more flexible by allowing you to change values without modifying the code. You can use this annotation to inject values such as database connection strings, API keys, or any other configuration properties that your application needs.

- `th:field`: This is a Thymeleaf attribute used in HTML templates to bind form fields to model attributes. It allows you to create forms that can submit data to the server and automatically bind the form fields to the corresponding model attributes in your Spring MVC controller. This makes it easier to handle form submissions and process user input in your application.

- `th:text`: This is a Thymeleaf attribute used in HTML templates to set the text content of an element(used to display). It allows you to dynamically display values from your model attributes in the view layer. You can use this attribute to display data such as user names, product details, or any other information that you want to show in your HTML templates. It is commonly used in conjunction with `th:field` to display form field values or other dynamic content in the view.

- `th:value`: This is a Thymeleaf attribute used in HTML templates to set the value of an input field. It allows you to dynamically populate form fields with values from your model attributes. You can use this attribute to pre-fill form fields with existing data when editing an entity or to set default values for new entries. It is commonly used in conjunction with `th:field` to bind form fields to model attributes and display their values in the view layer.

- `th:object`: This is a Thymeleaf attribute used in HTML templates to bind an entire object to a form. It allows you to bind all the properties of an object to the corresponding form fields in one go, rather than binding each field individually. This can simplify your templates and make it easier to handle complex forms with multiple fields that correspond to a single object in your model. It is commonly used in conjunction with `th:field` to bind form fields to the properties of the object being bound.

- `@Valid`: This annotation is used to indicate that a method parameter should be validated using the Bean Validation API. It allows you to apply validation constraints to the fields of a model object and automatically trigger validation when the form is submitted. If the validation fails, you can handle the errors in your controller and return appropriate responses to the user. It is commonly used in conjunction with `@ModelAttribute` to validate form data before processing it in the controller.

- `BindingResult`: This is an interface provided by Spring MVC that holds the results of validating a form object. It contains information about any validation errors that occurred during the binding process. You can use this interface in your controller methods to check for validation errors and handle them accordingly, such as returning error messages to the user or redirecting back to the form with error details. It is typically used as a parameter in controller methods that handle form submissions, following the model object parameter annotated with `@Valid`.

- `@ModelAttribute("attributeName")`: This annotation is used to bind a method parameter or method return value to a named model attribute. It allows you to add attributes to the model that can be accessed in the view layer, such as in JSP or Thymeleaf templates. The "attributeName" specified in the annotation will be the name of the model attribute that can be accessed in the view. This is commonly used in Spring MVC controllers to prepare data for rendering views and to handle form submissions.

- `${<Var-name-of-value>}`: ${...} (The Global Search) is a syntax used in Spring MVC and Thymeleaf templates to access variables and expressions. It allows you to access values from the model, request parameters, session attributes, and other sources in your view layer. You can use this syntax to display dynamic content, such as user names, product details, or any other information that you want to show in your HTML templates. It is commonly used in conjunction with `th:text` and `th:value` to display values from the model attributes in the view layer.

- `*{...}`: (The Local Search / The Shortcut): This syntax is used in Thymeleaf templates to access properties of the current object being processed. It allows you to access properties of the object that is currently being iterated over in a loop or bound to a form. This is particularly useful when working with collections of objects, such as lists or arrays, where you want to access properties of each individual object in the collection. It is commonly used in conjunction with `th:each` to iterate over collections and access properties of each item in the collection.

- `@{...}` (Link): This syntax is used in Thymeleaf templates to create links to other pages or resources. It allows you to generate URLs based on the context of the application, such as the current request or the application's base URL. You can use this syntax to create links to other pages within your application, as well as to external resources. It is commonly used in conjunction with `th:href` to set the href attribute of anchor tags in HTML templates.

- `@InitBinder`: This annotation is used in Spring MVC controllers to indicate that a method should be used to initialize a WebDataBinder. The WebDataBinder is responsible for binding request parameters to Java objects and performing data conversion and validation. By using @InitBinder, you can customize the binding process for specific types of objects or specific fields, allowing you to handle complex data binding scenarios in your application.

- `@Min` and `@Max`: These annotations are used to specify minimum and maximum values for numeric fields in a model object. They are part of the Bean Validation API and can be used to validate that a numeric field falls within a specified range. For example, you can use `@Min(0)` to ensure that a field cannot have a negative value, and `@Max(100)` to ensure that a field cannot exceed 100. These annotations can be used in conjunction with `@Valid` to automatically trigger validation when a form is submitted in a Spring MVC application.

- `@Size`: This annotation is used to specify the minimum and maximum size of a string or collection field in a model object. It is part of the Bean Validation API and can be used to validate that a string field has a certain length or that a collection field has a certain number of elements. For example, you can use `@Size(min = 2, max = 50)` to ensure that a string field has at least 2 characters and no more than 50 characters. This annotation can be used in conjunction with `@Valid` to automatically trigger validation when a form is submitted in a Spring MVC application.

- `@Pattern`: This annotation is used to specify a regular expression pattern that a string field must match in a model object. It is part of the Bean Validation API and can be used to validate that a string field conforms to a specific format. For example, you can use `@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$"){<total characters>}` to ensure that an email field matches a valid email format. This annotation can be used in conjunction with `@Valid` to automatically trigger validation when a form is submitted in a Spring MVC application.

- `@NotNull`: This annotation is used to indicate that a field in a model object cannot be null. It is part of the Bean Validation API and can be used to validate that a required field has a value before processing it in the controller. For example, you can use `@NotNull` on a field to ensure that it must have a value when a form is submitted. This annotation can be used in conjunction with `@Valid` to automatically trigger validation when a form is submitted in a Spring MVC application.

- `@NotEmpty`: This annotation is used to indicate that a string or collection field in a model object cannot be empty. It is part of the Bean Validation API and can be used to validate that a required field has a value before processing it in the controller. For example, you can use `@NotEmpty` on a string field to ensure that it must have at least one character when a form is submitted, or on a collection field to ensure that it must have at least one element. This annotation can be used in conjunction with `@Valid` to automatically trigger validation when a form is submitted in a Spring MVC application.

- messages.properties - File should be in the resources folder - This is a properties file used in Spring MVC applications to store custom validation messages for Bean Validation constraints. It allows you to define custom error messages for validation failures, which can be displayed to the user when a form submission fails validation. You can specify messages for specific constraints, such as `@NotNull`, `@Size`, `@Pattern`, etc., by using the constraint's annotation name followed by a dot and the message key. For example, you can define a message for the `@NotNull` constraint on a field named "username" with the key `NotNull.username` and provide a custom error message in the properties file. This allows you to provide user-friendly error messages that are specific to your application's requirements.

## Creating Custom Validation Annotation:

- `@Constraint(validatedBy = {CustomValidator.class})`: This annotation is used to define a custom validation constraint in Spring MVC. It specifies the validator class that will be responsible for validating the annotated field or method. The `validatedBy` attribute takes an array of validator classes, allowing you to specify multiple validators if needed. The custom validator class must implement the `ConstraintValidator` interface and provide the logic for validating the annotated field or method based on your specific requirements. This allows you to create custom validation rules that are not covered by the standard Bean Validation constraints.

- `@Target({ElementType.FIELD, ElementType.METHOD})`: This annotation is used to specify the target elements for a custom validation annotation. It indicates where the custom validation annotation can be applied, such as on fields, methods, or other elements. In this example, the custom validation annotation can be applied to both fields and methods. You can customize the target elements based on your specific use case and requirements.

- `@Retention(RetentionPolicy.RUNTIME)`: This annotation is used to specify the retention policy for a custom validation annotation. It indicates how long the annotation should be retained in the Java bytecode and whether it should be available at runtime. In this example, the retention policy is set to `RUNTIME`, which means that the annotation will be retained in the bytecode and can be accessed through reflection at runtime. This is necessary for the custom validation logic to be executed when validating the annotated field or method.

## The following are the steps to create a custom validation annotation in Spring MVC:

1. Name the Sticker: (public @interface MyCustomRule)

2. Who is the Boss? (@Constraint -> point it to the class with the actual if/else logic).

3. Where does it go? (@Target -> Fields and Methods).

4. How long does it last? (@Retention -> RUNTIME!).

5. The Big 4 Settings: Inside the brackets, you must provide four things:

6. The value (what you are checking against).

7. The message (the error text).

8. The groups (copy-paste boilerplate).

9. The payload (copy-paste boilerplate).

10. The Logic: Create a class that implements ConstraintValidator and write the logic in the isValid() method.
