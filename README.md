# Gaming Tournament Platform Backend

This repository contains the backend implementation for the Gaming Tournament Platform. The backend is built using Spring Boot and connects to a PostgreSQL database to manage tournament data. Docker is used to simplify the setup and deployment process.

## Features

- **Tournament Management**: Create and fetch tournament details.
- **Filtering**: Filter tournaments by status ("Upcoming" or "Completed").
- **Searching**: Search tournaments by title or game name.
- **Database Seeding**: Automatically seeds the database with sample tournament data if empty.

## Tech Stack

- **Backend**: Spring Boot (Java)
- **Database**: PostgreSQL
- **Containerization**: Docker

## Setup Instructions

### Prerequisites

- Docker installed on your machine
- Docker Compose (optional, for easier setup)

### Steps to Run the Backend with Docker

1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd <repository-directory>
   ```

2. **Configure Environment Variables**:
   Create a `.env` file in the root directory of the project with the following content:
   ```
   DATABASE_URL=jdbc:postgresql://localhost:5432/yourdatabase
   DATABASE_USER=yourusername
   DATABASE_PASSWORD=yourpassword
   ```

3. **Build and Run the Docker Container**:
   ```bash
   docker-compose up --build
   ```

   This command will build the Docker image and start the Spring Boot application along with the PostgreSQL database.

4. **Access the API**:
   The backend API will be available at `http://localhost:8080`.

## API Endpoints

- **GET /api/tournaments**: Fetch all tournaments.
- **GET /api/tournaments/{id}**: Fetch a single tournament by ID.
- **GET /api/tournaments/status/{status}**: Fetch tournaments by status ("Upcoming" or "Completed").
- **GET /api/tournaments/search?query={query}**: Search tournaments by title or game name.
- **POST /api/tournaments**: Create a new tournament (sample payload can be used for testing).

## Database Schema

The `tournaments` table contains the following fields:
- `id` (auto-incremented)
- `title` (string)
- `game_name` (string)
- `date` (date)
- `prize_pool` (decimal)
- `status` (string: "Upcoming" or "Completed")
- `description` (text)

## Sample Data

The database is seeded with the following sample tournaments if it is empty:

| ID | Title | Game Name | Date | Prize Pool | Status | Description |
| --- | --- | --- | --- | --- | --- | --- |
| 1 | Winter Clash 2025 | Valorant | 2025-03-10 | 5000.00 | Upcoming | 5v5, Best of 3, Open to all |
| 2 | Apex Legends Showdown | Apex Legends | 2025-02-20 | 3000.00 | Completed | Trios, $1000 per player |
| 3 | CS:GO Pro League | CS:GO | 2025-04-01 | 10000.00 | Upcoming | 5v5, Bracket Style |

## Deployment

The backend can be deployed on platforms like Heroku or DigitalOcean. Ensure that the environment variables are correctly set for the deployment environment. Using Docker can simplify the deployment process.

## Bonus

- The application is deployed and accessible at [Live URL](https://tournament-45zp.onrender.com/).

## Assumptions and Trade-offs

- Due to the 2-day timeline, the focus was on delivering a functional backend with essential features.
- Error handling and validation are basic and can be enhanced for production use.
- The frontend integration is assumed to be handled separately, with the backend providing the necessary API endpoints.

---

This updated README includes instructions for setting up and running the backend using Docker, simplifying the process for developers. For any questions or further details, feel free to reach out.
