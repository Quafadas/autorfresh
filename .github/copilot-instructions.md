# Project Overview

This project is an experiment in vibe-coding scala js.

Serve the app with `mill -w app.serve`, it should appear on localhost:8080.

Use playwright MCP to inspect the current app state and manipulate it.

## Folder Structure

- `app/src`: Contains the source code for the frontend.
- `out/QuillST/scalablyTypedImportTask.dest/src/typings` - Contains the generated Scala.js facades by ScalablyTyped, for the TS modules in `package.json`.

## Process

Before starting to edit, check the console to see if mill is already in watch mode. If not, start it with `mill -w app.serve`. This will;

- compile on changes
- refresh the page on changes

 at `localhost:8080`.

 After each change, check the termainal (or the metals MCP compile task) to validate that the code compiles.

 If the code is compiling and running you should be able to observe compile error and changes without continually restarting the server.

## Libraries and Frameworks

- Laminar, scala JS, webaweomeme for UI components via a facade
- Use ESModule imports in build.mill (no bundler, just native ESModules in the browser)

## Coding Standards

Follow scala best practises

## UI guidelines

- A toggle is provided to switch between light and dark mode.
- Application should have a modern and clean design.