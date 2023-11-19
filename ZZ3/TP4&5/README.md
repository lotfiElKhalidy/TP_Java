# TP5_Java

- Use an IDE to run this code. For example : `Visual Studio, IntelliJ Idea, Eclipse,..`
- The package `TP5` contains the whole solution (`src` with the different methods implemented and `test` with the several tests written).
- The file `Main.java` contains a menu that asks the user for the name of a city and returns the weather info on this city (if it exists).

# Principle

- The Main of this code offers a menu displayed in the terminal for the user.
- The user should give a name of a city (should be valid or an exception occurs).
- The only way possible to quit the program is by entering "q" or "Q".
- If the user wants to display all the data available in the local db, he should press "d" or "D".
- Once a city name is given, the program is going to look for this city in the database.
- `1st case`: If the data available in the local db is valid (meaning the request for this data was made in less than 10 minutes), the program is going to use this data without calling the API (cache).
- `2nd case`: If the data available in the local db is not valid, the program is going to call the API to get the latest temperature and update the data of the local db.
- `3rd case`: If no information on the city the user is looking for was found, the program is going call the API and insert this new data.