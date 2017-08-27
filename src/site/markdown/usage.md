# Usage

The project is meant to be an example showcasing JPA entities and queries.

There are some tests included to verify that these work as expected, and can be run with the verify command:

```
$ mvn verify -P h2,eclipselink
```

The tests require two profiles, one defining the database to be used, and another defining the JPA provider.

Only the in-memory databases, such as H2, do not require additional configuration. Any other, such as MySQL, will require a running database service.

## Profiles

### Database profiles

| Profile  | Database                  |
|----------|---------------------------|
| h2       | H2 in-memory database     |
| hsqldb   | HSQLDB in-memory database |
| mysql    | MySQL database            |
| postgres | PostgreSQL database       |

### JPA provider profiles

| Profile     | Provider    |
|-------------|-------------|
| hibernate   | Hibernate   |
| eclipselink | Eclipselink |
