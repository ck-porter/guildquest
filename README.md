# GuildQuest

**A Java-based adventurers guild management system built to demonstrate object-oriented programming, business logic, automated testing, and enterprise application development.**

GuildQuest is a portfolio project inspired by fantasy RPGs. It models the administrative side of running an adventurers guild, including registering adventurers, managing guild membership, enforcing business rules, and tracking guild capacity.

I'm building this project incrementally while strengthening my Java skills and developing practical experience with the technologies and design patterns used in enterprise software development.

## Project Goals

GuildQuest is designed to demonstrate:

- Object-oriented programming and encapsulation
- Separation of business logic from data storage
- Collections and data management in Java
- Input validation and exception handling
- Unit testing with JUnit 5
- Mocking and interaction testing with Mockito
- REST API development and database integration
- Enterprise application architecture and integration testing

## Current Features

### Adventurer Management
- Create adventurers with validated IDs and names.
- Track character attributes, including level, experience, gold, and health.
- Enforce rules for gold management, damage, and healing.
- Register adventurers through a service layer.
- Prevent duplicate adventurer IDs.
- Retrieve adventurers by ID.

### Guild Membership
- Create guilds with a unique identifier, name, and maximum membership capacity.
- Add adventurers to a guild.
- Prevent duplicate membership within the same guild.
- Enforce guild membership limits.
- Remove adventurers from a guild.
- Allow membership slots to be reused when adventurers leave.
- Validate guild IDs, names, and maximum capacity.

### Application Design
- Separate domain models, services, and repositories.
- Use a repository interface to decouple business logic from data storage.
- Implement an in-memory repository for development and testing.
- Use constructor injection to provide dependencies to services.
- Validate inputs and use exceptions to enforce business rules.

## Technology Stack

| Technology | Purpose |
|---|---|
| Java 17 | Core application development |
| Maven | Dependency management and builds |
| JUnit 5 | Unit testing |
| Mockito | Mocking dependencies and verifying service behaviour |
| Git and GitHub | Version control and project history |

Additional technologies will be introduced as the project evolves.

## Project Structure

The application is organized into separate packages for its domain models, services, and repositories.

```text
guildquest/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── guildquest/
│   │               ├── model/
│   │               │   ├── Adventurer.java
│   │               │   └── Guild.java
│   │               ├── repository/
│   │               │   ├── AdventurerRepository.java
│   │               │   └── InMemoryAdventurerRepository.java
│   │               └── service/
│   │                   └── AdventurerService.java
│   └── test/
│       └── java/
│           └── com/
│               └── guildquest/
│                   ├── model/
│                   │   └── GuildTest.java
│                   ├── repository/
│                   │   └── InMemoryAdventurerRepositoryTest.java
│                   └── service/
│                       ├── AdventurerServiceTest.java
│                       └── AdventurerServiceMockitoTest.java
└── pom.xml
```

*Note: This structure represents the intended layout based on the current implementation. Update the tree if your actual package structure differs.*

## Running the Tests

You will need Java 17 or later and Maven installed, or you can use the Maven wrapper if one is included in the repository.

Clone the repository:

```bash
git clone https://github.com/ck-porter/guildquest.git
cd guildquest
```

Run the test suite:

```bash
mvn test
```

The tests cover business rules, input validation, repository operations, and service behaviour.

## Development Roadmap

GuildQuest is an active work in progress. Planned improvements include:

- [x] Core adventurer domain model
- [x] Adventurer registration and lookup
- [x] Repository abstraction and in-memory storage
- [x] Unit tests for adventurer management
- [x] Mockito-based service tests
- [x] Guild domain model and membership management
- [ ] Complete guild membership and constructor validation tests
- [ ] Guild service and repository layers
- [ ] Persistent storage using PostgreSQL
- [ ] SQL and database integration tests
- [ ] Spring Boot REST API
- [ ] Spring Data JPA integration
- [ ] Authentication, authorization, and role-based access
- [ ] Audit history and more complex business workflows
- [ ] SOAP service integration
- [ ] React frontend
- [ ] Automated testing and CI/CD pipeline
- [ ] Deployment of a working online demo

The roadmap may evolve as the project grows.

## Design Philosophy

GuildQuest is being developed in small, testable increments. Each feature starts with explicit business rules, followed by an implementation and automated tests.

The project emphasizes clear separation of responsibilities. Domain models enforce their own invariants, services coordinate business operations, and repositories abstract data access. This structure provides a foundation for replacing in-memory storage with a database and introducing a web API without coupling the core business logic to those technologies.

## About

GuildQuest is an independent portfolio project intended to demonstrate practical Java development, software design, testing, and continued professional development toward enterprise software engineering.