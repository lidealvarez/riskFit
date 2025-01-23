# RiskFit Documentation

## Project Description
RiskFit is a web-based application aimed at predicting the risk of sports injuries using machine learning. Users can input relevant data through two forms, and the application returns a prediction of injury risk. The project integrates Artificial Intelligence (AI) and Software Engineering principles and is deployed as a Maven Project.

---

## Main Technological Choices and Justification

### Programming Language and Frameworks
- **Programming Language**: Java (for the web application backend)
- **Frameworks**:
  - **Spring Boot**: For rapid development of RESTful web services and seamless integration of dependencies.
  - **Thymeleaf**: For rendering HTML templates dynamically.
- **Python**: Used in conjunction with Jupyter Notebook to develop and deploy machine learning models.

### External Dependencies
- **SonarQube**: For static code analysis to ensure code quality and maintainability.
- **JUnit**: For unit testing to validate the functionality of individual methods.
- **GitHub Actions**: For automating CI/CD pipelines.

---

## Git Branching Strategies, Release Tags, and Justification

### Git Branching Strategies
The project follows a structured Git branching model:
- **main**: The stable branch containing production-ready code, integrated with SonarQube for code quality validation.
- **develop**: The development branch used for creating or modifying new functionalities.
- **bugfix**: A dedicated branch for resolving issues, such as SonarQube-detected code smells or other bugs.
- **release**: This branch serve as a staging area for final testing and quality assurance before merging into `main`.

### Release Tags
Release tags are used to mark key milestones in the project. For example:
- `v1.0`: Tag created upon achieving 100% test coverage in SonarQube.

---

## Static Analysis Tooling

### Tools
- **SonarQube**: Integrated with GitHub Actions to perform static code analysis, ensuring adherence to quality standards.

### Rules and Justification
- Code smells and bugs flagged by SonarQube are resolved in the `bugfix` branch.
- Rules such as avoiding duplicate code, ensuring proper naming conventions, and maintaining test coverage above 90% were applied to enhance code quality and readability.

---

## Testing Tooling and Strategy

### Tools
- **JUnit**: For unit testing Java methods.
- **Mockito**: For mocking the model in test cases.

### Strategy and Justification
- Each method in the application is tested individually to ensure correctness.
- Test cases cover edge cases, normal cases, and invalid input scenarios to ensure robustness.
- Code coverage is monitored using SonarQube to maintain a coverage rate of 100%.

---

## Continuous Integration and Deployment (CI/CD)

### System
- **GitHub Actions**: Chosen for its seamless integration with GitHub repositories and support for YAML-based workflows.

### Justification
- GitHub Actions automates the process of building, testing, and deploying the application.
- The CI/CD pipeline ensures that only high-quality code reaches the `main` branch.

---

## Additional Documentation Considerations
- **Future Work**: A potential feature is the integration of real-time data streams from wearables like Apple Watch.

---

## Conclusion
RiskFit demonstrates a comprehensive approach to integrating machine learning and web technologies, supported by robust software engineering practices. By adhering to industry standards in static analysis, testing, and CI/CD, the project achieves high reliability and maintainability.

