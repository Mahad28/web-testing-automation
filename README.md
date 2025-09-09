# Web Testing Automation Framework

A comprehensive web testing framework using Selenium WebDriver, TestNG, and Page Object Model for demonstrating professional web automation capabilities.

## 🚀 Features

- **Selenium WebDriver**: Cross-browser testing with Chrome, Firefox, Edge, and Safari
- **Page Object Model**: Maintainable and scalable test architecture
- **TestNG Framework**: Advanced test execution, grouping, and reporting
- **Data-Driven Testing**: CSV, Excel, and JSON data sources
- **Screenshot & Video Capture**: Visual test evidence and debugging
- **Cross-Browser Testing**: Parallel execution across multiple browsers
- **CI/CD Integration**: GitHub Actions and Jenkins pipeline ready

## 🛠️ Technologies Used

- Java 11+
- Selenium WebDriver 4.15.0
- TestNG 7.7.0
- Maven 3.8+
- WebDriverManager for driver management
- Allure Reporting
- ExtentReports
- Apache POI for Excel data handling

## 📁 Project Structure

```
web-testing-automation/
├── src/
│   ├── main/java/
│   │   ├── pages/               # Page Object Model classes
│   │   ├── utils/               # Utility classes
│   │   ├── config/              # Configuration management
│   │   └── drivers/             # WebDriver management
│   └── test/java/
│       ├── tests/               # Test classes
│       ├── data/                # Test data files
│       ├── listeners/           # TestNG listeners
│       └── utils/               # Test utilities
├── src/test/resources/
│   ├── data/                    # Test data files
│   ├── config/                  # Configuration files
│   └── testng.xml              # TestNG configuration
├── reports/                     # Test reports
├── screenshots/                 # Screenshot captures
├── videos/                      # Video recordings
└── pom.xml                     # Maven configuration
```

## 🚀 Quick Start

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd web-testing-automation
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Run tests**
   ```bash
   mvn test
   ```

4. **Run specific test suite**
   ```bash
   mvn test -DsuiteXmlFile=src/test/resources/testng.xml
   ```

5. **Generate reports**
   ```bash
   mvn allure:serve
   ```

## 🌐 Test Coverage

- **E-commerce Testing**: Product search, cart management, checkout process
- **Form Validation**: Registration, login, contact forms
- **UI/UX Testing**: Responsive design, accessibility, user interactions
- **Cross-Browser Testing**: Chrome, Firefox, Edge, Safari compatibility
- **Performance Testing**: Page load times, element visibility
- **Security Testing**: Input validation, XSS prevention

## 🔧 Configuration

Update `src/test/resources/config.properties` for environment settings:

```properties
# Browser Configuration
browser.name=chrome
browser.headless=false
browser.window.maximize=true

# Test URLs
base.url=https://demoqa.com
test.url=https://the-internet.herokuapp.com

# Timeouts
implicit.wait=10
explicit.wait=20
page.load.timeout=30

# Screenshot Configuration
screenshot.on.failure=true
screenshot.path=screenshots/
```

## 📊 Reports

- **Allure Reports**: Detailed test execution with screenshots
- **ExtentReports**: HTML reports with test categorization
- **TestNG Reports**: Standard TestNG reporting
- **Video Recording**: Test execution videos for debugging

## 🎯 Test Scenarios

### E-commerce Testing
- Product search and filtering
- Add to cart functionality
- Checkout process validation
- Payment form testing
- Order confirmation

### Form Testing
- User registration
- Login validation
- Contact form submission
- Input field validation
- Error message verification

### UI/UX Testing
- Responsive design testing
- Cross-browser compatibility
- Accessibility testing
- Visual regression testing
- User interaction flows

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Add your test cases
4. Ensure all tests pass
5. Submit a pull request

## 📄 License

This project is licensed under the MIT License.

## 👨‍💻 Author

**Mahad Siddiqui** - Senior Test Automation Engineer
- GitHub: [@Mahad28](https://github.com/Mahad28)
- Upwork: [Profile](https://www.upwork.com/freelancers/~0184717814212a8366)
- Email: mahadsiddiqui@gmail.com
