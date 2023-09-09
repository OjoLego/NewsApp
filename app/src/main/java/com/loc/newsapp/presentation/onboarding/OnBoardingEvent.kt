package com.loc.newsapp.presentation.onboarding

// This Kotlin class represents an event in the onboarding process of a news app.
// It is sealed, meaning that it has a closed set of subclasses, and here, it has only one subclass.
// OnBoardingEvent.SaveAppEntry is used to signal that the user has saved their app entry during onboarding.
 sealed class OnBoardingEvent {

     object SaveAppEntry: OnBoardingEvent()

}