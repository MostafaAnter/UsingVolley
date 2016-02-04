# Android working with Volley Library

Volley comes with lot of features. Some of them are
- Request queuing and prioritization
- Effective request cache and memory management
- Extensibility and customization of the library to our needs
- Cancelling the requests
# Creating New Project

1. In Android Studio, create a new project by navigating to File ⇒ New Project and fill all the required details. When it prompts to select a default activity, select Blank Activity and proceed.
2. Create two packages named app and utils to keep the project organized.
3. Open build.gradle and add volley support by adding compile ‘com.mcxiaoke.volley:library-aar:1.0.0’ under dependencies section.
# Creating Volley Singleton Class

The best way to maintain volley core objects and request queue is, making them global by creating a singleton class which extends Application object.
4. Under utils package, create a class named LruBitmapCache.java and paste the below code. This class is required to handle image cache.
5. Under app package, create a class name AppController.java and extend the class from Application and add the following code.
6. Now open AndroidManifest.xml and add this singleton class in <application> tag using android:name property to execute the class automatically whenever app launches. Also add INTERNET permission as we are going to make network calls.
