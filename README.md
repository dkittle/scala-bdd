# Introduction

I'm working on a project structure which executes selenium tests against a web application.  My goal is to practice BDD (Behaviour Drive Development) with my team so devs have a bit more responsibility for the user stories they are  implementing - specifically that they at least cover off a happy path test of the stories they implement that have some sort of user interface.

# Project setup

One needs to have at least one Selenium driver downloaded and installed on your development machine.  There is a `javaOptions` line in `build.sbt` which tells Selenium the path to the driver.
 
# Project internals

There are a few interesting traits to provide some magic for the code.

## Driver Selection

An implicit for the Selenium driver is created by the DriverSelector trait.  The trait uses a `javaOption` called `browser` to instantiate the correct Selenium driver.  By default, it creates a PhantomJS driver.

Driver selection is structure in such a way where using the trait should not create more than one instance of a driver.

I'm temporarily grabbing the phantomjs binary from [here](https://github.com/eugene1g/phantomjs/releases) for Mac OSX
   Yosemite as the official driver has a Yosemite bug.
   
I'm grabbing the Chrome driver from [here](https://code.google.com/p/selenium/wiki/ChromeDriver)

| Value | Driver Used |
| ----------|------------------|
| *none* | PhantomJS |
| `chrome` | ChromeDriver |
| `firefox` | FirefoxDriver |
| `safari` | SafariDriver |
| `ie` | InternetExplorerDriver | 


## Per Environment Configuration

With any BDD tests, one oftens needs to define environment specific settings that faciliate testing.  The `Configurator` trait keys off of a `javaOption` called `env` to set vals within the trait.  This includes setting a `baseAppUrl` which is the prefix for the `Page Object` URLs. 

# Page Objects

Each page or significant portion of a page will have an associated page class that encapsulates access to elements of the page or encapsulates interactions with the page.

# The BDD Tests

The tests themselves are in `Spec` files using the FlatSpec test style.

# Running Tests

I'm currently specifying `VM Parameters` in the `Run Configuration` as I run the Spec files.  I use `-Dbrowser=chrome -Denv=dev`.
