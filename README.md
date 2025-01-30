# JavaSeleniumCucumber

JavaSeleniumCucumber is a Java project that uses Selenium, Cucumber, and Allure to perform automated browser tests and generate detailed test reports. The project is designed for continuous integration (CI) with GitHub Actions.

## Prerequisites

Before you start, ensure that you have the following installed:

- Java 11 (or higher)
- Maven
- Google Chrome (for headless testing)
- Allure (for generating test reports)

Alternatively, these dependencies will be handled by GitHub Actions during CI.

## Project Setup

### Clone the repository

```bash
git clone https://github.com/marcoshioka/JavaSeleniumCucumber.git
cd JavaSeleniumCucumber
```

### Build the project

This project uses Maven for dependency management and build automation. To build the project, run:

```bash
mvn clean install
```

This command will compile the code, run tests, and package the project into a JAR file.

## Running Tests

### Local Testing

To run the tests locally, use Maven:

```bash
mvn test
```

This will run the Cucumber test cases defined in the `TestRunner.java` class, using Selenium to interact with the browser.

### CI/CD with GitHub Actions

The project is set up to trigger GitHub Actions workflows on every push or pull request to the main branch. The following steps are performed automatically in the CI pipeline:

1. Checkout the code from the repository.
2. Set up Java 11 for the project.
3. Install Google Chrome for running headless browser tests.
4. Build the project using Maven.
5. Run the tests, with results stored in the `build/allure-results` directory.
6. Generate an Allure report.
7. Upload the Allure report as an artifact.
8. Publish the report to GitHub Pages for easy viewing.

The workflow is defined in `.github/workflows/ci.yml`.

## Viewing Allure Reports

After the CI pipeline completes, an Allure report will be generated. You can view the generated report via GitHub Pages at the following URL:

```bash
https://marcoshioka.github.io/JavaSeleniumCucumber
```

The report will be available on the `gh-pages` branch.

## GitHub Actions Workflow

The workflow is configured to run on:

- Push to the main branch
- Pull requests to the main branch
- Scheduled runs (daily at 12:00 PM UTC)

The workflow performs the following steps:

1. **Set up Java 11**: The project uses JDK 11, and it is set up using the `setup-java` action.
2. **Install Google Chrome**: Google Chrome is installed to run tests in headless mode.
3. **Build with Maven**: The project is built using the `mvn package` command with the `-Dmaven.test.skip` flag to skip tests during the build phase.
4. **Run Tests**: Tests are executed with `mvn test`, and results are stored in `build/allure-results`.
5. **Install Allure**: The Allure CLI is installed for generating test reports.
6. **Generate Allure Report**: The `allure generate` command is run to generate the HTML report.
7. **Upload Report**: The Allure report is uploaded as an artifact and published to GitHub Pages.

## Example Test

Here's a basic Cucumber feature file for testing:

```gherkin
Feature: Google Search

    Scenario: Search for "Cucumber" on Google
        Given I open the Google homepage
        When I search for "Cucumber"
        Then the search results should contain the word "Cucumber"
```

The corresponding step definitions will be in the `StepDefinitions` class, and the `TestRunner.java` class will execute the feature file.

## Configuration

### `pom.xml`

The `pom.xml` file includes dependencies for:

- Selenium: Web browser automation.
- Cucumber: Behavior-Driven Development (BDD) framework.
- JUnit: Testing framework for running tests.
- Allure: For generating and visualizing test reports.

### GitHub Actions Workflow

The `.github/workflows/ci.yml` file defines the CI pipeline. It sets up Java 11, installs dependencies like Google Chrome, and runs tests while generating an Allure report.

## Troubleshooting

- **Google Chrome Installation Issues**: If you encounter issues with installing Google Chrome, try running the following command to fix missing dependencies:

    ```bash
    sudo apt-get install -f
    ```

- **Allure Report Not Generated**: If the `build/allure-results` directory is empty, verify that tests are running correctly. Check the logs in GitHub Actions to identify any failures.

## License

This project is licensed under the MIT License - see the `LICENSE` file for details.

## **Contact**
For questions or feedback, please contact:
- **Email**: marcosribeirohioka@gmail.com
- **GitHub**: marcoshioka