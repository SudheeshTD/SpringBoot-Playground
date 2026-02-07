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
- `@PostConstruct`: This annotation is used to indicate that a method should be executed after the bean has been initialized. It is typically used for any initialization code that needs to run after the bean's properties have been set.
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
