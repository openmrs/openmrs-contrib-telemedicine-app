# Guide to app architecture
The Nigeria Telemedicine app follows the [google's guide to app architecture](https://developer.android.com/jetpack/docs/guide) which
is loosely based on the MVVM architecture pattern. The app uses the android jetpack components in synergy while following the core principles
of the MVVM architecture pattern. A basic overview of our app architecture would look like this
![OverView of app architecture](https://user-images.githubusercontent.com/37406965/60755285-2d80a200-a00b-11e9-842c-0e4304acbcdb.png)
### Introduction to MVVM architecture pattern in android
MVVM stands for Model-View-ViewModel. The main objective of any architecture pattern followed nowadays is separation of concerns and 
MVVM architecture pattern does excellent justice to this property. Also MVVM acritecture pattern is easy to use and adapt if you are
new to it. 
### The View  
The View is the actual user interface in the app. It can be an Activity, a Fragment or any custom Android View that informs the
ViewModel about the user’s actions.The View is dumb and should not make any decisions or contain any business logic.  
### The ViewModel 
The ViewModel works as a mediator between the Model and the View by exposes streams of data relevant to the View. The ViewModel does
not know about the existence of the View. Any communication to be made from the ViewModel to the view is made possible by using the 
reactive streams from the ViewModel being observed by the View. We use LiveData for this purpose.  
### The Model/DataModel 
The Model abstracts the data source. The ViewModel works with the DataModel to get and save the data. The Model classes don't know
about the existence of the ViewModel classes and commiunicate via the same reactive patterns using LiveData as in the case above.
<br>
### In app overview
The app components are split into separate directories with each Activity/Fragment and its associated ViewModel in that directory.
The separate api directory mainly consists of the POJO's, API processing classes, and other helper classes for networking. As shown in the 
diagram above all the database and networking operations are accesed via the Repository class. App architecture should be strictly
followed while contributing and any deviations from it should be explicitly mentioned along with the reason to be looked up my the
mentors before merging your code in the codebase.
<br> 

