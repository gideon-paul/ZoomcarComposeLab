# Zoomcar Compose Lab
## The Motivation
With the advent of Jetpack compose, developers could rapidly develop the user interfaces. The Previews for a written piece of UI code is shown in the IDE itself in a sidebar. There is one small catch though - the entire project needs to be built successfully for the UI Previews to work.

While coding UI components in a large codebase, mistakes will flare up in one place or the other. That makes it harder to concentrate on the task at hand i.e building UI Components. For example, the main Zoomcar Android app is a magnificent project with a ton of code. One tiny error in a totally unrelated module in that project will stall the entire UI building process making experimentation and rapid iteration uneconomical.

Moreover, in the main repo, the build times will be long. A developer shouldn't have to sit and wait for the entire project to build, just to see if a simple change in UI is properly reflected or not.

This project provides a solution for that problem by providing a minimalistic codebase. With less lines of code there are less distractions, build times are faster.

## How to use?
Run a **_git submodule init and update_** to get all the required submodules.

This project includes the uikit, so all the Zoomcar flavoured components are readily available.

Build the UI components in this project, rapidly iterate and experiment. When done, copy paste the code in other projects.

## Maintenance
This project is meant to be used as a supplement to the main Zoomcar Android app. So make sure to reciprocate any library version updates from that project.
