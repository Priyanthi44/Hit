# Hit

This is a sample Android application that demonstrates modern Android app development practices. The app fetches a list of "hits" from a remote source, likely using web scraping, and displays them to the user.

## Features

*   Fetches and displays a list of items.
*   Uses web scraping to gather data.
*   Caches network responses for improved performance and offline access.
*   Built entirely with Kotlin and a modern UI using Jetpack Compose.

## Tech Stack & Libraries

*   **UI:** [Jetpack Compose](https://developer.android.com/jetpack/compose) for building the user interface declaratively.
*   **Networking:** [Retrofit](https://square.github.io/retrofit/) and [OkHttp](https://square.github.io/okhttp/) for efficient network requests and caching.
*   **Web Scraping:** [Jsoup](https://jsoup.org/) for parsing HTML content.
*   **Asynchronous Programming:** [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) for managing background threads.
*   **Image Loading:** [Coil](https://coil-kt.github.io/coil/) for loading images in Jetpack Compose.
*   **Dependency Injection:** A simple manual DI pattern is used via the `AppModule` interface.
*   **Persistence:** [Room](https://developer.android.com/jetpack/androidx/releases/room) for local data storage.

## Project Structure

The project follows a standard Android application structure:

*   `app/src/main/java/com/gymshark/hits/`: Contains the core source code.
    *   `di`: Handles dependency injection setup.
    *   `network`: Includes the Retrofit `HitsAPI` interface.
    *   `repository`: The `HitsRepository` class for managing data operations.
    *   `ui`: Jetpack Compose composables, screens, and ViewModels.
    *   `utils`: Contains constants and utility functions.

## How to Build

1.  **Clone the repository:**
    ```bash
    git clone <repository-url>
    ```
2.  **Open in Android Studio:**
    Open the cloned project in Android Studio.
3.  **Sync Gradle:**
    Let Android Studio sync the project with the Gradle files to download all the necessary dependencies.
4.  **Run the app:**
    Build and run the application on an Android emulator or a physical device.
