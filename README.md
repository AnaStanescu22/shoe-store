## Shoe-store 

This sample Kotlin app shows a list of custom shoes added by the users. 

The app displays the content with RecyclerView and uses a traditional adapter. 

The architecture is MVVM where the ShoeListViewModel is in charge of preparing the UI state for the MainActivity. The activity listens for state changes through Flow observing. 

For image loading, the app uses Coil.
