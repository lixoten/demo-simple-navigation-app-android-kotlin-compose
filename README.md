# Demo Simple Navigation App
Simple app to demonstrate Compose screen navigation

**Demo App with 4 screen.**

**Navigates from**
- Home Screen to a List Screen. Nothing passed. simple route
- List Screen to Detail screen. We pass an Integer in the route
- Detail Screen to Forth Screen. We pass a the inputted string in the route
- Forth Screen back to Home Screen. We popStack with false 


We are not using the enum or sealed class for ScreenDestinations
In each screen we have a XxxxScreenDestination object defined on top of screen class

<p style=float:left">  
  <img src="screenshot_01.png" width="250" />  
  <img src="screenshot_02.png" width="250" />  
  <img src="screenshot_03.png" width="250" />  
  <img src="screenshot_04.png" width="250" />  
</p>

ref: demo-simple-navigation-app-android-kotlin-compose