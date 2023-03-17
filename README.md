# User-Article API with JWT-based Security
This project provides a simple API for managing users and their articles. The API is secured with JWT-based authentication.

## API Endpoints
The following endpoints are available:
- POST /register - Registration a new user for authentication
- POST /login - log in to obtain access for app
- GET /users?ageGreaterThan={age} - Returns a list of users with an age greater than the specified value.
- GET /users/articles/{color} - Returns a list of users with articles of the specified color.
- GET /users/unique-names/articles/{articles} - Returns a list of unique user names with more than the specified number of articles.
- POST /users - Creates a new user.
- POST /articles - Creates a new article.

## Security
The API is secured with JWT-based authentication. To access the protected endpoints, a valid JWT token must be included in the Authorization header of the request.

## Building and Running the Application 
Clone the app from git repository and run the following command in the project root directory:
`mvn clean package`

## How to test app
1. You can use Postman collection to test endpoints link
2. Log in to obtain JWT as default user with credentials: 
       email: bob@gmail.com; password: 12345678;
    Or you can register a new user
3. Use obtained token in Authorization block, Bearer Token type for other requests
    