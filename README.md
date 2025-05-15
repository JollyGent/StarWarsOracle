# Star Wars Oracle

An Encyclopedia that lets the user search for information about the canon universe of the Star Wars franchise. It's helpful for people just getting into Star Wars, or a fun past time for those hard core fans who want to read more
about the lore.

## How It's Made:
**Tech used:** Kotlin, MVVM architecture with Hilt and JetPack Compose

Utilising the Model-View-ViewModel architecture, all the calls from the API endpoints had models that acted as abstraction of the data retrieved via the GET request. Coroutine was set up in the ViewModel so that
resources can be used efficiently, as while the scope of the ViewModel is active business logic can be processed and suspended immediately if the ViewModel is no longer used.

Dependency Injection was used to allow for code reusability, and as code is de-coupled in DI it allows for easy expansion of features in the application. It also allows for easier testing with injecting mock
dependencies. As opposed to Dagger Hilt was used as it was more approachable and readable. AppModule was created to build and provide the api. Repository pattern was used, abstracting data layer and separating them
from the rest of the application, thus improving code flexibility as it further allows easier expansion and maintainability.

As for the screens created using the JetPack Compose framework was used as opposed to Data Binding, due to the fact that JetPack Compose is more of a scalable solution and more efficient in performance.
The HomeScreen is a simple page with a TextField, where users can enter either vehicles, films or starships to navigate to - which happens in separate screens with respective viewmodels. Input validation is
also used to make sure that the user inputs are valid, and an error message is shown if invalid endpoints are written.

On every results page, there are two buttons in a row which determines how the list is sorted, utilising the sortBy() method to make sure that users can choose to sort the list by title/name if they wished.

LazyColumn was used in order to create a scrollable list that can contain all the information retrieved from the endpoints and 'state' of the retrieved calls were observed and shown as items, each item
being inside a card with annotatedStrings give readability for the users.


# Self feedback 

In this specific instance, due to the time constraints, the StarWarsRepository contains all of the endpoint calls, but I think it would be better if individual screens had individual repositories in order to adhere to
SOLID principles better.
