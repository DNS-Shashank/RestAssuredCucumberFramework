# Cucumber BDD API Testing Framework

🚀 **Modern API testing framework using Cucumber BDD + Rest Assured for Place APIs**

## Quick Overview
- **BDD-driven** API testing with Gherkin syntax
- **Complete CRUD** operations (Add/Get/Delete Places)
- **Data-driven** scenarios with parameterized tests
- **Rich reporting** with HTML/JSON outputs
- **Maven-powered** with Java 17

## Tech Stack
`Java 17` • `Cucumber 7.18.1` • `Rest Assured 5.4.0` • `JUnit` • `Maven`

## Project Structure
src/
├── main/java/POJO/ # API payload objects
└── test/java/
├── Features/ # Cucumber scenarios
├── stepDefinitions/ # Test implementations
├── cucumber/Options/ # Test runner
└── Resources/ # Utilities & config


## Running Tests
```bash
mvn test                                    # All tests
mvn test -Dcucumber.filter.tags="@AddPlace"  # Specific tag
mvn verify                                  # With reports

Key Features
✅ Add Place API - Create & validate places
✅ Delete Place API - Remove places
✅ Response Validation - Status codes & JSON content
✅ Auto Reporting - HTML reports in target/cucumber-html-reports/
✅ Request Logging - Debug logs in logging.text

Test Scenarios
@AddPlace @Regression: Validates place creation with multiple datasets

@DeletePlace @Regression: Tests place deletion functionality

Built for reliability, maintainability, and clear test documentation! 🎯
