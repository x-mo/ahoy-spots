# ahoy-spots

## Dependencies

In order for this project to run you need to supply the Open Charge Map Key in local.properties under
```` 
```
openchargemap.key = <KEY>

```
````

## Structure
#### This Project is modularized into:

**Core:** Contain core parts that is needed by all of the other modules, responsible for Network, Database, core Dependency Injection, Base Classes, etc..  

**App:** Initializes project's core components, and has the project's Single Activity, and Navigation Graph.

**Feature Modules:** Independent dynamic delivery features such as the List module which is currently responsible for all the app's logic.

Strictly following the MVVM pattern so it's quite self-descriptive, Dagger2 has been used for DI, RoomDatabase to chache the spots data and act as a single source of truth accross the app. The navigation component and DataBinding as well.

Google's Fuse API is used to acquire the user's fine location to grab the relevant charging spots sorted by distance, and PermissionX to to manage runtime permissions.


Possible Enhancements:
- General UI enhancements and adding of visual elements.
- MapView to view pins of surronding charging spots visually.
- SwipeRefresh Layout to update views.
- Centralize/Organize Gradle files
